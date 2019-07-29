package com.mlambo.smarthike.Authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mlambo.smarthike.R;
import com.mlambo.smarthike.Util.BottomSheetDialog;

public class PhoneAuth extends AppCompatActivity {

    /*
    *
    *private LinearLayout mPhoneLayout;
    private LinearLayout mCodeLayout;

    private EditText mPhoneText;
    private EditText mCodeText;

    private ProgressBar mPhoneBar;
    private ProgressBar mCodeBar;

    private Button mSendBtn;
    FirebaseAuth mAuth;

    private int btnType = 0;


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);

       Button mSendBtn = findViewById(R.id.Send_Verification_Btn);
       mSendBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               proceed();
           }
       });

    /*mAuth = FirebaseAuth.getInstance();

        mPhoneLayout = findViewById(R.id.phone_layout);
        mCodeLayout = findViewById(R.id.Code_layout);
        mCodeLayout.setVisibility(View.INVISIBLE);

        mPhoneText = findViewById(R.id.PhoneEditText);
        mCodeText = findViewById(R.id.CodeEditText);

        mPhoneBar = findViewById(R.id.PhoneProgress);
        mPhoneBar.setVisibility(View.INVISIBLE);
        mCodeBar = findViewById(R.id.CodeProgress);
        mCodeBar.setVisibility(View.INVISIBLE);

        mSendBtn = findViewById(R.id.Send_Verification_Btn);

        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnType == 0) {

                    mPhoneBar.setVisibility(View.VISIBLE);
                    mPhoneText.setEnabled(false);
                    mSendBtn.setEnabled(false);


                    String phoneNumber = COUNTRY_CODE + mPhoneText.getText().toString();

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phoneNumber,
                            60,
                            TimeUnit.SECONDS,
                            Phone_Number_Auth.this,
                            mCallbacks

                    );
                }else
                {
                    mSendBtn.setEnabled(false);
                    mCodeBar.setVisibility(View.VISIBLE);

                    String verificationCode = mCodeText.getText().toString();

                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, verificationCode);
                    signInWithPhoneAuthCredintial(credential);
                }
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredintial(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(Phone_Number_Auth.this, "There was some error in verification", Toast.LENGTH_SHORT).show();
                mPhoneBar.setVisibility(View.INVISIBLE);
                mSendBtn.setEnabled(true);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {

                mVerificationId = verificationId;
                mResendToken = token;

                btnType = 1;

                mPhoneBar.setVisibility(View.INVISIBLE);
                mCodeLayout.setVisibility(View.VISIBLE);

                mSendBtn.setText("Verify Code");
                mSendBtn.setEnabled(true);
            }
        };*/

    }

    /*  private void signInWithPhoneAuthCredintial(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Log.d(TAG, "signInWithcredintials:success");
                            FirebaseUser user = task.getResult().getUser();
                            Intent intent = new Intent(Phone_Number_Auth.this, Start_Application.class);
                            startActivity(intent);
                            finish();


                        } else {
                            Toast.makeText(Phone_Number_Auth.this, "The was Some Error in logging In", Toast.LENGTH_SHORT).show();
                            if(task.getException() instanceof FirebaseApiNotAvailableException) {

                            }
                        }
                    }

                });
    }*/

    public void proceed()
    {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
        bottomSheetDialog.show(getSupportFragmentManager(), "Bottom Sheet");
    }


}
