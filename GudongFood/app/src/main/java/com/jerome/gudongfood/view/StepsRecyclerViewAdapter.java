package com.jerome.gudongfood.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.jerome.gudongfood.model.StepItem;

import java.util.List;

/**
 * Created by Jerome on 2017/5/3.
 */

public class StepsRecyclerViewAdapter extends RecyclerView.Adapter<StepsRecyclerViewAdapter.ViewHolder> {

    private RequestQueue mQueue;
    private final List<StepItem> mValues;

    public StepsRecyclerViewAdapter(List<StepItem> steps, RequestQueue rq) {
        this.mValues = steps;
        mQueue = rq;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_step, parent, false);
        return new StepsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mStep.setText(mValues.get(position).stepText);
        holder.getImage(position);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImage;
        public final TextView mStep;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.stepImage);
            mStep = (TextView) itemView.findViewById(R.id.textStepDetail);
        }

        public void getImage(int p) {
            // TODO: 2017/5/3 优化
            ImageRequest imageRequest = new ImageRequest(
                    mValues.get(p).imgSrc,
                    new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {
                            mImage.setImageBitmap(response);
                        }
                    }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: 2017/5/3 添加一张加载失败的图片
                }
            });
            mQueue.add(imageRequest);
        }
    }
}
