package uebung03.aufgabe11;

import uebung03.aufgabe11.Expression.ExpressionOperator;

public class TestExpression {

	public static void main(String[] args) {

		Variable var1 = new Variable(5.0);
		Variable var2 = new Variable(3.0);
		Variable var3 = new Variable(7.0);
		Variable var4 = new Variable(2.0);

		Expression ex1 = new Expression(ExpressionOperator.GETEILT, var1, var2);
		Expression ex2 = new Expression(ExpressionOperator.PLUS, ex1, var3);
		Expression ex3 = new Expression(ExpressionOperator.MINUS, ex2, var4);

		System.out.println("value: " + ex3.getValue());

	}

}
