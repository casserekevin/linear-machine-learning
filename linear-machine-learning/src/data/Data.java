package data;

import java.math.BigDecimal;

import model.MyBigDecimal;

public class Data {

	public MyBigDecimal x;
	public MyBigDecimal y;

	public Data(double x, double y) {
		this.x = new MyBigDecimal(new BigDecimal(Double.toString(x)));
		this.y = new MyBigDecimal(new BigDecimal(Double.toString(y)));
	}
}
