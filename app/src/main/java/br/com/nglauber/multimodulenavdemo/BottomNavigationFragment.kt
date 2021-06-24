package br.com.nglauber.multimodulenavdemo

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import br.com.nglauber.feature_onboarding.WelcomeFragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem

class BottomNavigationFragment : Fragment(R.layout.bottom_navigation_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botNav = view.findViewById<AHBottomNavigation>(R.id.view_bottom_navigation)

        botNav.addItem(getHomeBottomNavigationItem())
        botNav.addItem(getSecondHomeBottomNavigationItem())
        botNav.isBehaviorTranslationEnabled = false

        botNav.setOnTabSelectedListener { position, wasSelected ->
            when (position) {
                0 -> showFragment()
                1 -> showFragment()
            }
            false
        }
    }

    private fun showFragment() {
        parentFragmentManager.commit{
            setReorderingAllowed(true)
            add<WelcomeFragment>(R.id.nav_host_container)
        }
    }

    private fun getHomeBottomNavigationItem() =
        AHBottomNavigationItem(
            "Profile",
            ContextCompat.getDrawable(requireContext(), android.R.drawable.ic_menu_agenda),
            ContextCompat.getColor(requireContext(), br.com.nglauber.feature_onboarding.R.color.colorBottomNavigationPrimary))

    private fun getSecondHomeBottomNavigationItem() =
        AHBottomNavigationItem(
            "Password",
            ContextCompat.getDrawable(requireContext(), android.R.drawable.ic_menu_help),
            ContextCompat.getColor(requireContext(), br.com.nglauber.feature_onboarding.R.color.colorBottomNavigationPrimary))
}
