package com.example.mentalhealth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;
import com.example.mentalhealth.diary.AddActivity;
import com.example.mentalhealth.diary.ItemObject;
import com.example.mentalhealth.diary.SQLiteNote;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiaryFragment extends Fragment implements View.OnClickListener {

    FloatingActionButton btn_add_note;
    RecyclerView lst_note;
    List<ItemObject> list;
    TextView empty;
    int flag = 0;
    private static final String TAG = "diaryFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_diary, null);

        Button tryagain = v.findViewById(R.id.tryagain);
        FrameLayout hmm = v.findViewById(R.id.hmm_layout);


        //Create a thread pool with a single thread//

        Executor newExecutor = Executors.newSingleThreadExecutor();


        //Start listening for authentication events//

        final BiometricPrompt myBiometricPrompt = new BiometricPrompt(getActivity(), newExecutor, new BiometricPrompt.AuthenticationCallback() {
            @Override

//onAuthenticationError is called when a fatal error occurrs//

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            hmm.setVisibility(View.VISIBLE);
                        }
                    });
                } else {

//Print a message to Logcat//

                    Log.d(TAG, "An unrecoverable error occurred");
                }
            }


//onAuthenticationSucceeded is called when a fingerprint is matched successfully//

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        hmm.setVisibility(View.GONE);
                    }
                });
//Print a message to Logcat//

                Log.d(TAG, "Fingerprint recognised successfully");
            }

//onAuthenticationFailed is called when the fingerprint doesn’t match//

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        hmm.setVisibility(View.VISIBLE);
                    }
                });//Print a message to Logcat//

                Log.d(TAG, "Fingerprint not recognised");
            }
        });


//Create the BiometricPrompt instance//

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()

//Add some text to the dialog//


                .setTitle("Authenticate Yourself!")
                .setSubtitle("Touch the fingerprint sensor, This will help you to protect your journal entries from unwanted eyes.")
                .setNegativeButtonText("Cancel")

//Build the dialog//

                .build();

//Showing fingerprint prompt everytime user opens diary

        myBiometricPrompt.authenticate(promptInfo);

        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBiometricPrompt.authenticate(promptInfo);

            }
        });


        empty = v.findViewById(R.id.empty_diary);

        lst_note = v.findViewById(R.id.lst_note);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        lst_note.setLayoutManager(gridLayoutManager);
        DataItem();

        btn_add_note = v.findViewById(R.id.btn_add_note);
        btn_add_note.setOnClickListener(this);

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        DataItem();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_note:
                Intent intent = new Intent(getContext(), AddActivity.class);
                startActivity(intent);
                break;
        }
    }


    public void DataItem() {
        SQLiteNote db_note = new SQLiteNote(getContext());
        list = db_note.getData();
        if (list.isEmpty()) {
            empty.setVisibility(View.VISIBLE);
        } else {
            empty.setVisibility(View.GONE);
            BaseAdapter adapter = new BaseAdapter(getContext(), db_note.getData());
            lst_note.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }


}
