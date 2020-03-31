package com.dpridoy.mvvmrecyclerviewapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dpridoy.mvvmrecyclerviewapp.R;
import com.dpridoy.mvvmrecyclerviewapp.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.user_list,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.login.setText(users.get(position).getLogin());
        holder.node_id.setText(users.get(position).getNodeId());
        holder.id.setText(String.valueOf(users.get(position).getId()));
        Glide.with(holder.imageView.getContext()).load(users.get(position).getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView login,id,node_id;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            login=itemView.findViewById(R.id.login);
            id=itemView.findViewById(R.id.id);
            node_id=itemView.findViewById(R.id.node_id);
        }
    }
}
