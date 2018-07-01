package com.example.permenko.horizontalrecycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailFragment extends Fragment {

  public static DetailFragment instance(String key) {
    DetailFragment fragment = new DetailFragment();
    Bundle bundle = new Bundle();
    bundle.putString("transitionName", key);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_detail, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.image).setTransitionName(getArguments().getString("transitionName"));
  }
}
