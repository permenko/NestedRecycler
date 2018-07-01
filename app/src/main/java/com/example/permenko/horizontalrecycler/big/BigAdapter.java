package com.example.permenko.horizontalrecycler.big;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.permenko.horizontalrecycler.R;
import com.example.permenko.horizontalrecycler.small.SmallAdapter;
import java.util.ArrayList;
import java.util.List;

public class BigAdapter extends RecyclerView.Adapter<BigViewHolder> {
  private final View.OnClickListener clickListener;
  private final List<SmallAdapter> smallAdapter;

  public BigAdapter(List<SmallAdapter> smallAdapter, View.OnClickListener clickListener) {
    this.smallAdapter = smallAdapter;
    this.clickListener = clickListener;
  }

  @NonNull @Override public BigViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_big, viewGroup, false);
    return new BigViewHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull BigViewHolder holder, int position) {
    holder.init(smallAdapter.get(position), clickListener);
  }

  @Override public int getItemCount() {
    return smallAdapter.size();
  }
}
