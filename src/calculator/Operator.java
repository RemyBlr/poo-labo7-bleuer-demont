package calculator;
import java.lang.*;

abstract class Operator
{
  static Addition addition = new Addition();
  static Substraction substraction = new Substraction();
  static Multiplication multiplication = new Multiplication();
  static Division division = new Division();

  abstract void execute();
}

class Addition extends Operator {
  @Override
  void execute()
  {
    System.out.println("Addition");
  }
}

class Substraction extends Operator
{
  @Override
  void execute()
  {
    System.out.println("Substraction");
  }
}

class Multiplication extends Operator
{
  @Override
  void execute()
  {
    // TODO
  }
}

class Division extends Operator
{
  @Override
  void execute()
  {
    // TODO
  }
}