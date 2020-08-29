package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {



    // TODO: Declare constants here


    // TODO: Declare member variables here:
    private Button true_Button;
    private Button false_Button;
    private TextView score_text;
    int mIndex;
    int mQuestion;
    TextView mQuestionTextView;
    private int score = 0;
    private int count = 1;





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


   final int arraySize = mQuestionBank.length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        true_Button = (Button) findViewById(R.id.true_button);

        false_Button = (Button)findViewById(R.id.false_button);

        score_text = findViewById(R.id.score);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);





        true_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuestion = mQuestionBank[mIndex].getQuestionId();
                mQuestionTextView.setText(mQuestion);
                mIndex++;

                updateQuestion();
                score++;
                score_text.setText("Score " +score +"/13");

            }
        });




        false_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateQuestion();
                score++;
                score_text.setText("Score " +score +"/13");
            }
        });


    }
    private void updateQuestion()
    {

            mIndex = (mIndex + 1) % arraySize;
            mQuestion = mQuestionBank[mIndex].getQuestionId();
            mQuestionTextView.setText(mQuestion);

    }
}
