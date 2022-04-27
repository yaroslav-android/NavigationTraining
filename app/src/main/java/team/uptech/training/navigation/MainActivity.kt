package team.uptech.training.navigation

import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import team.uptech.training.navigation.core.BaseActivity
import team.uptech.training.navigation.databinding.ActivityMainBinding
import team.uptech.training.navigation.utils.extensions.viewBinding

class MainActivity : BaseActivity() {

  private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.navigation.setupWithNavController(navController)
  }
}