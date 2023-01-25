package com.nephat.truhouse.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.nephat.truhouse.ChooseActionActivity;
import com.nephat.truhouse.R;
import com.nephat.truhouse.models.ApiResponse;
import com.nephat.truhouse.resetPassword.AgentEnterEmailActivity;
import com.nephat.truhouse.retrofitUtil.ApiClient;
import com.nephat.truhouse.retrofitUtil.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAsAgentActivity extends AppCompatActivity {

    //Widgets
    private TextInputEditText mRegistrationNo, mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_agent);

        mRegistrationNo = findViewById(R.id.sign_in_reg_no);
        mPassword = findViewById(R.id.sign_in_agent_pass);
        Button mLoginBtn = findViewById(R.id.sign_in_agent_btn);
        TextView mLinkLogin = findViewById(R.id.link_to_login);
        TextView mLinkForgotPass = findViewById(R.id.link_to_forgot_pass);

        mLinkForgotPass.setOnClickListener(v -> {
            Intent intent = new Intent(LoginAsAgentActivity.this, AgentEnterEmailActivity.class);
            startActivity(intent);
        });

        mLinkLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginAsAgentActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        });

        mLoginBtn.setOnClickListener(v -> performAgentLogin());


    }

    private void performAgentLogin(){

        String loginRegNo, loginPassword;
        loginRegNo=String.valueOf(mRegistrationNo.getText());
        loginPassword=String.valueOf(mPassword.getText());

        if (!loginRegNo.isEmpty() && !loginPassword.isEmpty()){

            Call<ApiResponse> call= ApiClient.getApiClient().create(ApiInterface.class).performAgentLogin(loginRegNo,loginPassword);
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                    if (response.code()==200){
                        if (response.body() != null) {
                            if (response.body().getStatus().equals("ok")){
                                if (response.body().getResultCode()==1){
                                    String name = response.body().getName();
                                    String id = response.body().getId();
                                    String reg_no = response.body().getReg_no();
                                    toastMessage(name+ ": Logged in Successfully" + " Your reg no is "+reg_no);
                                    Intent intent = new Intent(LoginAsAgentActivity.this, ChooseActionActivity.class);
                                    intent.putExtra("NAME", name);
                                    intent.putExtra("ID", id);
                                    intent.putExtra("REG", reg_no);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    toastMessage("Login Failed");
                                }
                            } else {
                                toastMessage("Something went wrong");
                            }
                        }
                    } else{
                        toastMessage("Something went wrong");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {

                }
            });
        } else{
            toastMessage("Fields cannot be empty");
            mRegistrationNo.setError("Please insert registration number");
            mPassword.setError("Please insert password");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LoginAsAgentActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    public void checkBoxAgentClicked(View view){

    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}