package com.example.recyclerview3

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private val cities : ArrayList<String>)
    :RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    interface OnCityClickListener{
        fun onCityClick(position: Int,textView: TextView)
    }
    var onCityClickListener : OnCityClickListener? = null

    inner class CityViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtCity : TextView


        init {
           txtCity = view as TextView

            txtCity.setOnClickListener{
                if (onCityClickListener!=null){
                    onCityClickListener!!.onCityClick(adapterPosition,txtCity)
                }
            }
        }
    }

    override fun getItemCount() = cities.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val txtMessage = TextView(parent.context)
        txtMessage.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
        txtMessage.textSize = 20f
        txtMessage.setPadding(20,20,20,20)

        return CityViewHolder(txtMessage)

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.txtCity.text = cities[position]
    }
}