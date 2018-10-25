package me.ajax.basearchitecture.ui.news.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import me.ajax.basearchitecture.R
import me.ajax.basearchitecture.ui.news.model.News
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import me.ajax.basearchitecture.databinding.ItemNewsBinding


class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var newses: List<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding: ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_news, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return newses.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        val binding: ItemNewsBinding = DataBindingUtil.getBinding(viewHolder.itemView)!!
        binding.news = this.newses[position]
        binding.executePendingBindings()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindTo(news: News) {
        }
    }
}