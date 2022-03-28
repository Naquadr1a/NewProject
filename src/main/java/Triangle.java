public class Triangle {

    public double triangleArea( double a, double b, double c){
        double sqrt = 0;
        try{
            if (a <= 0 || b <= 0 || c <= 0) {
                throw new Exception("Стороны треугольника не могут быть отрицатеного значения или быть равными нулю.");
            }
            if((a + b) < c || (a + c) < b || (b + c) < a) {
                throw new Exception("Такого треугольника не существует.");
            }else {
                double p = (a + b + c) * 0.5;
                sqrt = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println("Площадь треугольника равна " + sqrt);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return sqrt;
    }
}
