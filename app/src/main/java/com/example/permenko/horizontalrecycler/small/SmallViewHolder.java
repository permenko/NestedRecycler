package com.example.permenko.horizontalrecycler.small;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.permenko.horizontalrecycler.R;

public class SmallViewHolder extends RecyclerView.ViewHolder {
  public SmallViewHolder(View itemView) {
    super(itemView);
  }

  public void init(String str, final View.OnClickListener clickListener) {
    final ImageView image = itemView.findViewById(R.id.item_image);
    image.setTag(str);
    image.setOnClickListener(clickListener);
  }
}
