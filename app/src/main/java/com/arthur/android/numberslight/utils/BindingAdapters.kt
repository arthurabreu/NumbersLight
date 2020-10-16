package com.arthur.android.numberslight.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthur.android.numberslight.R
import com.arthur.android.numberslight.listnumbers.adapter.ItemsAdapter
import com.arthur.android.numberslight.listnumbers.model.Numbers
import com.squareup.picasso.Picasso

@BindingAdapter("resultsList")
fun RecyclerView.bindItems(items: List<Numbers>?) {
    items?.let { val adapter = adapter as ItemsAdapter
        adapter.update(items) }
}

@BindingAdapter("imgUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
    }
}