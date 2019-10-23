package model;

import java.math.BigDecimal;
import java.util.List;

import data.Data;
import function.DataToMyBigDecimalFunction;
import function.MyBigDecimalBinaryOperator;

/*
 * y = a * bx
 *
 *  Gradient Descent = 1/(2m) * E(ho(x) - y)^2
 * ho(x) = a * bx
 *
 * */

public class LinearRegression {

	private List<Data> datas;

	private MyBigDecimal t0;
	private MyBigDecimal t1;

	private MyBigDecimal learningRate;

	private int cycles;

	public LinearRegression(List<Data> datas, int cycles) {

		this.datas = datas;

		this.t0 = new MyBigDecimal("0");
		this.t1 = new MyBigDecimal("0");

		this.learningRate = new MyBigDecimal("0.01");
		this.cycles = cycles;
	}

	public MyBigDecimal getPrediction(double x) {

		String value = Double.toString(x);

		return this.t0.add(this.t1.multiply(new MyBigDecimal(value)));
	}

	public MyBigDecimal getPrediction(BigDecimal x) {
		return this.t0.add(this.t1.multiply(x));
	}

	public MyBigDecimal getPrediction(MyBigDecimal x) {
		return this.t0.add(this.t1.multiply(x));
	}

	public MyBigDecimal getCostFunction() {

		DataToMyBigDecimalFunction f_map = (data) -> this.getPrediction(data.x).subtract(data.y).pow(2);
		MyBigDecimalBinaryOperator f_reduce = (t, u) -> t.add(u);

		MyBigDecimal twoM = new MyBigDecimal("2").multiply(new MyBigDecimal(Integer.toString(this.datas.size())));

		return this.datas.stream().map(f_map).reduce(new MyBigDecimal("0"), f_reduce).divide(twoM);
	}

	public void getGradientDescent() {
		MyBigDecimal tempT0 = null;
		MyBigDecimal tempT1 = null;

		for (int i = 0; i < this.cycles; i++) {
			tempT0 = new MyBigDecimal("0");
			tempT1 = new MyBigDecimal("0");

			//--------------------------

			MyBigDecimalBinaryOperator f_reduce = (t, u) -> t.add(u);

			//First number
			DataToMyBigDecimalFunction f_t0_map = (data) -> new MyBigDecimal("-1").divide(new MyBigDecimal(this.datas.size())).multiply(data.y.subtract(this.getPrediction(data.x)));
			tempT0 = this.datas.stream().map(f_t0_map).reduce(new MyBigDecimal("0"), f_reduce);

			//Second number
			DataToMyBigDecimalFunction f_t1_map = (data) -> new MyBigDecimal("-1").divide(new MyBigDecimal(this.datas.size())).multiply(data.y.subtract(this.getPrediction(data.x))).multiply(data.x);
			tempT1 = this.datas.stream().map(f_t1_map).reduce(new MyBigDecimal("0"), f_reduce);

			//----------------------------

			this.t0 = tempT0.multiply(this.learningRate).subtract(this.t0).multiply(new MyBigDecimal("-1"));
			this.t1 = tempT1.multiply(this.learningRate).subtract(this.t1).multiply(new MyBigDecimal("-1"));

		}

	}

	public MyBigDecimal getT0() { return this.t0; }

	public void setT0(MyBigDecimal t0) { this.t0 = t0; }

	public void setT0(double t0) { this.t0 = new MyBigDecimal(Double.toString(t0)); }

	public MyBigDecimal getT1() { return this.t1; }

	public void setT1(MyBigDecimal t1) { this.t1 = t1; }

	public void setT1(double t1) { this.t1 = new MyBigDecimal(Double.toString(t1)); }

}
