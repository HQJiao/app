package com.example.nav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mTextView2;

        public LinearLayout linearLayout;
        public ViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
            LinearLayout l1 = (LinearLayout) linearLayout.getChildAt(1);
            LinearLayout l2 = (LinearLayout) linearLayout.getChildAt(2);
            mTextView = (TextView)l1.getChildAt(0);
            mTextView2 = (TextView)l2.getChildAt(0);


            int childCount = linearLayout.getChildCount();
            for(int i=0;i<childCount;i++){
                View view = linearLayout.getChildAt(i);
                if (view instanceof LinearLayout){
                    break;
                }
            }
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
        holder.mTextView2.setText("00:42:21");
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}