package util;

import java.math.BigDecimal;

public class NumberAdjuster {

	private static int scale = 16;

	public static int getScale() { return NumberAdjuster.scale; }

	private static boolean isDouble(BigDecimal number) {

		return number.toString().contains(".");
	}

	public static int adjustMantissa(BigDecimal number) {
		int adjustmentValue = -1;

		if (NumberAdjuster.isDouble(number)) {
			adjustmentValue = NumberAdjuster.scale - number.scale();
			adjustmentValue += NumberAdjuster.scale;

		}

		return adjustmentValue;
	}
}
