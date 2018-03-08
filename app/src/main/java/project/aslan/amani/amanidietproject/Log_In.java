package project.aslan.amani.amanidietproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.jar.Attributes;

import static android.view.View.*;

public class Log_In extends AppCompatActivity implements View.OnClickListener {
    private Button BTNSignIn;
    private TextView etPassword;
    private TextView etName;
    private Button BTNSignUp;
    private Button FMPassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
        BTNSignIn = (Button) findViewById(R.id.BTNSignIn);
        BTNSignUp = (Button) findViewById(R.id.BTNSingUp);
        etPassword = (TextView) findViewById(R.id.etPassword);
        etName = (TextView) findViewById(R.id.etName);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        BTNSignIn.setOnClickListener(this);
        BTNSignUp.setOnClickListener(this);
    }

    private void dataHandler() {
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        boolean isOk = true;//to check if all feilds are filled correctly

        signIn(name, password);


    }

    private void signIn(String username, String passw) {
        Task<AuthResult> authResultTask = auth.signInWithEmailAndPassword(username, passw).addOnCompleteListener(Log_In.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Log_In.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Log_In.this, SignUp.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Log_In.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view ==BTNSignIn)
            dataHandler();
        if (view==BTNSignUp)

        {
            Intent intent = new Intent(Log_In.this, SignUp.class);
            startActivity(intent);
        }

    }
}