package ru.vsu.cs.lazutkina;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        Picture picture = new Picture(new Circle(-1, 0, 4), new HorizontalParabola(3, 6, 0.125),
                          new Rectangle(1, 8, 3, 7));
        runTest(picture);
        double x = readCoordinate("x");
        double y = readCoordinate("y");
        printColorForPoint(x, y, picture);
    }

    private static void printColorForPoint(double x, double y, Picture picture)
    {
        System.out.printf("(%.2f, %.2f) -> %s\n", x, y, picture.getColor(x, y));
    }

    private static double readCoordinate(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s from -10 to 10: ", name);
        return checkModuloCoordinateLess10(scanner.nextDouble());
    }

    private static void runTest(Picture picture)
    {
        SimpleColor[] colors = SimpleColor.values();
        double[][] arrayOfPoints = {{0, 1.1, 6, 9, -7}, {0, 3.1, 6, 2, 3}};
        if (arrayOfPoints[0].length == colors.length)
        {
            for (int i = 0; i < colors.length; i++)
            {
                System.out.printf("(%.2f ; %.2f)-->%s  Expected: %s\n", arrayOfPoints[0][i], arrayOfPoints[1][i],
                                          picture.getColor(arrayOfPoints[0][i], arrayOfPoints[1][i]), colors[i]);
            }
        }
        else
        {
            reportError();
        }
    }

    private static double checkModuloCoordinateLess10(double coordinate)
    {
        if (coordinate < -10 || coordinate > 10)
        {
            reportError();
            Scanner newCoordinate = new Scanner(System.in);
            return checkModuloCoordinateLess10(newCoordinate.nextDouble());
        }
        return coordinate;
    }

    private static void reportError()
    {
        System.out.print("Error! Try again ");
    }
}
