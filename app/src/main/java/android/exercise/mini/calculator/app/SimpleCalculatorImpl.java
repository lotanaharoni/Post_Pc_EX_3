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
    boolean negativeFlag = false;
    String temp = "";
    int sum = 0;
    int tempFinal = 0;

    if(!this.values.get(values.size() - 1).equals("+") &&
            !this.values.get(values.size() - 1).equals("-")){
      for(int i = 0; i < this.values.size(); i++){
        if (this.values.get(i).equals("+")){
          for(int j = 0; j < temp.length(); j++){
            tempFinal += (temp.charAt(j) - '0') * (Math.pow(10, temp.length() - j - 1));
          }
          if (negativeFlag) {
            tempFinal = (-1) * tempFinal;
          }
          sum += tempFinal;
          negativeFlag = false;
          tempFinal = 0;
          temp = "";
        }

        else if (this.values.get(i).equals("-")){
          for(int j = 0; j < temp.length(); j++){
            tempFinal += (temp.charAt(j) - '0') * (Math.pow(10, temp.length() - j - 1));
          }
          if (negativeFlag) {
            tempFinal = (-1) * tempFinal;
          }
          sum += tempFinal;
          tempFinal = 0;
          negativeFlag = true;
          temp = "";
        }
        else{
          temp += (this.values.get(i));
        }
      }

      for(int j = 0; j < temp.length(); j++){
        tempFinal += (temp.charAt(j) - '0') * (Math.pow(10, temp.length() - j - 1));
      }
      if(negativeFlag){
        tempFinal = (-1) * tempFinal;
      }
      sum += tempFinal;
      this.values.clear();
      this.values.add(Integer.toString(sum));
    }
    else{
      throw new RuntimeException();
    }
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
