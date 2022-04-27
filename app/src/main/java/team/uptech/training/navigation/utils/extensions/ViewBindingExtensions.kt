package team.uptech.training.navigation.utils.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import team.uptech.training.navigation.utils.viewbinding.FragmentViewBindingDelegate


inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
  crossinline bindingInflater: (LayoutInflater) -> T
): Lazy<T> {
  return lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
  }
}

fun <T : ViewBinding> Fragment.viewBinding(
  viewBindingFactory: (View) -> T
): FragmentViewBindingDelegate<T> {
  return FragmentViewBindingDelegate(this, viewBindingFactory)
}

inline fun <T : ViewBinding> ViewGroup.viewGroupBinding(
  crossinline bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T
): T {
  return bindingInflater.invoke(LayoutInflater.from(context), this, true)
}

inline fun <T : ViewBinding> View.viewBinding(
  crossinline bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T
): T {
  return bindingInflater.invoke(LayoutInflater.from(context), null, false)
}

fun <T : ViewBinding> BottomSheetDialogFragment.viewBinding(
  viewBindingFactory: (View) -> T
): FragmentViewBindingDelegate<T> {
  return FragmentViewBindingDelegate(this, viewBindingFactory)
}
