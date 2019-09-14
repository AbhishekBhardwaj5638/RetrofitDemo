package com.bhardwaj.abhishek.Adapter;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bhardwaj.abhishek.model.UserInfo;
import com.bhardwaj.abhishek.retrofitdemo.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<UserInfo> userInfos;

    public RecyclerAdapter(List<UserInfo> userInfos){
        this.userInfos=userInfos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_item,viewGroup,false);
    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.userId.setText(Integer.toString(userInfos.get(i).getUserId()));
        myViewHolder.itemId.setText(Integer.toString(userInfos.get(i).getId()));
        myViewHolder.title.setText(userInfos.get(i).getTitle());
        myViewHolder.body.setText(userInfos.get(i).getBody());

    }


    @Override
    public int getItemCount() {
        return userInfos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userId,itemId,title,body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userId=(TextView)itemView.findViewById(R.id.userId);
            itemId=(TextView)itemView.findViewById(R.id.itemId);
            title=(TextView)itemView.findViewById(R.id.itemTitle);
            body=(TextView)itemView.findViewById(R.id.itemBody);
        }
    }
}
