package com.jamshaidsapplication.app.modules.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.databinding.RowExcersiseBinding
import com.jamshaidsapplication.app.modules.home.`data`.model.ExcersiseRowModel
import kotlin.Int
import kotlin.collections.List

class ExcersiseAdapter(
  var list: List<ExcersiseRowModel>
) : RecyclerView.Adapter<ExcersiseAdapter.RowExcersiseVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowExcersiseVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_excersise,parent,false)
    return RowExcersiseVH(view)
  }

  override fun onBindViewHolder(holder: RowExcersiseVH, position: Int) {
    val excersiseRowModel = ExcersiseRowModel()
    // TODO uncomment following line after integration with data source
    // val excersiseRowModel = list[position]
    holder.binding.excersiseRowModel = excersiseRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ExcersiseRowModel>) {
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
      item: ExcersiseRowModel
    ) {
    }
  }

  inner class RowExcersiseVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowExcersiseBinding = RowExcersiseBinding.bind(itemView)
  }
}
