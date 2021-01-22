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

import java.text.BreakIterator;
import java.util.List;

public class car_image extends RecyclerView.Adapter<car_image.ImageViewHolder> {
    private Context mContext;
    private List<Car_Upload> mUploads1;


    public car_image(Context context, List<Car_Upload> car_upload) {
        mContext = context;
        mUploads1 = car_upload;

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_car_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Car_Upload uploadCurrent = mUploads1.get(position);
        holder.textViewName.setText(uploadCurrent.getName());

        holder.textViewPrice.setText("₹ " + uploadCurrent.getPrice());
        holder.textViewyear.setText(uploadCurrent.getyear());
        Picasso.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_loading)
                .fit()
                .centerInside()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads1.size();
    }



    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewPrice;
        public ImageView imageView;
        public TextView textViewyear;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPrice = itemView.findViewById(R.id.text_view_price);
            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewyear=itemView.findViewById(R.id.text_view_year);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  car_buy buyFragment = new car_buy();
                    Bundle bundle = new Bundle();
                    int position = getAdapterPosition();
                    Car_Upload current = mUploads1.get(position);
                    String name = current.getName();
                    bundle.putInt("position", position);
                    bundle.putString("name", name);
                    bundle.putString("price", current.getPrice());
                    bundle.putString("year",current.getyear());

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
