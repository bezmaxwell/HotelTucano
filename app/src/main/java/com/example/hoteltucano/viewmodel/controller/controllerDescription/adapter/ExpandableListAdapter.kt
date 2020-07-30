package com.example.hoteltucano.viewmodel.controller.controllerDescription.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.hoteltucano.R


class ExpandableAdapter(var context: Context, var header:MutableList<String>, var body:MutableList<MutableList<String>>): BaseExpandableListAdapter() {


    override fun getGroup(groupPosition: Int): String? {
            return header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView
            if(convertView == null) {
                val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = inflater.inflate(R.layout.group_expandable, null)
            }

        val titleTeste = convertView?.findViewById<TextView>(R.id.titleTeste)
        titleTeste?.text = getGroup(groupPosition)

        return  convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView

        if(convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.child_expandable,null)
        }
        val title = convertView?.findViewById<TextView>(R.id.titleTeste)
        title?.text = getChild(groupPosition,childPosition)

        return  convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }

}