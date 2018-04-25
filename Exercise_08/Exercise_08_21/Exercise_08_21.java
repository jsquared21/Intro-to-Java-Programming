import java.util.Scanner;
public class Exercise_08_21{

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter number of cities: ");
        double[][] points = new double[reader.nextInt()][2];
        for(int i = 0; i < points.length; i++){
          points[i][0] = reader.nextDouble();
          points[i][1] = reader.nextDouble();
        }
        double shortestDist = totalDistance(points,0);
        int shortestPoint = 0;
        double temp;
        for(int i = 1; i < points.length; i++){
          temp = totalDistance(points,i);
          if(shortestDist > temp){
            shortestDist = temp;
            shortestPoint = i;
          }
        }
        System.out.println("The central city is at(" + points[shortestPoint][0] + ", " + points[shortestPoint][1]+")");
        System.out.println("The total distance to all other cities is " + shortestDist);

    }
    public static double totalDistance(double[][] array,int point){
      double distance = 0;
      for(int i = 0; i < array.length; i++)
        distance += distance(array[point][0],array[point][1],array[i][0],array[i][1]);
      return distance;
    }


    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2- x1, 2) + Math.pow(y2-y1,2));
    }
}
