package com.example.recyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recycleCity: RecyclerView
    private lateinit var cityAdapter : CityAdapter
    val cities = ArrayList<String>()
    private lateinit var edtCity  :EditText
    private lateinit var btnAdd : Button
    private lateinit var btnDelete : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleCity = findViewById(R.id.recycleCity)
        edtCity = findViewById(R.id.edtCity)
        btnAdd = findViewById(R.id.btnAdd)
        btnDelete = findViewById(R.id.btnDelete)

        cityNames()

        cityAdapter = CityAdapter(cities)
        cityAdapter.onCityClickListener = MyCityClickListener()
        recycleCity.adapter = cityAdapter

        recycleCity.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        btnAdd.setOnClickListener {
            cities.add(edtCity.text.toString())
            cityAdapter.notifyItemInserted(cities.size-1)
        }
        btnDelete.setOnClickListener {
            val cityIndex = cities.indexOf(edtCity.text.toString())
            if (cityIndex!=-1){
                cities.remove(edtCity.text.toString())
                cityAdapter.notifyItemRemoved(cityIndex)
            }else{
                Toast.makeText(this,"city is not found",Toast.LENGTH_SHORT).show()
            }
        }

    }

    inner class MyCityClickListener : CityAdapter.OnCityClickListener{
        override fun onCityClick(position: Int, textView: TextView) {
            Toast.makeText(this@MainActivity,
                "action:${cities[position]} is clicked",
                Toast.LENGTH_SHORT).show()
        }
    }
    private fun cityNames(){
       cities.add("Pune")
        cities.add("Nagpur")
        cities.add("Mumbai")
        cities.add("Satara")
        cities.add("Kerla")
    }
}