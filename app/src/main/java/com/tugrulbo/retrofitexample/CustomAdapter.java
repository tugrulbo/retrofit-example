package com.tugrulbo.retrofitexample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tugrulbo.retrofitexample.Models.Posts;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<Posts> postsList;
    Context context;

    public CustomAdapter(List<Posts> posts, Context context){
        this.postsList = posts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return postsList.size();
    }

    @Override
    public Object getItem(int position) {
        return postsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView userId = convertView.findViewById(R.id.userId);
        TextView id = convertView.findViewById(R.id.id);
        TextView title = convertView.findViewById(R.id.title);
        TextView body = convertView.findViewById(R.id.body);

        userId.setText(""+postsList.get(position).getUserId());
        id.setText(""+postsList.get(position).getId());
        title.setText(postsList.get(position).getTitle());
        body.setText(postsList.get(position).getBody());


        return convertView;
    }

}
