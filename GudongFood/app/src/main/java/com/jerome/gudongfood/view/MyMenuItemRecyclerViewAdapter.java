package com.jerome.gudongfood.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.R;

import com.jerome.gudongfood.view.MenuItemFragment.OnListFragmentInteractionListener;
import com.jerome.gudongfood.model.MenuDataItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link MenuDataItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyMenuItemRecyclerViewAdapter extends RecyclerView.Adapter<MyMenuItemRecyclerViewAdapter.ViewHolder> {

    private final List<MenuDataItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyMenuItemRecyclerViewAdapter(List<MenuDataItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_menuitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);
        holder.mMenuName.setText(mValues.get(position).menuName);
        holder.mMenuDes.setText(mValues.get(position).menuDetail);
        holder.mImage.setImageBitmap(mValues.get(position).menuImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
//        public final TextView mIdView;
//        public final TextView mContentView;
        public final TextView mMenuName;
        public final TextView mMenuDes;
        public final ImageView mImage;
        public MenuDataItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.id);
//            mContentView = (TextView) view.findViewById(R.id.content);
            mMenuName = (TextView) view.findViewById(R.id.textMenuName);
            mMenuDes = (TextView) view.findViewById(R.id.textMenuDes);
            mImage = (ImageView) view.findViewById(R.id.listImageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMenuName.getText() + "'";
        }
    }
}
