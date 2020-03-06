package com.example.parstagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> allPosts) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUsername;
        private TextView tvCaption;
        private ImageView ivPostContent;

        public ViewHolder (@NonNull View itemView)
        {
            super(itemView);
            tvCaption.findViewById(R.id.tvCaption);
            tvUsername.findViewById(R.id.tvUsername);
            ivPostContent.findViewById(R.id.ivPostContent);
        }

        public void bind(Post post)
        {
            tvCaption.setText(post.getCaption());
            tvCaption.setText(post.getUser().getUsername());
            ParseFile img = post.getImage();
            if(img!= null)
            {
                Glide.with(context).load(post.getImage().getUrl()).into(ivPostContent);
            }
        }
    }
}
