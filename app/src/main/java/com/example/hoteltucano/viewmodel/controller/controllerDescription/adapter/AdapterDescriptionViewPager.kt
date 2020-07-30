package com.example.hoteltucano.viewmodel.controller.controllerDescription.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.hoteltucano.R
import com.squareup.picasso.Picasso

class AdapterDescriptionViewPager(private val context: Context, var list:List<String>):PagerAdapter()  {

    private var layoutInflater: LayoutInflater?=null

    override fun isViewFromObject(view: View, `object`: Any): Boolean { return  view === `object` }

    override fun getCount(): Int { return list.size }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider_image_layout,null)

        val image = view.findViewById<View>(R.id.images_slider_layout) as ImageView

        Picasso.get().load(list[position]).fit().error(R.drawable.common_google_signin_btn_icon_dark).into(image)

        container.addView(view,0)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) { container.removeView(`object` as View) }

}