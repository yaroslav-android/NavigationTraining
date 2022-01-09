package team.uptech.training.navigation.core

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import team.uptech.training.navigation.R
import team.uptech.training.navigation.utils.findNavFragment
import java.lang.reflect.ParameterizedType


abstract class BaseActivity<Binding : ViewBinding> : AppCompatActivity() {

  private var _binding: Binding? = null
  protected val binding get() = _binding!!

  private var _navHostFragment: NavHostFragment? = null
  protected val navHostFragment get() = _navHostFragment!!

  private var _navController: NavController? = null
  protected val navController get() = _navController!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding = createBindingInstance(layoutInflater)
    setContentView(binding.root)

    initArtifacts()
  }

  private fun initArtifacts() {
    if (_navHostFragment == null) {
      _navHostFragment = findNavFragment(R.id.nav_host_fragment)
    }
    if (_navController == null) {
      _navController = navHostFragment.navController
    }
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    initArtifacts()
  }

  override fun onDestroy() {
    _binding = null
    _navHostFragment = null
    _navController = null
    super.onDestroy()
  }

  @Suppress("UNCHECKED_CAST")
  private fun createBindingInstance(inflater: LayoutInflater): Binding {
    val vbType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
    val vbClass = vbType as Class<Binding>

    val method = vbClass.getMethod("inflate", LayoutInflater::class.java)

    return method.invoke(null, inflater) as Binding
  }
}