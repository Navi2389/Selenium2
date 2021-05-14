package project4TriangleFunction;
//функция, вычисляющая площадь треугольника по трём сторонам (int a, int b, int c)
public class TriangleFunction {
    public static boolean main(int args )
    {
        double a;

        a = triangleArea(3, 3, 3);
        System.out.println("Треугольник со сторонами 3,3,3 имеет площадь:" + a);

        a = triangleArea(3, 4, 5);
        System.out.println("Треугольник со сторонами 3,4,5 имеет площадь:" + a);

        a = triangleArea(9, 9, 0);
        System.out.println("Треугольник со сторонами 9,9,0 имеет площадь:" + a );

        return false;
    }

    public static double triangleArea( int a, int b, int c )
    {
        double s=(((a+b+c)/2)*((a+b+c)/2-a)*((a+b+c)/2-b)*((a+b+c)/2-c));
        return Math.sqrt(s);
    }
}
