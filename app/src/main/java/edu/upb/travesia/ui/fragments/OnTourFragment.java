package edu.upb.travesia.ui.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import edu.upb.travesia.R;

public class OnTourFragment extends BaseFragment {

    private Button btnEmergency;
    private Switch swiGPS;
    private Boolean swiBoo = false;
    private EditText txtEmergencyEmail;

    private Double lat = -16.524396;
    private Double lon = -68.110429;
    private String position = "Your current position is: " + lat + ", " + lon;

    public OnTourFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_tour, container, false);
        initUI(view);

        swiGPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swiBoo = true;
                    Toast.makeText(context,
                            getString(R.string.swiTrue),
                            Toast.LENGTH_SHORT)
                            .show();
                } else {
                    swiBoo = false;
                    Toast.makeText(context,
                            getString(R.string.swiFalse),
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });


        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmergencyEmail.getText().toString();
                if (swiBoo && (!email.isEmpty())) {
                    if (!email.contains("@")) {
                       txtEmergencyEmail.setError(getString(R.string.error_invalid_email));
                    } else {
                        Toast.makeText(context,
                                getString(R.string.toastMessage, position),
                                Toast.LENGTH_LONG)
                                .show();
                    }

                } else if (swiBoo && (email.isEmpty())) {
                    Toast.makeText(context,
                            getString(R.string.toastEmailMissing),
                            Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(context,
                            getString(R.string.toastFalse),
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });


        return view;
    }

    private void initUI(View view) {
        //myTextTextView = view.findViewById(R.id.myTextTextView);

        btnEmergency = view.findViewById(R.id.btnEmergency);
        swiGPS = view.findViewById(R.id.swiGPS);
        txtEmergencyEmail = view.findViewById(R.id.txtEmergencyContact);

    }


}