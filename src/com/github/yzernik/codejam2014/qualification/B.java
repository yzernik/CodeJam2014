package com.github.yzernik.codejam2014.qualification;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {

		B a = new B();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			double C = sc.nextDouble();
			double F = sc.nextDouble();
			double X = sc.nextDouble();

			String result = a.solve(C, F, X);
			System.out.format("Case #%d: %s%n", t + 1, result);
		}

		sc.close();

	}

	public String solve(double C, double F, double X) {

		Double lastTotalTime = Double.MAX_VALUE;
		Double buildingsTime = 0.0;
		Double rate = 2.0;
		Double totalTime = X / rate;

		int n = 0;

		while (totalTime < lastTotalTime) {
			lastTotalTime = totalTime;
			buildingsTime += timeForNextBuilding(C, rate);
			rate = 2 + ((n + 1) * F);
			totalTime = buildingsTime + (X / rate);

			n++;
		}

		return Double.toString(lastTotalTime);
	}

	public Double timeForNextBuilding(double C, Double rate) {
		return C / rate;
	}
}
