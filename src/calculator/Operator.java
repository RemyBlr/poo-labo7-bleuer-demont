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
  static Point point = new Point();
  static ClearEntry clearEntry = new ClearEntry();
  static Clear clear = new Clear();
  static Recpirocal recpirocal = new Recpirocal();
  static Opposite opposite = new Opposite();
  static squareRoot squareRoot = new squareRoot();
  static Square square = new Square();
  static Backspace backspace = new Backspace();
  static MemoryStore memoryStore = new MemoryStore();
  static MemoryRecall memoryRecall = new MemoryRecall();

  // Initialization of the Number instances
  static {
    for (int i = 0; i < 10; i++) {
      numbers[i] = new Number(i);
    }
  }

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

class ClearEntry extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class Clear extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class Recpirocal extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class Opposite extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class squareRoot extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class Square extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class Backspace extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class MemoryStore extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

class MemoryRecall extends Operator
{
  @Override
  void execute(State state)
  {
    // TODO
  }
}

