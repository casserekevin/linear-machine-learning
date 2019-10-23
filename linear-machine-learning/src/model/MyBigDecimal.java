package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MyBigDecimal {

	public static MyBigDecimal getZeroValue() { return new MyBigDecimal("0"); }

	private BigDecimal number;

	private MathContext context;

	public MyBigDecimal() {
		this.context = MathContext.DECIMAL64;
	}

	public MyBigDecimal(BigDecimal number) {
		this();
		this.number = number;

	}

	public MyBigDecimal(String number) {
		this();
		this.number = new BigDecimal(number);

	}

	public MyBigDecimal(int number) {
		this();
		this.number = new BigDecimal(number);

	}

	public BigDecimal getNumber() { return this.number; }

	public int getScale() { return this.number.scale(); }

	public void setScale(int scale) {
		this.number.setScale(scale);
	}

	public MyBigDecimal add(BigDecimal number) {
		BigDecimal result = this.number.add(number, this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal add(MyBigDecimal number) {
		BigDecimal result = this.number.add(number.getNumber(), this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal subtract(BigDecimal number) {
		BigDecimal result = this.number.subtract(number, this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal subtract(MyBigDecimal number) {
		BigDecimal result = this.number.subtract(number.getNumber(), this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal multiply(BigDecimal number) {
		BigDecimal result = this.number.multiply(number, this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal multiply(MyBigDecimal number) {
		BigDecimal result = this.number.multiply(number.getNumber(), this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal divide(BigDecimal number) {
		BigDecimal result = this.number.divide(number, this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal divide(MyBigDecimal number) {
		BigDecimal result = this.number.divide(number.getNumber(), this.context);

		return new MyBigDecimal(result);
	}

	public MyBigDecimal pow(int number) {
		BigDecimal result = this.number.pow(number, this.context);

		return new MyBigDecimal(result);
	}

	@Override
	public String toString() {
		return this.number.toString();
	}
}
