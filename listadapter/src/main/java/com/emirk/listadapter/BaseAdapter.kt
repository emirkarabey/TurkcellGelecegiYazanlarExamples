package com.emirk.listadapter

import android.database.DataSetObserver
import android.widget.ListAdapter

abstract class BaseAdapter : ListAdapter {

    override fun isEnabled(position: Int): Boolean {
        return true
    }

    override fun areAllItemsEnabled(): Boolean {
        return false
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
    }

    override fun isEmpty(): Boolean {
        return count == 0
    }
}