package edu.upb.travesia.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.User;
import edu.upb.travesia.utils.Constants;
import edu.upb.travesia.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    private Context context;
    private RegisterViewModel viewModel;

    private long count = 0;

    private Button registerButton;
    private EditText txtEmail;
    private EditText txtName;
    private EditText txtLastName;
    private EditText txtPassword;
    private EditText txtConfirmPassword;
    private EditText txtAge;
    private EditText txtPhone;
    private Spinner spiNationality;
    private Spinner spiGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        context = this;
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);

        initUI();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setEmail(txtEmail.getText().toString());
                user.setName(txtName.getText().toString());
                user.setLast_name(txtLastName.getText().toString());
                user.setPhone(txtPhone.getText().toString());
                user.setAge(Integer.parseInt(txtAge.getText().toString()));
                user.setGender(spiGender.getSelectedItem().toString());
                user.setNationality(spiNationality.getSelectedItem().toString());
                user.setPassword(txtPassword.getText().toString());
                viewModel.register(user);
                Intent intent = new Intent(context,LoginActivity.class);
                startActivity(intent);


            }
        });



        //SPINNERS
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nationality_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spiNationality.setAdapter(adapter);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spiGender.setAdapter(adapter2);

    }

    private void initUI() {
        spiNationality = (Spinner) findViewById(R.id.spiNationality);
        spiGender = (Spinner) findViewById(R.id.spiGender);
        registerButton = findViewById(R.id.btnNextRegister);
        txtEmail = findViewById(R.id.txtEmail);
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        txtAge = findViewById(R.id.txtAge);
        txtPhone = findViewById(R.id.txtPhone);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getAll().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.e("Users", new Gson().toJson(users));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.getAll().removeObservers(this);
    }


}
