package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
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
    View buttonBackSpace = findViewById(R.id.buttonBackSpace);
    TextView outputView = findViewById(R.id.textViewCalculatorOutput);

    outputView.setText(calculator.output());

    plusButton.setOnClickListener(v->{
      calculator.insertPlus();
      outputView.setText(calculator.output());
    });

    minusButton.setOnClickListener(v->{
      calculator.insertMinus();
      outputView.setText(calculator.output());
    });

    clearButton.setOnClickListener(v->{
      calculator.clear();
      outputView.setText(calculator.output());
    });

    equalButton.setOnClickListener(v->{
      calculator.insertEquals();
      outputView.setText(calculator.output());
    });

    zeroButton.setOnClickListener(v->{
      calculator.insertDigit(0);
      outputView.setText(calculator.output());
    });

    oneButton.setOnClickListener(v->{
      calculator.insertDigit(1);
      outputView.setText(calculator.output());
    });

    twoButton.setOnClickListener(v->{
      calculator.insertDigit(2);
      outputView.setText(calculator.output());
    });

    threeButton.setOnClickListener(v->{
      calculator.insertDigit(3);
      outputView.setText(calculator.output());
    });

    fourButton.setOnClickListener(v->{
      calculator.insertDigit(4);
      outputView.setText(calculator.output());
    });

    fiveButton.setOnClickListener(v->{
      calculator.insertDigit(5);
      outputView.setText(calculator.output());
    });

    sixButton.setOnClickListener(v->{
      calculator.insertDigit(6);
      outputView.setText(calculator.output());
    });

    sevenButton.setOnClickListener(v->{
      calculator.insertDigit(7);
      outputView.setText(calculator.output());
    });

    eightButton.setOnClickListener(v->{
      calculator.insertDigit(8);
      outputView.setText(calculator.output());
    });

    nineButton.setOnClickListener(v->{
      calculator.insertDigit(9);
      outputView.setText(calculator.output());
    });

    buttonBackSpace.setOnClickListener(v->{
      calculator.deleteLast();
      outputView.setText(calculator.output());
    });
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    outState.putSerializable("calculatorState", calculator.saveState());
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    calculator.loadState(savedInstanceState.getSerializable("calculatorState"));
    TextView outputView = findViewById(R.id.textViewCalculatorOutput);
    outputView.setText(calculator.output());
  }
}