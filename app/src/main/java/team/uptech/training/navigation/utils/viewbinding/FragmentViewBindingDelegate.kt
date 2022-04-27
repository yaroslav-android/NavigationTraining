package team.uptech.training.navigation.utils.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class FragmentViewBindingDelegate<T : ViewBinding>(
  val fragment: Fragment,
  val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T> {

  private val binding: T get() = _binding!!
  private var _binding: T? = null

  init {
    fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
      val viewLifecycleOwnerLiveDataObserver =
        Observer<LifecycleOwner?> {
          val viewLifecycleOwner = it ?: return@Observer

          viewLifecycleOwner.lifecycle.addObserver(
            object : DefaultLifecycleObserver {
              override fun onDestroy(owner: LifecycleOwner) {
                _binding = null
              }
            }
          )
        }

      override fun onCreate(owner: LifecycleOwner) {
        fragment.viewLifecycleOwnerLiveData
          .observeForever(viewLifecycleOwnerLiveDataObserver)
      }

      override fun onDestroy(owner: LifecycleOwner) {
        fragment.viewLifecycleOwnerLiveData
          .removeObserver(viewLifecycleOwnerLiveDataObserver)
      }
    })
  }

  override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
    if (_binding != null) {
      return binding
    }

    with(fragment.viewLifecycleOwner.lifecycle) {
      val lifecycleState = currentState.isAtLeast(Lifecycle.State.CREATED)
      check(lifecycleState) { "Attempt to get ViewBinding when Fragment destroyed." }
    }

    return viewBindingFactory(thisRef.requireView())
      .also { this._binding = it }
  }
}