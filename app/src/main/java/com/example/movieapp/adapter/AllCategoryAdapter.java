package com.example.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.model.AllCategoryModel;
import com.example.movieapp.model.Category;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {

    Context context;
    List<AllCategoryModel> allCategoryModelList;

    public AllCategoryAdapter(Context context, List<AllCategoryModel> categoryModelList){
        this.context = context;
        this.allCategoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items,parent,false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.categoryImage.setImageResource(allCategoryModelList.get(position).getImgURL());
    }

    @Override
    public int getItemCount() {
        return allCategoryModelList.size();
    }

    public static class AllCategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }
}
