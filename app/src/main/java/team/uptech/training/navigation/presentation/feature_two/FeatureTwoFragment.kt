package team.uptech.training.navigation.presentation.feature_two

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import team.uptech.training.navigation.databinding.FragmentFeatureTwoBinding
import team.uptech.training.navigation.utils.extensions.viewBinding


class FeatureTwoFragment : Fragment() {

  private val binding: FragmentFeatureTwoBinding by viewBinding(FragmentFeatureTwoBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.mbDetails.setOnClickListener { btn ->
      btn.findNavController()
        .navigate(FeatureTwoFragmentDirections.actionFragmentScope2ToFeatureTwoDetail())
    }
  }
}