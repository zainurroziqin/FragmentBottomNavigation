package com.example.fragmentbottomnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ChatsListAdapter extends RecyclerView.Adapter<ChatsListAdapter.ListViewHolder> {
    private ArrayList<Chats> listChats;
    private Context context;
    private OnItemClickCallback onItemCallback;

    public ChatsListAdapter(ArrayList<Chats> list, Context context) {
      this.listChats = list;
      this.context = context;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

   @Override
   public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
      Chats chat = listChats.get(i);
      Glide.with(listViewHolder.itemView.getContext())
              .load(chat.getPhoto())
              .apply(new RequestOptions().override(55, 55))
              .into(listViewHolder.imgPhoto);
      listViewHolder.tvName.setText(chat.getName());
      listViewHolder.tvDetail.setText(chat.getDetail());
      listViewHolder.tvWaktu.setText(chat.getWaktu());
      listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
        onItemCallback.onItemClicked(listChats.get(listViewHolder.getAdapterPosition()));
     }
    });
   }

    @Override
    public int getItemCount() {
        return listChats.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail, tvWaktu;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            tvWaktu = itemView.findViewById(R.id.waktu_pesan);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Chats data);
    }
}
