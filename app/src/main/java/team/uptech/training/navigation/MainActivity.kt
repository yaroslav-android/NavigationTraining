package team.uptech.training.navigation

import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import team.uptech.training.navigation.core.BaseActivity
import team.uptech.training.navigation.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.navigation.setupWithNavController(navController)
  }
}