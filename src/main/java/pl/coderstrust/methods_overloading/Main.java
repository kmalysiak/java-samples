package pl.coderstrust.methods_overloading;

public class Main {

    public static void main(String[] args) {
	// write your code here
//       int newScore =  calculateScore("Tim", 500);
//        System.out.println("New score is "+newScore);
//        calculateScore(10000);
//        calculateScore();
//        double Score;
        double Score;

        double value = 1000000000000.1d;
        double fractionalPart = value % 1d;
        double integralPart = value - fractionalPart;


        Score = calcFeetAndInchesToCentimeter(100000000000d);
        System.out.println(Score);
        Score = calcFeetAndInchesToCentimeter(0.1d,1d);
        System.out.println(Score);
    }
    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " scored "+ score + " points");
        return score *1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed Player "  + " scored "+ score + " points");
        return score *1000;
    }

    public static int calculateScore(){
        System.out.println("Unnamed Player "  + " no scored");
        return 0;
    }



    public static double calcFeetAndInchesToCentimeter(double feet, double inches){
        double result;
        if(feet>=0 && (inches>=0 && inches <=12)){
            result =  (feet*12d + inches) * 2.54d;
        }
        else result = -1;

        return result;


    }

    public static double calcFeetAndInchesToCentimeter(double inches){
        double result;
        double feet1 = inches / 12d;
        feet1 = (int) feet1;
        inches = (int) inches%12d;
        if(inches>=0){
            result =  calcFeetAndInchesToCentimeter(feet1, inches);
        }
        else result = -1;

        return result;


    }


}
