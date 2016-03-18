package com.malikmotan.randomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//---------------------------Variables and widgets declaration-------------------
    public TextView title;
    public TextView counter;
    String titleText;
    int randomNum;
    int attempts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//-----------------initializing the random number generator and storring it in randomNum------
        Random randomGenerator = new Random();
        randomNum = randomGenerator.nextInt(1001);
        attempts = 0;
    }

    public void startGuess(View view) {

        EditText guessedNumber = (EditText) findViewById(R.id.guess);
        String guessedNumberString = guessedNumber.getText().toString();
        int guessedNum = Integer.parseInt(guessedNumberString);

        String toastMessage = "";
        title = (TextView) findViewById(R.id.title);

        //--------Handling the event when the button is clicked----------------------
        if (guessedNum == randomNum) {
            attempts++;
            toastMessage = "Bang! You're right! The Number is " + randomNum + ". It took you " + attempts + " attempts!";
            titleText = "Let's start again! Enter Your Guess Below!";

            Random randomGenerator = new Random();
            randomNum = randomGenerator.nextInt(1001);
            attempts = 0;
        }
        else if ((guessedNum == (randomNum+5)) | (guessedNum == (randomNum-5)))
        {
                toastMessage = "Very Close :)";
                titleText = guessedNum + " is Very Close :)";
                attempts++;

            } else if (guessedNum > randomNum)
        {
                toastMessage = "Incorrect. Guess Lower!";
                titleText = guessedNum + " is Incorrect. Guess Lower!";
                attempts++;

            } else
        {
                toastMessage = "Incorrect. Guess Higher!";
                titleText = guessedNum + " is Incorrect. Guess Higher!";
                attempts++;

            }


        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
        title.setText(titleText);
        guessedNumber.setText("");
        counter = (TextView) findViewById(R.id.guessCounter);
        counter.setText("Guesses: " + attempts);

    }

    public void restartGuess(View view){

        Random randomGenerator = new Random();
        randomNum = randomGenerator.nextInt(1001);
        attempts = 0;

        String toastMessage = " Let's Start Again!";
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
        counter.setText("0" + attempts);
        title = (TextView) findViewById(R.id.title);
        title.setText("Enter Your Guess Below:");

    }


}
