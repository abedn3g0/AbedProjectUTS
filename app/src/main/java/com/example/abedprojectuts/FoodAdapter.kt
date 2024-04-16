package com.example.abedprojectuts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.animation.AnimatableView.Listener

class FoodAdapter (private val namaList: ArrayList<DataFood>): RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

private lateinit var mListener : onItemClickListener

interface onItemClickListener {
    fun onItemClick(position: Int)
}
    fun setOnItemClickLiatener(listener: onItemClickListener){
        mListener = listener
    }

    class MyViewHolder(itemData: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemData) {
        val gambar: ImageView = itemData.findViewById(R.id.idGambar)
        val nama: TextView = itemData.findViewById(R.id.idNama)
        val harga: TextView = itemData.findViewById(R.id.idHarga)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return MyViewHolder(itemData,mListener)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.harga.text = currentItem.harga
    }
}