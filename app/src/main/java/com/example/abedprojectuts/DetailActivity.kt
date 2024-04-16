package com.example.abedprojectuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambar: ImageView = findViewById(R.id.iv_Gambar)
        val nama: TextView = findViewById(R.id.tv_Nama)
        val harga: TextView = findViewById(R.id.tv_Harga)
        val deskripsi: TextView = findViewById(R.id.tv_Deskripsi)

        val bundle: Bundle? = intent.extras
        val bNama = bundle!!.getString("idNama")
        val bGambar = bundle.getInt("idGambar")
        val bHarga = bundle.getString("idHarga")
        val bDeskripsi = bundle.getString("idDeskripsi")

        gambar.setImageResource(bGambar)
        nama.text = bNama
        harga.text = bHarga
        deskripsi.text = bDeskripsi
    }
}