package team.uptech.training.navigation.utils.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment


fun AppCompatActivity.findNavFragment(id: Int) =
  supportFragmentManager.findFragmentById(id) as NavHostFragment