package com.jamshaidsapplication.app.modules.homecontainer.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityHomeContainerBinding
import com.jamshaidsapplication.app.extensions.loadFragment
import com.jamshaidsapplication.app.modules.framesix.ui.FrameSixActivity
import com.jamshaidsapplication.app.modules.home.ui.HomeFragment
import com.jamshaidsapplication.app.modules.homecontainer.`data`.viewmodel.HomeContainerVM
import com.jamshaidsapplication.app.modules.profile.ui.ProfileFragmentActivity
import com.jamshaidsapplication.app.modules.tasks.ui.TasksActivity
import kotlin.String
import kotlin.Unit

class HomeContainerActivity :
    BaseActivity<ActivityHomeContainerBinding>(R.layout.activity_home_container) {
  private val viewModel: HomeContainerVM by viewModels<HomeContainerVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homeContainerVM = viewModel
    val destFragment = HomeFragment.getInstance(null)
    this.loadFragment(
    R.id.fragmentContainer,
    destFragment,
    bundle = destFragment.arguments,
    tag = HomeFragment.TAG,
    addToBackStack = false,
    add = false,
    enter = null,
   exit = null,
    )
  }

  override fun setUpClicks(): Unit {
    binding.frameActive.setOnClickListener {
      val destFragment = HomeFragment.getInstance(null)
      this.loadFragment(
      R.id.fragmentContainer,
      destFragment,
      bundle = destFragment.arguments,
      tag = HomeFragment.TAG,
      addToBackStack = true,
      add = false,
      enter = null,
      exit = null,
      )
    }

    binding.imageGroupOne.setOnClickListener {
      val intent = FrameSixActivity.getIntent(this, null)
      startActivity(intent)
    }


    binding.imageUsersquare.setOnClickListener {
      val destFragment = ProfileFragmentActivity.getInstance(null)
      this.loadFragment(
      R.id.fragmentContainer,
      destFragment,
      bundle = destFragment.arguments,
      tag = ProfileFragmentActivity.TAG,
      addToBackStack = true,
      add = false,
      enter = null,
      exit = null,
      )
    }
    
    binding.floatingBtnFloatingactionbutton.setOnClickListener {
      val destIntent = TasksActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "HOME_CONTAINER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomeContainerActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
