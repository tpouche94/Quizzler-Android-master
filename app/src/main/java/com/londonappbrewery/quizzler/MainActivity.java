package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {



    // TODO: Declare constants here


    // TODO: Declare member variables here:
    private Button true_Button;
    private Button false_Button;
    private TextView score_text;
    TextView mQuestionTextView;
    ProgressBar mProgressBar;
    int mIndex = 0;
    int mQuestion;
    private int score = 0;





    // TODO: Uncomment to create question bank

   private TrueFalse[] mQuestionBank = new TrueFalse[] {
           new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
           new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
           new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
           new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
           new TrueFalse(R.string.question_13,true)
    };

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        true_Button = (Button) findViewById(R.id.true_button);

        false_Button = (Button)findViewById(R.id.false_button);

        score_text = findViewById(R.id.score);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);





        true_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);
                updateQuestion();

            }
        });




        false_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                updateQuestion();

            }
        });


    }
    private void updateQuestion()
    {

            mIndex = (mIndex + 1) % mQuestionBank.length;

            if(mIndex==0)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setCancelable(false);
                alert.setMessage("You scored " + score + " points!");
                alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.show();
            }



            mQuestion = mQuestionBank[mIndex].getQuestionId();
            mQuestionTextView.setText(mQuestion);
            mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);

    }


    private void checkAnswer(boolean userSelection)
    {
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();

        if(userSelection == correctAnswer)
        {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            score++;
            score_text.setText("Score " +score +"/" +mQuestionBank.length);
        }
        else
        {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }
}
