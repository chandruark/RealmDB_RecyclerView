package com.example.chandru.remain;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by chandru on 1/4/2018.
 */

public class RemainderAdapter extends RecyclerView.Adapter<RemainderAdapter.RemainderViewHolder> implements RealmChangeListener {
public RealmResults<RemainderObject> mRemains;

public RemainderAdapter(RealmResults<RemainderObject> remain) {
        this.mRemains = remain;
        mRemains.addChangeListener(this);
        }

@Override
public RemainderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remaindertab, parent, false);
        return new RemainderViewHolder(view);
        }

@Override
public void onBindViewHolder(RemainderViewHolder holder, int position) {
        RemainderObject remainderObject = mRemains.get(position);
        holder.Reason_text.setText(remainderObject.getOccation_detail());
        holder.Date_text.setText(remainderObject.getDate_detail());
        holder.Time_text.setText(remainderObject.getTime_detail());
        }

@Override
public int getItemCount() {
        return mRemains.size();
        }

public class RemainderViewHolder extends RecyclerView.ViewHolder {
    TextView Reason_text,Date_text,Time_text;

    public RemainderViewHolder(View itemView) {
        super(itemView);
        Reason_text= (TextView) itemView.findViewById(R.id.Reason);
        Date_text = (TextView) itemView.findViewById(R.id.Date);
        Time_text = (TextView) itemView.findViewById(R.id.Time);
    }
}

    @Override
    public void onChange(Object element) {
        notifyDataSetChanged();
    }
}
