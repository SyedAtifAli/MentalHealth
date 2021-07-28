package com.example.mentalhealth.Login_SignUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
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
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private static final String TAG = "Step 1/2";
    private static final int RC_SIGN_IN = 1;
    /* access modifiers changed from: private */
    public TextInputLayout email;
    /* access modifiers changed from: private */
    public FirebaseAuth mAuth;
    /* access modifiers changed from: private */
    public TextInputLayout name;
    /* access modifiers changed from: private */
    public TextInputLayout password;
    GoogleSignInClient mGoogleSignInClient;

    FirebaseAuth firebaseAuth;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_sign_up);
        ImageView back = findViewById(R.id.signup_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        this.mGoogleSignInClient = GoogleSignIn.getClient((Activity) this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build());
        findViewById(R.id.googleSign2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent signinintent = SignUp.this.mGoogleSignInClient.getSignInIntent();
                SignUp signUp = SignUp.this;
                signUp.startActivityForResult(signinintent, SignUp.RC_SIGN_IN);
            }
        });
        this.password = (TextInputLayout) findViewById(R.id.textInputPassword);
        this.name = (TextInputLayout) findViewById(R.id.textInputName);
        this.email = (TextInputLayout) findViewById(R.id.textInputEmail);
        ((Button) findViewById(R.id.cirRegisterButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager) SignUp.this.getSystemService(INPUT_METHOD_SERVICE);
                if (SignUp.this.getCurrentFocus() != null) {
                    inputManager.hideSoftInputFromWindow(SignUp.this.getCurrentFocus().getWindowToken(), 2);
                }
                final String Strpassword = SignUp.this.password.getEditText().getText().toString();
                final String Strname = SignUp.this.name.getEditText().getText().toString();
                final String Stremail = SignUp.this.email.getEditText().getText().toString().trim();
                if (Stremail.isEmpty() && Strpassword.isEmpty() && Strname.isEmpty()) {
                    SignUp.this.password.setError("Enter a valid password");
                    SignUp.this.name.setError("Enter your Full name");
                    SignUp.this.email.setError("Enter your email address");
                } else if (Stremail.isEmpty()) {
                    SignUp.this.email.setError("Enter your Email address");
                } else if (Strpassword.isEmpty()) {
                    SignUp.this.password.setError("Enter a valid password");
                } else if (Strname.isEmpty()) {
                    SignUp.this.name.setError("Enter your name");
                } else {
                    FirebaseAuth unused = SignUp.this.mAuth = FirebaseAuth.getInstance();
                    if (SignUp.isEmailValid(Stremail)) {
                        SignUp.this.mAuth.fetchSignInMethodsForEmail(Stremail).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                            public void onComplete(Task<SignInMethodQueryResult> task) {
                                if (!task.getResult().getSignInMethods().isEmpty()) {
                                    Toast.makeText(SignUp.this.getApplicationContext(), "Email already Exist! or Verify your email if already registered!", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                SaveSharedPreference.setUser(SignUp.this, Strname);
                                SignUp.this.mAuth.createUserWithEmailAndPassword(Stremail, Strpassword).addOnCompleteListener((Activity) SignUp.this, new OnCompleteListener<AuthResult>() {
                                    public void onComplete(Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            SignUp.this.mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                public void onComplete(Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(SignUp.this, "Registered! Email Verification sent", Toast.LENGTH_LONG).show();
                                                        Toast.makeText(SignUp.this, Strname, Toast.LENGTH_SHORT).show();
                                                        return;
                                                    }
                                                    Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT);
                                                }
                                            });
                                            Log.d(SignUp.TAG, "createUserWithEmail:success");
                                            SignUp.this.startActivity(new Intent(SignUp.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                            SignUp.this.finish();
                                        }
                                    }
                                });
                            }
                        });
                    } else {
                        Toast.makeText(SignUp.this.getApplicationContext(), "Enter a Valid Email Id", Toast.LENGTH_LONG).show();
                    }
                }
                SignUp.this.email.getEditText().addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    public void afterTextChanged(Editable editable) {
                        SignUp.this.email.setError((CharSequence) null);
                    }
                });
                SignUp.this.password.getEditText().addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    public void afterTextChanged(Editable editable) {
                        SignUp.this.password.setError((CharSequence) null);
                    }
                });
                SignUp.this.name.getEditText().addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    public void afterTextChanged(Editable editable) {
                        SignUp.this.name.setError((CharSequence) null);
                    }
                });
            }
        });
    }

    public static boolean isEmailValid(String email2) {
        return Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(email2).matches();
    }

    public void onLoginClick(View view) {
        Intent intent = new Intent(SignUp.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.RC_SIGN_IN) {
            try {
                firebaseAuthWithGoogle(GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class));
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
//                Toast.makeText(this, "Google sign in failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        this.firebaseAuth.signInWithCredential(GoogleAuthProvider.getCredential(acct.getIdToken(), (String) null)).addOnCompleteListener((Activity) this, new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().getAdditionalUserInfo().isNewUser()) {
                        SignUp.this.startActivity(new Intent(SignUp.this.getApplicationContext(), MainActivity.class));
                    } else {
                        FirebaseUser user = SignUp.this.firebaseAuth.getCurrentUser();
                        Toast.makeText(SignUp.this.getApplicationContext(), user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        SaveSharedPreference.setUserName(SignUp.this.getApplicationContext(), user.getEmail());
                        SignUp.this.startActivity(new Intent(SignUp.this.getApplicationContext(), MainActivity.class));
                    }
                    SignUp.this.finish();
                    return;
                }
                Snackbar.make(SignUp.this.findViewById(R.id.googleSign), (CharSequence) "Authentication Failed.", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }
}
