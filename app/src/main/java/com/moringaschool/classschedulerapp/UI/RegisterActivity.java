package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.moringaschool.classschedulerapp.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = RegisterActivity.class.getSimpleName();
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_full_name) TextInputEditText editFullName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_email) TextInputEditText editEmailAddress;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_password_sign_up) TextInputEditText editPassword1;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_confirm_password_sign_up) TextInputEditText editPassword2;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_register) Button signUpButton;
    @BindView(R.id.loadingTextView) TextView mLoadingSignUp;
    @BindView(R.id.firebaseProgressBar) ProgressBar mSignInProgressBar;




    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        signUpButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();

    }

    @Override
    public void onClick(View view) {
        if (view == signUpButton) {
            createNewUser();
        }
    }

    public void createNewUser() {
        mName = editFullName.getText().toString().trim();
        final String name = editFullName.getText().toString().trim();
        final String email = editEmailAddress.getText().toString().trim();
        String password = editPassword1.getText().toString().trim();
        String confirmPassword = editPassword2.getText().toString().trim();

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validmName = isValidName(mName);
        boolean validPassword = isValidPassword(password, confirmPassword);
        if (!validEmail || !validName || !validPassword) return;

        showProgressBar();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Authentication successful");
                        hideProgressBar();
                        createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser()));
                        Toast.makeText(RegisterActivity.this, "Firebase Authentication is successful.", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void showProgressBar() {
        mSignInProgressBar.setVisibility(View.VISIBLE);
        mLoadingSignUp.setVisibility(View.VISIBLE);
        mLoadingSignUp.setText("Sign Up process in Progress");
    }

    private void hideProgressBar() {
        mSignInProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(RegisterActivity.this, AltLandingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    private void createFirebaseUserProfile(final FirebaseUser user) {

        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mName)
                .build();

        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Account created successfully", Toast
                                    .LENGTH_LONG).show();
                        }
                    }

                });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public boolean isValidEmail(String email) {
        boolean isGoodEmail = (
                email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            editEmailAddress.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidName(String name) {
        if (name.equals("")) {
            editFullName.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 6) {
            editPassword1.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)) {
            editPassword1.setError("Passwords do not match");
            return false;
        }
        return true;
    }
}