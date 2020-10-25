package ru.vsu.cs.lazutkina;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        Picture picture = new Picture(new Circle(-1, 0, 4), new HorizontalParabola(3, 6, 0.125),
                new Rectangle(1, 8, 3, 7));

        finishProgramOnError(runTest(picture));
        readCoordinatesAndPrintColor(picture);
    }

    private static boolean runTest(Picture picture)
    {
        SimpleColor[] expectedColors = {SimpleColor.GREEN, SimpleColor.WHITE,
                SimpleColor.GREY, SimpleColor.BLUE, SimpleColor.YELLOW};

        Point[] points = {new Point(0, 0), new Point(1.1, 3.1), new Point(6, 6),
                new Point(9, 2), new Point(-7, 3)};

        boolean result = true;
        for (int i = 0; i < expectedColors.length; i++)
        {
            SimpleColor color = picture.getColor(points[i]);
            SimpleColor expectedColor = expectedColors[i];

            if (color != expectedColor)
            {
                printResult(points[i], color, expectedColor, "incorrect");
                result = false;
            }
            else
            {
                printResult(points[i], color, expectedColor, "correct");
            }
        }
        return result;
    }

    private static void readCoordinatesAndPrintColor(Picture picture)
    {
        double x = readCoordinate("x");
        double y = readCoordinate("y");
        Point point = new Point(x, y);
        SimpleColor color = picture.getColor(point);
        printColorForPoint(point, color);
    }

    private static double readCoordinate(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s from -10 to 10: ", name);
        return checkModuloCoordinateLess10(scanner.nextDouble());
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

    private static void printColorForPoint(Point point, SimpleColor color)
    {
        System.out.printf("(%.2f, %.2f)--> %s\n", point.x, point.y, color);
    }

    private static void printResult(Point point, SimpleColor color, SimpleColor expectedColor, String conclusion)
    {
        System.out.printf("(%.2f ; %.2f)-->%s;  Expected: %s; Тhe result is %s.\n",
                point.x, point.y, color, expectedColor, conclusion);
    }

    private static void finishProgramOnError(boolean result)
    {
        if (!result)
        {
            System.out.println("The program does not work correctly");
            System.exit(1);
        }
    }
}
