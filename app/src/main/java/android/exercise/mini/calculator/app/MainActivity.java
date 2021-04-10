package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }

    TextView plusButton = findViewById(R.id.buttonPlus);
    TextView minusButton = findViewById(R.id.buttonMinus);
    TextView clearButton = findViewById(R.id.buttonClear);
    TextView equalButton = findViewById(R.id.buttonEquals);
   // TextView backSpaceButton = findViewById(R.id.buttonBackSpace);
    TextView zeroButton = findViewById(R.id.button0);
    TextView oneButton = findViewById(R.id.button1);
    TextView twoButton = findViewById(R.id.button2);
    TextView threeButton = findViewById(R.id.button3);
    TextView fourButton = findViewById(R.id.button4);
    TextView fiveButton = findViewById(R.id.button5);
    TextView sixButton = findViewById(R.id.button6);
    TextView sevenButton = findViewById(R.id.button7);
    TextView eightButton = findViewById(R.id.button8);
    TextView nineButton = findViewById(R.id.button9);
    ImageView backSpaceImageView = findViewById(R.id.backSpaceImage);
    TextView outputView = findViewById(R.id.textViewCalculatorOutput);

   // outputView.setText("");
    // 2?

    plusButton.setOnClickListener(v->{
      calculator.insertPlus();
    });

    minusButton.setOnClickListener(v->{
      calculator.insertMinus();
    });

    clearButton.setOnClickListener(v->{
      calculator.clear();
    });

    equalButton.setOnClickListener(v->{
      calculator.insertEquals();
    });

    zeroButton.setOnClickListener(v->{
      calculator.insertDigit(1);
    });

    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
  }
}