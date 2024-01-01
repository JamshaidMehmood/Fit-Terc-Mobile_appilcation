package com.jamshaidsapplication.app.modules.profile.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseFragment
import com.jamshaidsapplication.app.databinding.FragmentProfileBinding
import com.jamshaidsapplication.app.modules.profile.`data`.viewmodel.ProfileVM
import kotlin.String
import kotlin.Unit

class ProfileFragmentActivity : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
  private val viewModel: ProfileVM by viewModels<ProfileVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.profileVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "PROFILE_FRAGMENT"


    fun getInstance(bundle: Bundle?): ProfileFragmentActivity {
      val fragment = ProfileFragmentActivity()
      fragment.arguments = bundle
      return fragment
    }

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfileFragmentActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
