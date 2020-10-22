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

        Point point = new Point(x, y);
        SimpleColor color = picture.getColor(point);
        printColorForPoint(point, color);
    }

    private static void printColorForPoint(Point point, SimpleColor color)
    {
        System.out.printf("(%.2f, %.2f)--> %s\n", point.x, point.y, color);
    }

    private static double readCoordinate(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s from -10 to 10: ", name);
        return checkModuloCoordinateLess10(scanner.nextDouble());
    }

    private static void runTest(Picture picture)
    {
        SimpleColor[] expectedColors = {SimpleColor.GREEN, SimpleColor.WHITE,
                                        SimpleColor.GREY, SimpleColor.BLUE, SimpleColor.YELLOW};
        double[][] arrayOfPoints = {{0, 1.1, 6, 9, -7}, {0, 3.1, 6, 2, 3}};

        for (int i = 0; i < expectedColors.length; i++)
            {
                Point point = new Point(arrayOfPoints[0][i], arrayOfPoints[1][i]);

                SimpleColor color = picture.getColor(point);
                SimpleColor expectedColor = expectedColors[i];

                if (color == expectedColor)
                {
                    printResult(point, color, expectedColor, "correct");
                }
                else
                {
                    printResult(point, color, expectedColor, "incorrect");
                }
            }
    }

    private static double checkModuloCoordinateLess10(double coordinate)
    {
        if (coordinate < -10 || coordinate > 10)
        {
            System.out.print("Error! Try again: ");
            Scanner newCoordinate = new Scanner(System.in);
            return checkModuloCoordinateLess10(newCoordinate.nextDouble());
        }
        return coordinate;
    }

    private static void printResult(Point point, SimpleColor color, SimpleColor expectedColor, String conclusion)
    {
        System.out.printf("(%.2f ; %.2f)-->%s;  Expected: %s; Тhe result is %s.\n",
                point.x, point.y, color, expectedColor, conclusion);
    }
}
