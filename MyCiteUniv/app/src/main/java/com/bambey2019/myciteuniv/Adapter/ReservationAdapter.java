package com.bambey2019.myciteuniv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bambey2019.myciteuniv.LoginActivity;
import com.bambey2019.myciteuniv.Model.ReservationItem;
import com.bambey2019.myciteuniv.PaimentActivity;
import com.bambey2019.myciteuniv.R;
import com.bambey2019.myciteuniv.ResponsActivity;

import java.util.List;

public class ReservationAdapter extends BaseAdapter {
    private Context context;
    private List<ReservationItem> reservationItemList;
    private LayoutInflater inflater;

    public ReservationAdapter(Context context, List<ReservationItem> reservationItemList) {
        this.context = context;
        this.reservationItemList = reservationItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return reservationItemList.size();
    }

    @Override
    public ReservationItem getItem(int position) {
        return reservationItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_item, null);
        ReservationItem currentItem = getItem(i);
        String itemName = currentItem.getNumClasse();
        TextView itemNameView = view.findViewById(R.id.numReservation);
        itemNameView.setText(itemName);

        return view;
    }
}