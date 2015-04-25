package com.joebruckner.whoknows.ui;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joebruckner.whoknows.R;
import com.joebruckner.whoknows.common.BaseFragment;
import com.joebruckner.whoknows.models.logic.Event;
import com.joebruckner.whoknows.presenters.EventAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NearbyListFragment extends BaseFragment {
    @InjectView (R.id.list_view) RecyclerView listView;
    @Inject RecyclerView.LayoutManager layoutManager;

    public NearbyListFragment() {
        // Required empty public constructor
    }

    public static NearbyListFragment newInstance() {
        return new NearbyListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby_list, container, false);
        ButterKnife.inject(this, view);
        listView.setLayoutManager(layoutManager);
        EventAdapter adapter = new EventAdapter(generateData());
        listView.setAdapter(adapter);
        return view;
    }

    private List<Event> generateData() {
        List<Event> data = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            data.add(new Event("Test Event " + i));
        return data;
    }
}