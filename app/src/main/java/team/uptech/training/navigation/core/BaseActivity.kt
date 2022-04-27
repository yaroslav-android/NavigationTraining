package team.uptech.training.navigation.core

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import team.uptech.training.navigation.R
import team.uptech.training.navigation.utils.extensions.findNavFragment


abstract class BaseActivity : AppCompatActivity() {

  private var _navHostFragment: NavHostFragment? = null
  protected val navHostFragment get() = _navHostFragment!!

  private var _navController: NavController? = null
  protected val navController get() = _navController!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
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
    _navHostFragment = null
    _navController = null
    super.onDestroy()
  }
}