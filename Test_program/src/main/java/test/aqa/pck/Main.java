package test.aqa.pck;

public class Main {
   public static void main(String[] args) {
      hello("world");
      hello("user");
      hello("Irina");

      double a = 5;
      System.out.println("Площадь квадрата со стороной " + a + " равна " + area(a));
   }
   public static void hello (String somebody) {
      System.out.println("Hello " + somebody + "!");
   }
   public static double area(double a) {
      return a*a;
   }
}