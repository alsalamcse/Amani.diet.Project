package project.aslan.amani.amanidietproject;

import android.os.health.PackageHealthStats;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private EditText ETName;
    private EditText ETEMail;
    private EditText ETPassword;
    private EditText ETWight;
    private EditText ETAge;
    private Button Save;
    private FirebaseAuth auth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ETName = (EditText) findViewById(R.id.ETName);
        ETEMail = (EditText) findViewById(R.id.EtEmail);
        ETPassword = (EditText) findViewById(R.id.EtWight);
        ETAge = (EditText) findViewById(R.id.EtAge);
        Save = (Button) findViewById(R.id.Save);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
    }

    private void dataHander() {
        String email = ETEMail.getText().toString();
        String passw = ETPassword.getText().toString();
        String name = ETName.getText().toString();
        boolean isOk = true;//to check if all feilds are filled correctly

        createAccount(email, passw);
    }
    public void createAccount(String email,String passw){
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUp.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(SignUp.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }

            }
        });
    }
}
