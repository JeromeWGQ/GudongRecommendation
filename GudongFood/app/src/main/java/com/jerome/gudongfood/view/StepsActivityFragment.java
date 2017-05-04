package com.jerome.gudongfood.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.R;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.jerome.gudongfood.dao.StepsUtil;

/**
 * A placeholder fragment containing a simple view.
 */
public class StepsActivityFragment extends Fragment {

    public StepsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps, container, false);
        RequestQueue rq = Volley.newRequestQueue(this.getContext());
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setAdapter(new StepsRecyclerViewAdapter(StepsUtil.getSteps(), rq));
        return view;
    }
}
