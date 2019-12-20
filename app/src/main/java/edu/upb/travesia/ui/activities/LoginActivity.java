package edu.upb.travesia.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.utils.Constants;
import edu.upb.travesia.viewmodel.LoginViewModel;


public class LoginActivity extends AppCompatActivity {

/*    private Button btnLogin;

    private static final String LOG = "LoginActivity";
    private Context context;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogin = findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }*/
    private static final String LOG = LoginActivity.class.getSimpleName();


    private Context context;

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private Button sendButton;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e(LOG, "onCreate");
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        this.context = this;
        initUI();
        initEvents();

        emailEditText.setText("travis@travesia.com");
        passwordEditText.setText("123456");

        Intent intent = getIntent();
        if (intent.hasExtra("message")) {
            String message = intent.getStringExtra("message");
            Toast.makeText(this, // Context, origen
                    message, //Mensaje
                    Toast.LENGTH_SHORT) //Duración
                    .show();
        }
    }

    private void initUI() {
        this.emailEditText = findViewById(R.id.emailEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);
        this.sendButton = findViewById(R.id.sendButton);
        this.registerButton = findViewById(R.id.registerButton);
    }

    private void initEvents() {
        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    if (!email.contains("@")) {
                        emailEditText.setError(getString(R.string.error_invalid_email));
                    }

                    LiveData<Base> result = viewModel.login(email, password);
                    result.observe(LoginActivity.this, new Observer<Base>() {
                        @Override
                        public void onChanged(Base base) {
                            if (base.isSuccess()) {
                                UserLogged userLogged = (UserLogged) base.getData();
                                String json = new Gson().toJson(userLogged);

                                Toast.makeText(context,
                                        getString(R.string.welcome, userLogged.getEmail()),
                                        Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent = new Intent(context, MainActivity.class);
                                intent.putExtra(Constants.INTENT_KEY_USER_LOGGED, json);
                                startActivity(intent);


                            } else {
                                Toast.makeText(context,
                                        base.getMessage(),
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(context,
                            R.string.error_empty,
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

}
