package function;

import java.util.function.BinaryOperator;

import model.MyBigDecimal;

@FunctionalInterface
public interface MyBigDecimalBinaryOperator extends BinaryOperator<MyBigDecimal> {
}
