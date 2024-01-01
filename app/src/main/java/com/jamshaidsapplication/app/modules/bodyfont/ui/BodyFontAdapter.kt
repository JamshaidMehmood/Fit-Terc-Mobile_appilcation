package com.jamshaidsapplication.app.modules.bodyfont.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.databinding.RowBodyFontBinding
import com.jamshaidsapplication.app.modules.bodyfont.`data`.model.BodyFontRowModel
import kotlin.Int
import kotlin.collections.List

class BodyFontAdapter(
  var list: List<BodyFontRowModel>
) : RecyclerView.Adapter<BodyFontAdapter.RowBodyFontVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowBodyFontVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_body_font,parent,false)
    return RowBodyFontVH(view)
  }

  override fun onBindViewHolder(holder: RowBodyFontVH, position: Int) {
    val bodyFontRowModel = BodyFontRowModel()
    // TODO uncomment following line after integration with data source
    // val bodyFontRowModel = list[position]
    holder.binding.bodyFontRowModel = bodyFontRowModel
  }

  override fun getItemCount(): Int = 8
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<BodyFontRowModel>) {
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
      item: BodyFontRowModel
    ) {
    }
  }

  inner class RowBodyFontVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowBodyFontBinding = RowBodyFontBinding.bind(itemView)
  }
}
