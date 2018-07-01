package com.example.permenko.horizontalrecycler.big;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.permenko.horizontalrecycler.R;
import java.util.ArrayList;
import java.util.List;

public class BigAdapter extends RecyclerView.Adapter<BigViewHolder> {
  private final List<String> data = new ArrayList<>();
  private final View.OnClickListener clickListener;

  public BigAdapter(View.OnClickListener clickListener) {
    this.clickListener = clickListener;
    data.add("Big 0");
    data.add("Big 1");
    data.add("Big 2");
    data.add("Big 3");
    data.add("Big 4");
    data.add("Big 5");
    data.add("Big 6");
    data.add("Big 7");
    data.add("Big 8");
    data.add("Big 9");
  }

  @NonNull @Override public BigViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_big, viewGroup, false);
    return new BigViewHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull BigViewHolder holder, int position) {
    holder.init(clickListener);
  }

  @Override public int getItemCount() {
    return data.size();
  }
}
