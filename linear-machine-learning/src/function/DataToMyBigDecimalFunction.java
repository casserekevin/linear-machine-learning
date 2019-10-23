package function;

import java.util.function.Function;

import data.Data;
import model.MyBigDecimal;

@FunctionalInterface
public interface DataToMyBigDecimalFunction extends Function<Data, MyBigDecimal> {
}
