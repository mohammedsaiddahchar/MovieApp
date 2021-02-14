package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.movieapp.adapter.AllCategoryAdapter;
import com.example.movieapp.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;



public class AllCategory extends AppCompatActivity {

    RecyclerView allCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> categoryModelList;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        back = findViewById(R.id.back2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AllCategory.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allCategoryRecycler = findViewById(R.id.allCategory);
        //adding data to model
        categoryModelList = new ArrayList<>();
        categoryModelList.add(new AllCategoryModel(1, R.drawable.horror));
        categoryModelList.add(new AllCategoryModel(2, R.drawable.action));
        categoryModelList.add(new AllCategoryModel(3, R.drawable.adventure));
        categoryModelList.add(new AllCategoryModel(4, R.drawable.comedy));
        categoryModelList.add(new AllCategoryModel(5, R.drawable.drama));
        categoryModelList.add(new AllCategoryModel(6, R.drawable.classic));
        categoryModelList.add(new AllCategoryModel(7, R.drawable.sci_fi));
        categoryModelList.add(new AllCategoryModel(8, R.drawable.hollywood));

        setCategoryRecycler(categoryModelList);
    }

    private void setCategoryRecycler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(16), true));
        allCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }

    //spacing decoration

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}