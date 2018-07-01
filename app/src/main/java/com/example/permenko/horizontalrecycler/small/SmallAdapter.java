package com.example.permenko.horizontalrecycler.small;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.permenko.horizontalrecycler.R;
import java.util.ArrayList;
import java.util.List;

public class SmallAdapter extends RecyclerView.Adapter<SmallViewHolder> {
  private final List<String> data = new ArrayList<>();
  private final View.OnClickListener clickListener;

  public SmallAdapter(View.OnClickListener clickListener) {
    this.clickListener = clickListener;
    data.add("Small 0");
    data.add("Small 1");
    data.add("Small 2");
    data.add("Small 3");
    data.add("Small 4");
    data.add("Small 5");
    data.add("Small 6");
    data.add("Small 7");
    data.add("Small 8");
    data.add("Small 9");
  }

  @NonNull @Override public SmallViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_small, viewGroup, false);
    return new SmallViewHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull SmallViewHolder holder, int position) {
    holder.init(data.get(position), clickListener);
  }

  @Override public int getItemCount() {
    return data.size();
  }
}
