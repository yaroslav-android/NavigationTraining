package team.uptech.training.navigation.feature_one

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import team.uptech.training.navigation.core.BaseFragment
import team.uptech.training.navigation.databinding.FragmentFeatureOneBinding


class FeatureOneFragment : BaseFragment<FragmentFeatureOneBinding>() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.mbDetails.setOnClickListener { btn ->
      btn.findNavController().navigate(FeatureOneFragmentDirections.actionFragmentScope1ToFeatureOneDetail())
    }
  }
}