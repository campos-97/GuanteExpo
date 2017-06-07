package CTPMora.ExpoIng;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by josea on 5/21/2017.
 */

public class Alphabet {

    static Alphabet instance = null;
    public int range = 3;

    static ArrayList<int[]> resistorValues = new ArrayList<>();
    static ArrayList<String> letters = new ArrayList<>();

    public static Alphabet getInstance(){

        if(instance == null){

            instance = new Alphabet();

            int a[]  = {150,150,0,0,0};
            letters.add("a");
            resistorValues.add(a);
        }

        return instance;

    }

    public String mapChar(int[] input){
        String result = "";

        int index = 0;
        int prevDelta = Math.abs(Integer.MAX_VALUE)/2;

        for(int[] resistorValue : resistorValues){
            int delta = 0;
            for(int i = 0; i < input.length ; i++){
                if(input[i] <= resistorValue[i]+range &&
                        input[i] >= resistorValue[i]-range) {

                    delta += Math.abs(input[i] - resistorValue[i]);
                    //System.out.println("Input=  "+input[i]+"  ResistorValue=  "+resistorValue[i]);
                }else{
                    delta = Math.abs(Integer.MAX_VALUE);
                }
            }
            //System.out.println("Delta=  "+Math.abs(delta)+"  PrevDelta=  "+Math.abs(prevDelta));
            if(Math.abs(delta) <= Math.abs(prevDelta)){
                prevDelta = Math.abs(delta);
                result = letters.get(index);
            }

            index++;
        }

        return result;
    }

}
