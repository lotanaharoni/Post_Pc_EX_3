package android.exercise.mini.calculator.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalculatorImpl implements SimpleCalculator {

  private List<String> values;
  {
    values = new ArrayList<String>();
    values.add("0");
  }

  @Override
  public String output() {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < values.size(); i++)
    {
      output.append(values.get(i));
    }
    return output.toString();
  }

  @Override
  public void insertDigit(int digit) {
    if (digit < 0 || digit > 9){
      throw new RuntimeException();
    }
    if (this.values.size() == 1 && this.values.get(0).equals("0")){
      this.values.set(0, Integer.toString(digit));
    }
    else{
      this.values.add(Integer.toString(digit));
    }
  }

  @Override
  public void insertPlus() {
    String lastSign = values.get(values.size() - 1);
    if (!lastSign.equals("+") && !lastSign.equals("-")){
      this.values.add("+");
    }
  }

  @Override
  public void insertMinus() {
    String lastSign = values.get(values.size() - 1);
    if (!lastSign.equals("+") && !lastSign.equals("-")){
      this.values.add("-");
    }
  }

  @Override
  public void insertEquals() {
    String output = "";
    int sum = 0;
    for(int i = 0; i < this.values.size(); i++){
      if (this.values.get(i).equals("+")){

      }
      else if (this.values.get(i).equals("-")){

      }
      else{
     //   sum += int(Math.pow(10, i + 1)) * this.values.get(i);
      }
      this.values.clear();
    //  for (int j = 0; j < )
    }
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
  }

  @Override
  public void deleteLast() {
    if (values.size() != 1){
      values.remove(values.size() - 1);
    }
    else {
      this.values.set(0, "0");
    }
  }

  @Override
  public void clear() {
    this.values.clear();
    this.values.add("0");
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    state.values = new ArrayList<String>(this.values);
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    this.values = new ArrayList<String>(casted.values);
  }

    private static class CalculatorState implements Serializable{
     private List<String> values;
  }
}
