package team.uptech.training.navigation.feature_two

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import team.uptech.training.navigation.core.BaseFragment
import team.uptech.training.navigation.databinding.FragmentFeatureTwoBinding


class FeatureTwoFragment : BaseFragment<FragmentFeatureTwoBinding>() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.mbDetails.setOnClickListener { btn ->
      btn.findNavController().navigate(FeatureTwoFragmentDirections.actionFragmentScope2ToFeatureTwoDetail())
    }
  }
}