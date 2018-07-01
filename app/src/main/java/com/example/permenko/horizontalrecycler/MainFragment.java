package com.example.permenko.horizontalrecycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.example.permenko.horizontalrecycler.big.BigAdapter;
import com.example.permenko.horizontalrecycler.small.SmallAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
  private BigAdapter bigAdapter;
  private List<SmallAdapter> smallAdapter = new ArrayList<>();
  private View.OnClickListener clickListener =
      new View.OnClickListener() {
        @Override public void onClick(View v) {
          final String transitionName = String.valueOf(v.getTag());
          final DetailFragment detailFragment = DetailFragment.instance(transitionName);
          ViewCompat.setTransitionName(v, transitionName);

          final Transition changeTransform = TransitionInflater.from(getContext()).inflateTransition(R.transition.transition_shared_element);
          MainFragment.this.setSharedElementReturnTransition(changeTransform);
          detailFragment.setSharedElementEnterTransition(changeTransform);

          getActivity().getSupportFragmentManager().beginTransaction()
              .replace(R.id.fragment_container, detailFragment, "tag")
              .addToBackStack("tag")
              .addSharedElement(v, transitionName)
              .commit();
        }
      };

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    smallAdapter = new ArrayList<>();
    //smallAdapter.add(new SmallAdapter(clickListener));
    //smallAdapter.add(new SmallAdapter(clickListener));
    smallAdapter.add(new SmallAdapter(clickListener));
    bigAdapter = new BigAdapter(smallAdapter, clickListener);
  }

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //postponeEnterTransition();
    //getView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    //  @Override public void onGlobalLayout() {
    //    getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    //    startPostponedEnterTransition();
    //  }
    //});
    RecyclerView recycler = (RecyclerView) view;
    recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    recycler.setAdapter(bigAdapter);
  }
}

