import java.util.Arrays;

public class Statistics {

    public static void stats (int [] scores){
        int n = scores.length;
        double average , sum =0;


        Arrays.sort(scores);                                    //sort the array in ascending order

        int max = scores[scores.length -1];                      //maximum score is the last element of the array

        int min = scores[0];                                     //minimum score is the first element of the array

        for(int i : scores)                                      //calculate the sum of all the scores and find the average
            sum += i;

        average = sum / n;
                                                                //print the results of maximum , minimum and the array
        System.out.println(
                "Values: \n" + "\n" +
                        "The maximum grade is " + max + "\n" +
                        "The minimum grade is " + min + "\n" +
                        "The average grade is " + average
        );
                                                                //initialize new array for the stats
        int [] stats  = new int[5];
                                                                //assign the frequencies of each range to an element of the array
        for(int score : scores){
            stats[0] += (score >=0 && score <=20)? 1 : 0;
            stats[1] += (score >20 && score <41)? 1 : 0;
            stats[2] += (score > 40 && score  < 61) ? 1 : 0;
            stats[3] += (score > 60 && score  < 81) ? 1 : 0;
            stats[4] += (score > 80) ? 1 : 0;
        }

                                                                //find the highest frequency. use it to create the stack of bars
        int maxHeight = 0;
        for (int stat : stats){
            if(stat > maxHeight)
                maxHeight = stat;
        }
                                                                //for every level, print the bar or a space for the particular range
        for(int i = maxHeight ; i > 0; i--){
            for (int stat: stats){
                if(stat >= i) {
                    System.out.print(" #######  ");
                }
                else
                    System.out.print("          ");
            }
            System.out.println();
        }

        System.out.println("+---------+---------+---------+---------+---------+");
        System.out.println("I  0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");

    }

    public static void main(String[] args) {
        int [] arr = {2 ,20, 21, 22, 23 ,30, 48, 49 ,50 ,55 ,60, 65 ,72, 63, 76, 80, 68, 90, 85 ,98};
        stats(arr);
    }
}
