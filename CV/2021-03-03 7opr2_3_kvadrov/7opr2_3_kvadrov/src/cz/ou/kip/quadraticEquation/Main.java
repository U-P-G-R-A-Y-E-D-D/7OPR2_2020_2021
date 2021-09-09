package cz.ou.kip.quadraticEquation;

import java.util.Scanner;

import static cz.ou.kip.quadraticEquation.Utils.sf;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // program, který vypočítá kořeny kvadratické rovnice
    // hodnoty zadává uživatel ax^2 + bx + c = 0

    System.out.println("Zadejte kvadratickou rovnici ve tvaru 'ax^2 + bx + c = 0':");

    double a = readDoubleFromConsole("Zadejte 'a':");
    double b = readDoubleFromConsole("Zadejte 'b':");
    double c = readDoubleFromConsole("Zadejte 'c':");

    double[] result = calculateRootsOfQuadraticEquation(a, b, c);

    printQuadraticEquationResult(result);
  }

  private static void printQuadraticEquationResult(double[] result) {
    switch (result.length) {
      case 0:
        System.out.println("Zadaná rovnice nemá řešení v R.");
        break;
      case 1:
        System.out.println(sf("Rovnice má jeden kořen %.2f.",result[0]));
        break;
      case 2:
        System.out.println(
                sf("Rovnice má dva kořeny: %.2f; %.2f.", result[0], result[1]));
        break;
      default:
        throw new RuntimeException("Pole má divnou délku. Chyba aplikace.");
    }
  }

  private static double[] calculateRootsOfQuadraticEquation(double a, double b, double c) {
    double[] ret;
    double d = (b * b) - (4 * a * c);

    if (d < 0) {
      ret = new double[0];
    } else if (d == 0) {
      double x1 = -b / (2 * a);
      ret = new double[]{x1};
    } else {
      double x1 = (-b + Math.sqrt(d)) / (2 * a);
      double x2 = (-b - Math.sqrt(d)) / (2 * a);
      ret = new double[]{x1, x2};
    }

    return ret;
  }

  private static double readDoubleFromConsole(String message) {
    System.out.println(message);
    double ret;

    do {
      String sa = scanner.nextLine();
      try {
        ret = Double.parseDouble(sa);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Zadaná hodnota " + sa + " není převeditelná na desetinné číslo. Prosím zadejte znovu:");
      }
    } while (true);

    return ret;
  }
}


// není řešení R
// jedno řešení
// dvě řešení

// přepravka (Messenger) - 5
// pole / list - 8
// String - 0
// dědičnost - 1

//enum QuadraticEquationResultType{
//  NO_SOLUTION,
//  ONE_SOLUTION,
//  TWO_SOLUTIONS
//}
//
//class QuadraticEquationResultMessenger{
//  private double x1;
//  private double x2;
//  private QuadraticEquationResultType type;
//}
