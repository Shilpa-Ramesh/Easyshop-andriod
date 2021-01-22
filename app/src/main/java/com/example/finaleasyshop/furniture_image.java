package com.example.finaleasyshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class furniture_image extends RecyclerView.Adapter<furniture_image.ImageViewHolder> {
    private Context mContext;
    private List<Furniture_Upload> mUploads2;


    public  furniture_image(Context context, List<Furniture_Upload> furniture_upload) {
        mContext = context;
        mUploads2 = furniture_upload;

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.furniture_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Furniture_Upload uploadCurrent = mUploads2.get(position);

        holder.textViewName.setText(uploadCurrent.getName());
        holder.textViewPrice.setText("₹ " + uploadCurrent.getPrice());
        holder.textViewSize.setText("Size:" + uploadCurrent.getasize());
        Picasso.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_loading)
                .fit()
                .centerInside()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads2.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewPrice;
        public ImageView imageView;
        public TextView textViewSize;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPrice = itemView.findViewById(R.id.text_view_price);

            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewSize=itemView.findViewById(R.id.text_view_size);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    furniture_buy buyFragment = new furniture_buy();
                    Bundle bundle = new Bundle();
                    int position = getAdapterPosition();
                    Furniture_Upload current = mUploads2.get(position);
                    String name = current.getName();
                    bundle.putInt("position", position);
                    bundle.putString("name", name);
                    bundle.putString("price", current.getPrice());
                    bundle.putString("size",current.getasize());

                    if (imageView != null)
                        bundle.putString("imageUrl", current.getImageUrl());
                    else
                        bundle.putString("imageUrl", null);
                    bundle.putString("userName", current.getUserName());
                    bundle.putString("date", current.getDate());
                    bundle.putString("desc", current.getDesc());
                    bundle.putString("email", current.getEmail());
                    bundle.putString("key", current.getKey());

                    buyFragment.setArguments(bundle);


                    ((FragmentActivity) mContext)
                            .getSupportFragmentManager()
                            .beginTransaction().replace(R.id.frag_container, buyFragment)
                            .addToBackStack(null).commit();


                }
            });
        }


    }
}
