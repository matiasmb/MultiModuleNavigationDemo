package br.com.nglauber.multimodulenavdemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import java.lang.IndexOutOfBoundsException

class BottomNavigationFragment : Fragment(R.layout.bottom_navigation_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botNav = view.findViewById<AHBottomNavigation>(R.id.view_bottom_navigation)

        botNav.addItem(getHomeBottomNavigationItem())
        botNav.addItem(getSecondHomeBottomNavigationItem())

        botNav.setOnTabSelectedListener { position, _ ->
            when(position) {
                0 -> {
//                    findNavController()
//                        .navigate(
//                            br.com.nglauber.feature_onboarding.R.id.action_profile,
//                            bundleOf("user" to br.com.nglauber.common.User(1, "Nelson"))
//                        )
                }


                1 -> {
//                    findNavController().navigate(NavigationLinks.LINK_PASSWORD_CHANGE)
                }

                else -> throw IndexOutOfBoundsException()

            }
            false
        }
    }

    fun getHomeBottomNavigationItem() =
        AHBottomNavigationItem(
            "Profile",
            ContextCompat.getDrawable(requireContext(), android.R.drawable.ic_menu_agenda),
            ContextCompat.getColor(requireContext(), br.com.nglauber.feature_onboarding.R.color.colorBottomNavigationPrimary))

    fun getSecondHomeBottomNavigationItem() =
        AHBottomNavigationItem(
            "Password",
            ContextCompat.getDrawable(requireContext(), android.R.drawable.ic_menu_help),
            ContextCompat.getColor(requireContext(), br.com.nglauber.feature_onboarding.R.color.colorBottomNavigationPrimary))
}
