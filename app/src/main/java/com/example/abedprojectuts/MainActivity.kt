package com.example.abedprojectuts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.abedprojectuts.databinding.ActivityLoginBinding
import com.example.abedprojectuts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  foodRecyclerView: RecyclerView
    private lateinit var nama :ArrayList<String>
    private lateinit var harga: ArrayList<String>
    private lateinit var gambar: Array<Int>
    private lateinit var descripsi: ArrayList<String>
    private lateinit var foodList: ArrayList<DataFood>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tombol untuk berpindah ke halaman Profile
        val btnProfil : Button = findViewById<Button>(R.id.tvprofile)
        btnProfil.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            Toast.makeText (this, "halaman PROFILE", Toast.LENGTH_SHORT).show()
        }


        gambar = arrayOf(
            R.drawable.abet,
            R.drawable.abet3,
            R.drawable.abet4,
            R.drawable.abet5,
            R.drawable.abet6,
            R.drawable.abet7,
            R.drawable.abet3,
            R.drawable.abet8,
            R.drawable.abet9,
            R.drawable.abet10
        )

        nama = arrayListOf(
            "wortel sayuran dan burger",
            "sandwich dengan roti",
            "Tumis daging sapi",
            "buah berry dancokelat",
            "udang panggang",
            "Nasi Meksikoo",
            "Sandwich ham dan keju tomat",
            "Dua Ekor Lobster Rebus",
            "Dua Ekor Lobster Rebus ",
            "burger dengan api api"
        )

        harga = arrayListOf(
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000",
            "Rp. 120.000"
        )
        descripsi = arrayListOf(
            getString(R.string.des_burger),
            getString(R.string.des_satu),
            getString(R.string.des_dua),
            getString(R.string.des_tiga),
            getString(R.string.des_empat),
            getString(R.string.des_lima),
            getString(R.string.des_enam),
            getString(R.string.des_tujuh),
            getString(R.string.des_delapan),
            getString(R.string.des_sembilan)
        )

        foodRecyclerView = findViewById(R.id.foodRV)
        foodRecyclerView.layoutManager = LinearLayoutManager(this)
        foodRecyclerView.setHasFixedSize(true)

        foodList = arrayListOf<DataFood>()
        getDataUser()


    }

    private fun getDataUser() {
        for (i in gambar.indices) {
            val dataFood = DataFood(gambar[i], nama[i], harga[i])
            foodList.add(dataFood)
        }

        var adapter = FoodAdapter(foodList)
        foodRecyclerView.adapter = adapter
        adapter.setOnItemClickLiatener(object: FoodAdapter.onItemClickListener {
            override fun onItemClick(position : Int) {
                intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("idGambar", foodList[position].gambar)
                intent.putExtra("idNama", foodList[position].nama)
                intent.putExtra("idHarga", foodList[position].harga)
                intent.putExtra("idDeskripsi", descripsi[position])

                startActivity(intent)

            }

        })
    }
}