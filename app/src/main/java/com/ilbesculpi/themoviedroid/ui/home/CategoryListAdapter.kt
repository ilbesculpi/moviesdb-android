package com.ilbesculpi.themoviedroid.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category

class CategoryListAdapter(context: Context, resourceId: Int, var objects: List<Category>)
    : ArrayAdapter<Category>(context, resourceId, objects) {
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        
        val row: View;
        var viewHolder: CategoryViewHolder;
        
        if( convertView == null ) {
            row = LayoutInflater.from(context)
                    .inflate(R.layout.category_list_item, parent, false);
            viewHolder = CategoryViewHolder();
            viewHolder.imageView = row.findViewById(R.id.image);
            viewHolder.titleLabel = row.findViewById(R.id.title);
            row.tag = viewHolder;
        }
        else {
            row = convertView;
            viewHolder = row.tag as CategoryViewHolder;
        }
        
        val category: Category = getItem(position);
        viewHolder.display(category);
        return row;
    }
    
    private class CategoryViewHolder {
        
        lateinit var imageView: ImageView;
        lateinit var titleLabel: TextView;
        
        fun display(category: Category) {
            titleLabel.text = category.name;
        }
        
    }
    
}