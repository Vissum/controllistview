package com.example.controllistview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var countriesListView: ListView
    private lateinit var populationTextView: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countriesListView = findViewById(R.id.countriesListView)
        populationTextView = findViewById(R.id.populationTextView)

        val countries = resources.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        countriesListView.adapter = adapter

        countriesListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedCountry = countries[position]
            val population = getPopulation(selectedCountry)
            populationTextView.text = "Población de $selectedCountry: $population millones"
        }
    }

    private fun getPopulation(country: String): Int {

        return when (country) {
            "Argentina" -> 45
            "Bolivia" -> 11
            "Brasil" -> 211
            "Chile" -> 19
            "Colombia" -> 50
            "Ecuador" -> 17
            "Paraguay" -> 7
            "Perú" -> 33
            "Uruguay" -> 3
            "Venezuela" -> 32
            else -> 0
        }
    }
}
