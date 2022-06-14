package com.rumeysaozer.roomdaggerhilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.roomdaggerhilt.databinding.ItemRowBinding
import com.rumeysaozer.roomdaggerhilt.model.NameItem

class ImageAdapter(val nameList : ArrayList<NameItem>): RecyclerView.Adapter<ImageAdapter.ImageHolder>(){
    class ImageHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
      val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.binding.name.text = nameList[position].firstName
    }

    override fun getItemCount(): Int {
     return nameList.size
    }
    fun updateImageList(newNameList: List<NameItem>){
        nameList.clear()
        nameList.addAll(newNameList)
        notifyDataSetChanged()
    }
}