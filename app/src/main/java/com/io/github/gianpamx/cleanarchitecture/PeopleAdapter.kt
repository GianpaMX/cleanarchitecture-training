package com.io.github.gianpamx.cleanarchitecture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.list_item.view.nameTextView

class PeopleAdapter : Adapter<PeopleAdapter.ViewHolder>() {
  private val items = ArrayList<ItemData>()

  fun submitItems(items: List<ItemData>) {
    this.items.clear()
    this.items.addAll(items)

    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

  override fun getItemCount() = items.size

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    holder.bind(items[position])
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(itemData: ItemData) {
      itemView.nameTextView.text = itemData.name
    }
  }
}
