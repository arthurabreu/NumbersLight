package com.arthur.android.numberslight.listnumbers.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.arthur.android.numberslight.R
import com.arthur.android.numberslight.R.id.numberDetailsFragment
import com.arthur.android.numberslight.databinding.ItemViewBinding
import com.arthur.android.numberslight.listnumbers.NUMBERS
import com.arthur.android.numberslight.listnumbers.model.Numbers
import kotlinx.android.synthetic.main.item_view.view.itemLayout

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<Numbers> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && resultsList.size > position) {
            holder.bind(resultsList[position])

            holder.itemView.itemLayout.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    holder.itemView.setBackgroundColor(
                            ContextCompat.getColor(holder.itemView.context, R.color.colorPrimaryLight))
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    holder.itemView.setBackgroundColor(
                            ContextCompat.getColor(holder.itemView.context, R.color.colorAccent))
                }

                v?.onTouchEvent(event) ?: true
            }

            holder.itemView.itemLayout.setOnClickListener {
                val args = Bundle()
                holder.numbers?.name?.let { args.putInt(NUMBERS, it.toInt()) }
                Navigation.findNavController(holder.itemView).navigate(numberDetailsFragment, args)
            }
        }
    }

    fun update(items: List<Numbers>) {
        this.resultsList = items
        notifyDataSetChanged()
    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
            private val parent: ViewGroup,
            private val binding: ItemViewBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_view,
                    parent,
                    false
            )
    ) : ViewHolder(binding.root) {
        var numbers: Numbers? = null

        fun bind(item: Numbers) {
            this.numbers = item
            binding.adapter = ItemsAdapter()
            binding.text = item.name
            binding.image = item.image
        }
    }
}
