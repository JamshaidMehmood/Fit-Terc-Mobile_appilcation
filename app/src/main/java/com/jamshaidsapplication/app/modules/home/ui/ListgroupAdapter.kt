package com.jamshaidsapplication.app.modules.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.databinding.RowListgroupBinding
import com.jamshaidsapplication.app.modules.home.`data`.model.ListgroupRowModel
import kotlin.Int
import kotlin.collections.List

class ListgroupAdapter(
  var list: List<ListgroupRowModel>
) : RecyclerView.Adapter<ListgroupAdapter.RowListgroupVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListgroupVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listgroup,parent,false)
    return RowListgroupVH(view)
  }

  override fun onBindViewHolder(holder: RowListgroupVH, position: Int) {
    val listgroupRowModel = ListgroupRowModel()
    // TODO uncomment following line after integration with data source
    // val listgroupRowModel = list[position]
    holder.binding.listgroupRowModel = listgroupRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListgroupRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ListgroupRowModel
    ) {
    }
  }

  inner class RowListgroupVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListgroupBinding = RowListgroupBinding.bind(itemView)
  }
}
