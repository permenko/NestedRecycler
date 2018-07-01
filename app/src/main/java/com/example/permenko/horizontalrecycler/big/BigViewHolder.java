package com.example.permenko.horizontalrecycler.big;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.permenko.horizontalrecycler.small.SmallAdapter;

public class BigViewHolder extends RecyclerView.ViewHolder {
  public BigViewHolder(View itemView) {
    super(itemView);
  }

  public void init(SmallAdapter smallAdapter, View.OnClickListener clickListener) {
    RecyclerView horizontalRecycler = (RecyclerView) itemView;
    horizontalRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
    horizontalRecycler.setAdapter(smallAdapter);
  }
}
