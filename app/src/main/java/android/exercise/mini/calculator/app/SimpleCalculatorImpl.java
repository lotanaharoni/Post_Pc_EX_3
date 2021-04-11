package android.exercise.mini.calculator.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalculatorImpl implements SimpleCalculator {

  // todo: add fields as needed
  private List<String> values;
  { //TODO: if legal
    values = new ArrayList<String>();
    values.add("0");
  }

  @Override
  public String output() {
    // todo: return output based on the current state
    String output = "";
    for (int i = 0; i < values.size(); i++)
    {
      output += values.get(i);
    }
    return output;
  }

  @Override
  public void insertDigit(int digit) {
    if (digit < 0 || digit > 9){
   //   throw new Exception(); ??????
      throw new RuntimeException();
    }
    if (this.values.size() == 1 && this.values.get(0).equals("0")){
      this.values.set(0, Integer.toString(digit));
    }
    else{
      this.values.add(Integer.toString(digit));
    }
    // todo: insert a digit
  }

  @Override
  public void insertPlus() {
    String lastSign = values.get(values.size() - 1);
    if (!lastSign.equals("+") && !lastSign.equals("-")){
      this.values.add("+");
    }
    // todo: insert a plus
  }

  @Override
  public void insertMinus() {
    String lastSign = values.get(values.size() - 1);
    if (!lastSign.equals("+") && !lastSign.equals("-")){
      this.values.add("-");
    }
    // todo: insert a minus
  }

  @Override //TODO
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
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
  }

  @Override
  public void clear() {
    this.values.clear();
    this.values.add("0");
    // todo: clear everything (same as no-input was never given)
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    state.values = new ArrayList<String>(this.values);

    // todo: insert all data to the state, so in the future we can load from this state
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;

    this.values = new ArrayList<String>(casted.values);
    // todo: use the CalculatorState to load
  }

    private static class CalculatorState implements Serializable{ //TODO
     private List<String> values;

    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
  }
}
