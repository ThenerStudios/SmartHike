package com.mlambo.smarthike.Util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.mlambo.smarthike.Authentication.DriversSignUp;
import com.mlambo.smarthike.Authentication.PasangerSignUp;
import com.mlambo.smarthike.R;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button Driver = v.findViewById(R.id.driverBtn);
        Button Passenger = v.findViewById(R.id.passengerBtn);

        Driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), DriversSignUp.class));

            }
        });

        Passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), PasangerSignUp.class));
            }
        });

        return v;
    }

    public interface BottomSheetListener
    {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

       /* try
        {
            mListener = (BottomSheetListener) context;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()
                    + "must implement BottomSheetListener");
        }*/
    }
}
