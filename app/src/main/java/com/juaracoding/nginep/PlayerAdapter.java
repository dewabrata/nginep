package com.juaracoding.nginep;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.juaracoding.nginep.model.ModelNginep;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




    private List<ModelNginep> dataItemList;

    public PlayerAdapter(List<ModelNginep> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
            Penampung penampung = new Penampung(view);
            return penampung;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


            ((Penampung)holder).txtNama.setText("Nama     : " + dataItemList.get(position).getUsername());
            ((Penampung)holder).txtAlamat.setText("Alamat   : " + dataItemList.get(position).getMessage());



    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }



    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtNama, txtAlamat, txtStatus;
        public ImageView imgFoto, imgTtd;
        public Penampung(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txtnama);
            txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);


        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtNama.getText());
        }
    }


}
