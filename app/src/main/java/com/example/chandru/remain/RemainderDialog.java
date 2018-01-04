package com.example.chandru.remain;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

/**
 * Created by chandru on 1/4/2018.
 */

public class RemainderDialog extends DialogFragment {
    private View view;
    private LayoutInflater inflater;
    private Realm mRealm;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.remaindialog, null);
        final EditText detail1 = (EditText) view.findViewById(R.id.reason_edit);
        final EditText detail2 = (EditText) view.findViewById(R.id.date_edit);
        final EditText detail3 = (EditText) view.findViewById(R.id.time_edit);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(" enter you remainder details");
        dialog.setView(view);
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mRealm = Realm.getDefaultInstance();
                mRealm.beginTransaction();
                RemainderObject remainderObject = mRealm.createObject(RemainderObject.class);
                remainderObject.setOccation_detail(detail1.getText().toString());
                remainderObject.setDate_detail(detail2.getText().toString());
                remainderObject.setTime_detail(detail3.getText().toString());
                mRealm.commitTransaction();
            }
        });
        return dialog.create();
    }


}

