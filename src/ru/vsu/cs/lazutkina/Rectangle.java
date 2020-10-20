package ru.vsu.cs.lazutkina;

public class Rectangle
{
    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public Rectangle(double x1, double x2, double y1, double y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public boolean isPointInside(double x, double y)
    {
        return x1<=x && x<=x2 && y1<=y && y<=y2;
    }
}
