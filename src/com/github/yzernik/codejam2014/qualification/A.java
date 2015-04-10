package com.github.yzernik.codejam2014.qualification;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

	public static void main(String[] args) {

		A a = new A();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int answer1 = a.readAnswer(sc);
			int[][] cards1 = a.readCards(sc);

			int answer2 = a.readAnswer(sc);
			int[][] cards2 = a.readCards(sc);

			String result = a.solve(answer1, cards1, answer2, cards2);
			System.out.format("Case #%d: %s%n", t + 1, result);
		}

		sc.close();

	}

	public int readAnswer(Scanner sc) {
		return sc.nextInt();
	}

	public int[][] readCards(Scanner sc) {
		int[][] cards = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cards[i][j] = sc.nextInt();
			}
		}
		return cards;
	}

	public Set<Integer> makeCardSet(int answer, int[][] cards) {
		Set<Integer> ret = new HashSet<Integer>();
		for (int card : cards[answer - 1]) {
			ret.add(card);
		}
		return ret;
	}

	public String solve(int answer1, int[][] cards1, int answer2, int[][] cards2) {

		Set<Integer> s1 = makeCardSet(answer1, cards1);
		Set<Integer> s2 = makeCardSet(answer2, cards2);

		Set<Integer> intersection = new HashSet<Integer>(s1);
		intersection.retainAll(s2);

		if (intersection.size() == 0) {
			return "Volunteer cheated!";
		} else if (intersection.size() > 1) {
			return "Bad magician!";
		} else {
			int n = (Integer) (intersection.toArray()[0]);
			return Integer.toString(n);
		}
	}
}
