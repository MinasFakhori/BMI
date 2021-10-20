package app.netlify.minasfakhoricv.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText feet;
    private EditText inches;
    private EditText weight;
    private Button button;
    private TextView results;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        onClick();
    }

    private void findViews(){
        male = findViewById(R.id.radio_button_male);
        female = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.edit_text_age);
        feet = findViewById(R.id.edit_text_feet);
        inches = findViewById(R.id.edit_text_inches);
        weight = findViewById(R.id.edit_text_weight);
        button = findViewById(R.id.button_calculate);
        results = findViewById(R.id.text_view_results);
    }

    private void onClick(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (age.getText().toString().compareTo("") == 0){

                }else if (feet.getText().toString().compareTo("") == 0){

                }else if (inches.getText().toString().compareTo("") == 0){

                }else if( weight.getText().toString().compareTo("") == 0){

                } else {
                   double bmiResult= calculateBmi();
                    displayResults(bmiResult);
                }




            }
        });
    }

    private double calculateBmi() {
      String getAge = age.getText().toString();
      String getFeet = feet.getText().toString();
      String getInches = inches.getText().toString();
      String getWeight = weight.getText().toString();

      int age = Integer.parseInt(getAge);
      int feet = Integer.parseInt(getFeet);
      int inches = Integer.parseInt(getInches);
      int weight = Integer.parseInt(getWeight);

      int totalInches = (feet*12)+inches;

      double heightInMeters = totalInches*0.0254;

        return weight / (heightInMeters*heightInMeters);

    }

    private void displayResults(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiString = myDecimalFormatter.format(bmi);

        String fullResultsString;
        if(bmi < 18.5){
            fullResultsString = bmiString + " - you are underweight";
        }else if (bmi > 25 ){
            fullResultsString = bmiString + " - you are overweight";
        }else{
            fullResultsString = bmiString + " - you are a healthy weight";
        }results.setText(fullResultsString);
    }


}