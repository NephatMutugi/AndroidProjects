package com.nephat.truhouse.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.nephat.truhouse.R;
import com.nephat.truhouse.models.ApiResponse;
import com.nephat.truhouse.retrofitUtil.ApiClient;
import com.nephat.truhouse.retrofitUtil.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {


    private TextInputEditText mUserName, mUserEmail, mPassword, mConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUserName = findViewById(R.id.register_username);
        mUserEmail = findViewById(R.id.register_email);
        mPassword = findViewById(R.id.register_pass);
        mConfirmPassword = findViewById(R.id.confirm_pass);

        Button mRegisterBtn = findViewById(R.id.register_btn);
        TextView mLinkLogin = findViewById(R.id.login_link);

        hideSoftKeyboard();

        mLinkLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        });

        mRegisterBtn.setOnClickListener(v -> {

            hideSoftKeyboard();

           performRegister();
        });

    }


    private void performRegister(){
        String username, userEmail, userPassword, confirmPassword;
        username = String.valueOf(mUserName.getText());
        userEmail = String.valueOf(mUserEmail.getText());
        userPassword = String.valueOf(mPassword.getText());
        confirmPassword = String.valueOf(mConfirmPassword.getText());

        if (TextUtils.isEmpty(userEmail)){
            mUserEmail.setError("Email is required");
            return;
        } if (TextUtils.isEmpty(username)){
            mUserName.setError("User Name is required");
            return;
        } if (TextUtils.isEmpty(userPassword)){
            mPassword.setError("Password is required");
            return;
        } if (userPassword.length() < 4){
            mPassword.setError("Password should be 4 or more characters");
            return;
        } if (!TextUtils.equals(userPassword, confirmPassword)) {
            mConfirmPassword.setError("Passwords do not match");
        } else {

            Call<ApiResponse> call = ApiClient.getApiClient()
                    .create(ApiInterface.class)
                    .performUserRegister(username, userEmail, userPassword);
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                    if (response.code() == 200){

                        assert response.body() != null;
                        if (response.body().getStatus().equals("ok")){

                            if (response.body().getResultCode() == 1){

                                toastMessage("Registration was successful");
                                onBackPressed();
                                finish();

                            } else {

                                toastMessage("User already exists");

                            }


                        } else {

                            displayUserInfo();
                        }


                    } else{

                        displayUserInfo();

                    }
                }

                @Override
                public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {

                }
            });

        }
    }

    private void displayUserInfo(){
      toastMessage("Something went wrong...");
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void hideSoftKeyboard()
    {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

