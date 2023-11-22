package calculator;

import util.Stack;

import java.lang.*;

abstract class Operator
{
  static Addition addition = new Addition();
  static Substraction substraction = new Substraction();
  static Multiplication multiplication = new Multiplication();
  static Division division = new Division();
  static Enter enter = new Enter();
  static Number[] numbers = new Number[10];

  // Initialization of the Number instances
  static {
    for (int i = 0; i < 10; i++) {
      numbers[i] = new Number(i);
    }
  }

  static Point point = new Point();


  abstract void execute(State state);
}

class Addition extends Operator {
  @Override
  void execute(State state)
  {
    System.out.println("Addition");
    Stack<Double> a = state.getStack();
    a.push(a.pop() + a.pop());
  }
}

class Substraction extends Operator
{
  @Override
  void execute(State state)
  {
    System.out.println("Substraction");
  }
}

class Multiplication extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO

  }
}

class Division extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}
 class Number extends Operator {
  private int value;

  public Number(int value) {
    this.value = value;
  }

  @Override
  void execute(State state) {
      state.setCurrentValue(state.getCurrentValue() * 10 + value);
  }
}

class Enter extends Operator
{
  @Override
  void execute(State state)
  {
      state.getStack().push(state.getCurrentValue());
      state.setCurrentValue(0);
  }
}

class Point extends Operator
{
  @Override
  void execute(State state)
  {

  }
}