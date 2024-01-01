package com.jamshaidsapplication.app.modules.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseFragment
import com.jamshaidsapplication.app.databinding.FragmentHomeBinding
import com.jamshaidsapplication.app.modules.home.`data`.model.ExcersiseRowModel
import com.jamshaidsapplication.app.modules.home.`data`.model.ListgroupRowModel
import com.jamshaidsapplication.app.modules.home.`data`.viewmodel.HomeVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
  private val viewModel: HomeVM by viewModels<HomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val listgroupAdapter = ListgroupAdapter(viewModel.listgroupList.value?:mutableListOf())
    binding.recyclerListgroup.adapter = listgroupAdapter
    listgroupAdapter.setOnItemClickListener(
    object : ListgroupAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListgroupRowModel) {
        onClickRecyclerListgroup(view, position, item)
      }
    }
    )
    viewModel.listgroupList.observe(requireActivity()) {
      listgroupAdapter.updateData(it)
    }
    val excersiseAdapter = ExcersiseAdapter(viewModel.excersiseList.value?:mutableListOf())
    //binding.recyclerExcersise.adapter = excersiseAdapter
    excersiseAdapter.setOnItemClickListener(
    object : ExcersiseAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ExcersiseRowModel) {
        onClickRecyclerExcersise(view, position, item)
      }
    }
    )
    viewModel.excersiseList.observe(requireActivity()) {
      excersiseAdapter.updateData(it)
    }
    binding.homeVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListgroup(
    view: View,
    position: Int,
    item: ListgroupRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerExcersise(
    view: View,
    position: Int,
    item: ExcersiseRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "HOME_FRAGMENT"


    fun getInstance(bundle: Bundle?): HomeFragment {
      val fragment = HomeFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
