package com.emirk.listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emirk.listadapter.databinding.ItemListItemBinding


class ItemListAdapter(private val itemList: List<Item>) : BaseAdapter() {

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Item {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemListItemBinding
        if (convertView == null) {
            binding =
                ItemListItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ItemListItemBinding
        }
        val item = getItem(position)
        binding.titleTextView.text = item.title
        return binding.root
    }
}