package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class SimpleCalculatorImplTest {

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertPlus();
    assertEquals("0+", calculatorUnderTest.output());
  }


  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertMinus();
    String expected = "0-";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      // good :)
    }
  }


  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    assertEquals("12", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.deleteLast();
    assertEquals("1", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    assertEquals("2+", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.deleteLast();
    assertEquals("2-3", calculatorUnderTest.output());
  }

  @Test
  public void when_doing_long_calculation_then_lastOutputShouldBeCorrect() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(8);

    assertEquals("540+8", calculatorUnderTest.output());
  }

  @Test
  public void when_doing_long_calculation_and_saving_OutputShouldLoadCorrectly() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(8);

    Serializable savedData = calculatorUnderTest.saveState();
    assertNotNull(savedData);

    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.loadState(savedData);
    assertEquals("540+8", calculatorUnderTest.output());
  }

  @Test
  public void when_doing_calculation_with_long_numbers_OutputShouldBeCorrect() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(2);

    assertEquals("128+532-222", calculatorUnderTest.output());
  }

  @Test
  public void when_doing_calculation_with_long_numbers_and_call_Equal_OutputShouldBeCorrect() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertEquals();

    assertEquals("438", calculatorUnderTest.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);

    // save current state
    Serializable savedState = calculatorUnderTest.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // load the saved state and make sure state was loaded correctly
    calculatorUnderTest.loadState(savedState);
    assertEquals("5+7", calculatorUnderTest.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertDigit(5);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(7);

    Serializable savedData = firstCalculator.saveState();
    assertNotNull(savedData);

    firstCalculator.clear();
    assertEquals("0", firstCalculator.output());

    secondCalculator.loadState(savedData);
    assertEquals("5+7", secondCalculator.output());
  }

  @Test
  public void when_saving_last_inputStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertDigit(5);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(7);
    firstCalculator.insertDigit(4);
    firstCalculator.insertDigit(3);
    firstCalculator.insertPlus();
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.deleteLast();
    firstCalculator.insertDigit(4);

    Serializable savedData = firstCalculator.saveState();
    assertNotNull(savedData);

    firstCalculator.clear();
    assertEquals("0", firstCalculator.output());

    secondCalculator.loadState(savedData);
    assertEquals("5+743+14", secondCalculator.output());
  }

  @Test
  public void when_saving_empty_StateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();

    Serializable savedData = firstCalculator.saveState();
    assertNotNull(savedData);

    firstCalculator.clear();
    assertEquals("0", firstCalculator.output());

    secondCalculator.loadState(savedData);
    assertEquals("0", secondCalculator.output());
  }

  @Test
  public void when_loading_StateFromNotEmptySecondCalculator_should_loadStateCorrectly(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertDigit(3);
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(2);

    secondCalculator.insertDigit(2);

    Serializable savedData = firstCalculator.saveState();
    assertNotNull(savedData);

    firstCalculator.clear();
    assertEquals("0", firstCalculator.output());

    secondCalculator.loadState(savedData);
    assertEquals("3-2", secondCalculator.output());
  }

  @Test
  public void when_insert_data_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertPlus();
    assertEquals("14-5+7-83+", calculatorUnderTest.output());
  }

  @Test
  public void when_insert_multiply_orders_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    assertEquals("15-7", calculatorUnderTest.output());
  }

  @Test
  public void when_insert_multiply_zeroes_outputShouldContainsOneZero(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertDigit(0);
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_callingEqual_then_outputShouldBeCalculated(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    assertEquals("-67", calculatorUnderTest.output());

    calculatorUnderTest.clear();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    assertEquals("42", calculatorUnderTest.output());
  }
}