package ru.vsu.cs.lazutkina;

public class Picture
{
    private Circle circle;
    private HorizontalParabola parabola;
    private Rectangle rectangle;

    public Picture(Circle circle, HorizontalParabola parabola, Rectangle rectangle)
    {
        this.circle = circle;
        this.parabola = parabola;
        this.rectangle = rectangle;
    }

    public SimpleColor getColor(Point point)
    {
        double x = point.x;
        double y = point.y;

        if ((rectangle.isPointInside(x, y)) ^ (circle.isPointInside(x, y)) && !(parabola.isPointInside(x, y)))
        {
            return SimpleColor.GREEN;
        }
        if ((parabola.isPointInside(x, y)) && !(rectangle.isPointInside(x, y)))
        {
            return SimpleColor.BLUE;
        }
        if ((parabola.isPointInside(x, y)) && (rectangle.isPointInside(x, y)))
        {
            return SimpleColor.GREY;
        }
        if ((rectangle.isPointInside(x, y)) && (circle.isPointInside(x, y)))
        {
            return SimpleColor.WHITE;
        }
        return SimpleColor.YELLOW;
    }
}
