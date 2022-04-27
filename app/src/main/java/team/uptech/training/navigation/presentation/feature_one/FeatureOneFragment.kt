package team.uptech.training.navigation.presentation.feature_one

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import team.uptech.training.navigation.databinding.FragmentFeatureOneBinding
import team.uptech.training.navigation.utils.extensions.viewBinding


class FeatureOneFragment : Fragment() {

  private val binding: FragmentFeatureOneBinding by viewBinding(FragmentFeatureOneBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.mbDetails.setOnClickListener { btn ->
      btn.findNavController()
        .navigate(FeatureOneFragmentDirections.actionFragmentScope1ToFeatureOneDetail())
    }
  }
}