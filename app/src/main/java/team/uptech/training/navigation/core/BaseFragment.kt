package team.uptech.training.navigation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


abstract class BaseFragment<Binding : ViewBinding> : Fragment() {

  private var _binding: Binding? = null
  protected val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = createBindingInstance(inflater, container)
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  @Suppress("UNCHECKED_CAST")
  private fun createBindingInstance(inflater: LayoutInflater, container: ViewGroup?, attachNow: Boolean = false): Binding {
    val vbType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
    val vbClass = vbType as Class<Binding>

    val method = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)

    return method.invoke(null, inflater, container, attachNow) as Binding
  }
}