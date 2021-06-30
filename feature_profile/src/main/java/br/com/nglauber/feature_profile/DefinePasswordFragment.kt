package br.com.nglauber.feature_profile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import br.com.nglauber.common.IOnBackPressed
import br.com.nglauber.common.NavigationLinks

class DefinePasswordFragment : Fragment(R.layout.fragment_define_password), IOnBackPressed {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.run {
            findViewById<Button>(R.id.btnOk).setOnClickListener {
                findNavController().popBackStack()
            }
            findViewById<Button>(R.id.btnHome).setOnClickListener {
                findNavController().popBackStack(R.id.homeFragment, false)
            }
            findViewById<Button>(R.id.btnHomeTwo).setOnClickListener {
                findNavController().navigate(R.id.action_go_home_again)
            }
        }
    }

    override fun onBackPressed(): Boolean {
        requireActivity().intent.data?.let {
            findNavController().popBackStack(R.id.welcomeFragment, false)
            if (it.getQueryParameter("product")?.isNotEmpty() == true) {
                findNavController().navigate(NavigationLinks.LINK_ONBOARDING_HOME)
            }
            return false
        } ?: run {
            return true
        }
    }
}
