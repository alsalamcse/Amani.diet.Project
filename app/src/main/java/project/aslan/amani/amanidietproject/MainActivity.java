package project.aslan.amani.amanidietproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
////https://play.google.com/store/apps/details?id=com.mdiet.arabic
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button sports;
    private Button Advice;
    private Button progress;
    private Button DeitMeals;
    private Button Articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sports = (Button) findViewById(R.id.sports);
        Advice = (Button) findViewById(R.id.advice);
        progress = (Button) findViewById(R.id.progress);
        DeitMeals = (Button) findViewById(R.id.DeitMeals);

    }


    @Override
    public void onClick(View view) {

        if(sports==view){
        Intent i= new Intent(MainActivity.this,sports.class);
            startActivity(i);

    }
    if (Advice==view)
    {

            Intent i=new Intent(MainActivity.this,Advice.class);

    }
     if (progress==view){
         Intent i=new Intent(MainActivity.this,progress.class);

    }
   if (DeitMeals==view){
        Intent i=new Intent((MainActivity.this,meals.class);

    }

}











}
