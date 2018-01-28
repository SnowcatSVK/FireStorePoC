package com.globallogic.snowcat.firestorepoc;


import android.app.Application;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUserFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private TextInputEditText etFirstName;
    private TextInputEditText etLastName;
    private TextInputEditText etdob;
    private TextInputEditText etAge;
    private Button btnSave;

    private Calendar c;

    private Date date;

    public CreateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c = Calendar.getInstance();
        etFirstName = view.findViewById(R.id.et_name);
        etLastName = view.findViewById(R.id.et_last_name);
        etdob = view.findViewById(R.id.et_dob);
        etAge = view.findViewById(R.id.et_age);
        btnSave = view.findViewById(R.id.btn_save);

        final DatePickerDialog datePickerDialog = new DatePickerDialog(
                getActivity(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

        etdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        etdob.setFocusable(false);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                User user = new User(etFirstName.getText().toString(), etLastName.getText().toString()
                        , date, Integer.parseInt(etAge.getText().toString()));
                DocumentReference userDoc = db.collection("users").document();
                user.setId(userDoc.getId());
                userDoc.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.e("UserWrite", "User added");
                    }
                });
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        date = new Date(c.getTimeInMillis());
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY", Locale.US);
        etdob.setText(format.format(date));
    }
}
