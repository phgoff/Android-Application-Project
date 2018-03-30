package com.phgof.android_project.RecyclerList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.phgof.android_project.R;

/**
 * Created by Ph.GOF on 3/30/2018.
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    LayoutInflater mLayoutInflater;
    String [] list;
    int[] resId;
    ItemClickListener mItemClickListener;

    public RecyclerViewAdapter(Context context, String[] list,int[] resId) {
        mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.resId = resId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.activity_listview_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView1.setText(list[position]);
        holder.imageView1.setBackgroundResource(resId[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }
    public String getItem(int position) {
        return list[position];
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView textView1;
        public ImageView imageView1;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textView1);
            imageView1 = itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null )
                mItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
