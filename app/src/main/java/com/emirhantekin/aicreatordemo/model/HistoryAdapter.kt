package com.emirhantekin.aicreatordemo.model

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.emirhantekin.aicreatordemo.ApiState
import com.emirhantekin.aicreatordemo.R
import com.emirhantekin.aicreatordemo.data.User
import com.emirhantekin.aicreatordemo.databinding.FragmentHistoryBinding
import com.emirhantekin.aicreatordemo.databinding.ItemBinding
import com.emirhantekin.aicreatordemo.service.Text2ImageService
import org.w3c.dom.Text

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {
    private var list = emptyList<User>()



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]

        holder.itemView.findViewById<TextView>(R.id.textView22).text = currentItem.text

        val bitmap = BitmapFactory.decodeByteArray(list[position].img, 0, list[position].img.size)
        (Activity()).runOnUiThread {
            holder.itemView.findViewById<ImageView>(R.id.imageView6).setImageBitmap(bitmap)
        }


    }

    fun setData(user: List<User>) {
        this.list = user
        notifyDataSetChanged()
    }
}
