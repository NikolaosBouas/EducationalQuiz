package com.example.android.educationalquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctQuestions = 0;
    int questionNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called when the start button is pressed.

    public void startQuiz(View view) {
        Button startButton = (Button) findViewById(R.id.start_button);
        ((ViewGroup) startButton.getParent()).removeView(startButton);
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setVisibility(View.VISIBLE);
        TextView questionTextview = (TextView) findViewById(R.id.question_text_view);
        questionTextview.setVisibility(View.VISIBLE);
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radio_group_1);
        radioGroup1.setVisibility(View.VISIBLE);
    }

    public void nextQuestion(View view) {
        questionNumber += 1;
        if (questionNumber == 2) {
            RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radio_group_1);
            ((ViewGroup) radioGroup1.getParent()).removeView(radioGroup1);
            RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio_group_2);
            radioGroup2.setVisibility(View.VISIBLE);
            TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
            questionTextView.setText(R.string.question2);
        }
        if (questionNumber == 3) {
            RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio_group_2);
            ((ViewGroup) radioGroup2.getParent()).removeView(radioGroup2);
            TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
            questionTextView.setText(R.string.question3);
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox11);
            checkBox1.setVisibility(View.VISIBLE);
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox12);
            checkBox2.setVisibility(View.VISIBLE);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox13);
            checkBox3.setVisibility(View.VISIBLE);
        }
        if (questionNumber == 4) {
            CheckBox CheckBox11 = (CheckBox) findViewById(R.id.checkbox11);
            CheckBox CheckBox12 = (CheckBox) findViewById(R.id.checkbox12);
            CheckBox CheckBox13 = (CheckBox) findViewById(R.id.checkbox13);
            boolean is3correct = (CheckBox11.isChecked() && CheckBox12.isChecked() && !CheckBox13.isChecked());
            if (is3correct) {
                correctQuestions += 1;
            }
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox11);
            ((ViewGroup) checkBox1.getParent()).removeView(checkBox1);
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox12);
            ((ViewGroup) checkBox2.getParent()).removeView(checkBox2);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox13);
            ((ViewGroup) checkBox3.getParent()).removeView(checkBox3);
            TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
            questionTextView.setText(R.string.question4);
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox21);
            checkBox4.setVisibility(View.VISIBLE);
            CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkbox22);
            checkBox5.setVisibility(View.VISIBLE);
            CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkbox23);
            checkBox6.setVisibility(View.VISIBLE);
        }
        if (questionNumber == 5) {
            CheckBox CheckBox21 = (CheckBox) findViewById(R.id.checkbox21);
            CheckBox CheckBox22 = (CheckBox) findViewById(R.id.checkbox22);
            CheckBox CheckBox23 = (CheckBox) findViewById(R.id.checkbox23);
            boolean is3correct = (!CheckBox21.isChecked() && CheckBox22.isChecked() && CheckBox23.isChecked());
            if (is3correct) {
                correctQuestions += 1;
            }
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox21);
            ((ViewGroup) checkBox1.getParent()).removeView(checkBox1);
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox22);
            ((ViewGroup) checkBox2.getParent()).removeView(checkBox2);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox23);
            ((ViewGroup) checkBox3.getParent()).removeView(checkBox3);
            TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
            questionTextView.setText(R.string.question5);
            Button submitButton = (Button) findViewById(R.id.submit_answers);
            submitButton.setVisibility(View.VISIBLE);
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);
            EditText editText = (EditText) findViewById(R.id.derivative_edit_text);
            editText.setVisibility(View.VISIBLE);
        }

    }

    public void checkAnswers(View view) {
        EditText derivativeEditText = (EditText) findViewById(R.id.derivative_edit_text);
        String answer5 = derivativeEditText.getText().toString();
        String correctAnswer5 = "e^x";
        if (answer5.equals(correctAnswer5)) {
            correctQuestions += 1;
        }
        Toast.makeText(this, "You got " + correctQuestions + " out of 5 correct!", Toast.LENGTH_SHORT).show();
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.correct1:
                if (checked)
                    correctQuestions += 1;
                // got the correct question
                break;
            case R.id.wrong11:
                if (checked)
                    break;
            case R.id.wrong12:
                if (checked)
                    break;
            case R.id.correct2:
                if (checked)
                    correctQuestions += 1;
                // got the correct question
                break;
            case R.id.wrong21:
                if (checked)
                    break;
            case R.id.wrong22:
                if (checked)
                    break;
        }
    }

}
