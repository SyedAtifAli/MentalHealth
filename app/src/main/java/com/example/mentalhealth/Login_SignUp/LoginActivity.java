package com.example.mentalhealth.Login_SignUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.MainActivity;
import com.example.mentalhealth.R;
import com.example.mentalhealth.SaveSharedPreference;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "LoginActivity";
    /* access modifiers changed from: private */
    public int RC_SIGN_IN = 1;
    /* access modifiers changed from: private */
    public TextInputLayout email;
    /* access modifiers changed from: private */
    public FirebaseAuth firebaseAuth;
    /* access modifiers changed from: private */
    public Button login;
    GoogleSignInClient mGoogleSignInClient;
    /* access modifiers changed from: private */
    public TextInputLayout password;
    /* access modifiers changed from: private */
    public Button register;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.login_activity);
        this.firebaseAuth = FirebaseAuth.getInstance();
        final Intent i = new Intent(this, SignUp.class);
        this.register = (Button) findViewById(R.id.button2);
        this.email = (TextInputLayout) findViewById(R.id.editText);
        this.login = (Button) findViewById(R.id.button);
        this.password = (TextInputLayout) findViewById(R.id.editText2);
        this.register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.startActivity(i);
            }
        });
        this.mGoogleSignInClient = GoogleSignIn.getClient((Activity) this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build());
        findViewById(R.id.googleSign).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent signinintent = LoginActivity.this.mGoogleSignInClient.getSignInIntent();
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.startActivityForResult(signinintent, loginActivity.RC_SIGN_IN);
            }
        });
        this.login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.this.LogIn();
            }
        });
        this.password.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 6) {
                    return false;
                }
                LoginActivity.this.LogIn();
                return false;
            }
        });
        this.email.getEditText().addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                LoginActivity.this.email.setError((CharSequence) null);
            }
        });
        this.password.getEditText().addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                LoginActivity.this.password.setError((CharSequence) null);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.RC_SIGN_IN) {
            try {
                firebaseAuthWithGoogle(GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class));
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
                Toast.makeText(this, "Google sign in failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        this.firebaseAuth.signInWithCredential(GoogleAuthProvider.getCredential(acct.getIdToken(), (String) null)).addOnCompleteListener((Activity) this, new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().getAdditionalUserInfo().isNewUser()) {
                        LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), MainActivity.class));
                    } else {
                        Log.d(LoginActivity.TAG, "signInWithCredential:success");
                        FirebaseUser user = LoginActivity.this.firebaseAuth.getCurrentUser();
                        Toast.makeText(LoginActivity.this.getApplicationContext(), user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        SaveSharedPreference.setUserName(LoginActivity.this.getApplicationContext(), user.getEmail());
                        LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), MainActivity.class));
                    }
                    LoginActivity.this.finish();
                    return;
                }
                Log.w(LoginActivity.TAG, "signInWithCredential:failure", task.getException());
                Snackbar.make(LoginActivity.this.findViewById(R.id.googleSign), (CharSequence) "Authentication Failed.", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }

    /* Debug info: failed to restart local var, previous not found, register: 7 */
    public void LogIn() {
        try {
            InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(((View) Objects.requireNonNull(getCurrentFocus())).getWindowToken(), 2);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.MainProgressBar);
                this.login.setEnabled(false);
                this.register.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                final String Stremail = this.email.getEditText().getText().toString();
                String Strpass = this.password.getEditText().getText().toString();
                if (Stremail.isEmpty() && Strpass.isEmpty()) {
                    this.email.setError("Enter your Email address");
                    this.password.setError("Enter a Valid password");
                    progressBar.setVisibility(View.GONE);
                    this.login.setEnabled(true);
                    this.register.setEnabled(true);
                } else if (Stremail.isEmpty()) {
                    this.email.setError("Enter your Email address");
                    progressBar.setVisibility(View.GONE);
                    this.login.setEnabled(true);
                    this.register.setEnabled(true);
                } else if (Strpass.isEmpty()) {
                    this.password.setError("Enter a valid password");
                    progressBar.setVisibility(View.GONE);
                    this.login.setEnabled(true);
                    this.register.setEnabled(true);
                } else {
                    this.firebaseAuth.signInWithEmailAndPassword(Stremail, Strpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        public void onComplete(Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                LoginActivity.this.firebaseAuth.fetchSignInMethodsForEmail(Stremail).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                                    public void onComplete(Task<SignInMethodQueryResult> task) {
                                        if (!task.getResult().getSignInMethods().isEmpty()) {
                                            Toast.makeText(LoginActivity.this.getApplicationContext(), "Incorrect Password!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(LoginActivity.this.getApplicationContext(), "User not Registered!", Toast.LENGTH_SHORT).show();
                                        }
                                        progressBar.setVisibility(View.GONE);
                                        LoginActivity.this.login.setEnabled(true);
                                        LoginActivity.this.register.setEnabled(true);
                                    }
                                });
                                return;
                            }
                            if (!LoginActivity.this.firebaseAuth.getCurrentUser().isEmailVerified()) {
                                Toast.makeText(LoginActivity.this, "Email Not Verified! Please verify before continuing", Toast.LENGTH_SHORT).show();
                            } else if (SaveSharedPreference.getUpload(LoginActivity.this)) {
                                LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                LoginActivity.this.finish();
                            } else {
                                SaveSharedPreference.setUserName(LoginActivity.this, Stremail);
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                LoginActivity.this.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                LoginActivity.this.finish();
                            }
                            progressBar.setVisibility(View.GONE);
                            LoginActivity.this.login.setEnabled(true);
                            LoginActivity.this.register.setEnabled(true);
                        }
                    });
                }
            } else {
                throw new AssertionError();
            }
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        FirebaseUser firebaseUser = this.firebaseAuth.getCurrentUser();
        if (firebaseUser != null && firebaseUser.isEmailVerified()) {
            startActivity(new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    public void forgotpassword(View view) {
        String Stremail = this.email.getEditText().getText().toString();
        if (Stremail.isEmpty()) {
            this.email.setError("Enter your Email address");
        } else {
            FirebaseAuth.getInstance().sendPasswordResetEmail(Stremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this.getApplicationContext(), "Password Reset Email sent. Check Inbox", Toast.LENGTH_LONG).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception e) {
                    Toast.makeText(LoginActivity.this.getApplicationContext(), "Email not registered!", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
