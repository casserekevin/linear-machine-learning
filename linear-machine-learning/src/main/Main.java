package main;

import java.util.Arrays;
import java.util.List;

import data.Data;
import model.LinearRegression;

public class Main {

	public static void main(String[] args) {

		List<Data> list = Arrays.asList(new Data(1, 1), new Data(2, 2), new Data(3, 3));

		LinearRegression lr = new LinearRegression(list, 4096);

		System.out.println("Theta0 = " + lr.getT0() + ", Theta1 = " + lr.getT1());
		lr.getGradientDescent();
		System.out.println("Theta0 = " + lr.getT0() + ", Theta1 = " + lr.getT1());
		System.out.println(lr.getPrediction(4));
		// 1 = Theta0 = 0.02000000000000000, Theta1 = 0.04666666666666666
		// 2 = Theta0 = 0.03886666666666667, Theta1 = 0.09075555555555555
		// 4 = Theta0 = 0.07344806740740741, Theta1 = 0.1717639224691358
		// 8 = Theta0 = 0.1315548126142529, Theta1 = 0.3086303812704052
		// 16 = Theta0 = 0.2136348939352657, Theta1 = 0.5047013815757235
		// 32 = Theta0 = 0.2952992267890502, Theta1 = 0.7090394106802707
		// 64 = Theta0 = 0.3317105352317914, Theta1 = 0.8281403021205049
		// 128 = Theta0 = 0.3157404565736590, Theta1 = 0.8604323650610072
		// 256 = Theta0 = 0.2709030300722154, Theta1 = 0.8808288393601931
		// 512 = Theta0 = 0.1991131518166560, Theta1 = 0.9124097827694540
		// 1024 = Theta0 = 0.1075651483571581, Theta1 = 0.9526819066191430
		// 2048 = Theta0 = 0.03139170089432447, Theta1 = 0.9861907368977033
		// 4096 = Theta0 = 0.002673630469660859, Theta1 = 0.9988238653675328

	}

}
