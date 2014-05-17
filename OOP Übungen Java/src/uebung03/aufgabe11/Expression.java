package uebung03.aufgabe11;

public class Expression implements IValueable {

	private ExpressionOperator operator;
	private IValueable var1;
	private IValueable var2;

	public Expression(ExpressionOperator pOperator, IValueable pVar1, IValueable pVar2) {
		if (pOperator == ExpressionOperator.GETEILT && pVar2.getValue() == 0.) {
			throw new IllegalArgumentException("Teilen durch 0 ist nicht erlaubt!");
		}
		this.operator = pOperator;
		this.var1 = pVar1;
		this.var2 = pVar2;
	}

	@Override
	public double getValue() {
		switch (operator) {
		case PLUS:
			return var1.getValue() + var2.getValue();
		case MINUS:
			return var1.getValue() - var2.getValue();
		case MAL:
			return var1.getValue() * var2.getValue();
		case GETEILT:
			return var1.getValue() / var2.getValue();
		}
		return 0.0;
	}

	public enum ExpressionOperator {

		PLUS, MINUS, MAL, GETEILT

	}

}
