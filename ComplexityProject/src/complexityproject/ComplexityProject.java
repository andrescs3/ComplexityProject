/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexityproject;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ComplexityProject {
    public static int[] GetRandomArray(int n,int k, boolean UseKLimits ){
        int[] array = new int[n];
        for(int i = 0; i<n; i++){

            double d = Math.random();
            d = (d *(k-1))+1;
            int value = (int)Math.floor(d);
            array[i] = value;
        }
        if(UseKLimits){
            array[0] = 1;
            array[1] = k;
        }

        return array;
    }


    public static int[] GetDescOrderArray(int n,int k, boolean UseKLimits ){
        int[] array = new int[n];
        for(int i = 0; i<n; i++){

            array[n-i-1] = i+1;
        }
        if(UseKLimits){
            array[0] = 1;
            array[1] = k;
        }

        return array;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws InterruptedException   {
        // TODO code application logic here
        int[] sizes = new int[]{
                10000,50000, 80000,100000,
                300000, 800000, 1000000,3000000,
                7000000,10000000,20000000,30000000};
        int k = 10;
		double promCount = 100.0;
		for(int i = 0; i<sizes.length;i++){
            int[] testArray = GetRandomArray(sizes[i],sizes[i], true);
            double promTime = 0.0;
			
            for(int j=0; j<promCount; j++) {
                //System.out.println(Arrays.toString(testArray));
                long tInit, tEnd;
                tInit = System.currentTimeMillis();
                CountingSort.sort(testArray);
                tEnd = System.currentTimeMillis();
                double time = (double) ((tEnd - tInit));
                
                promTime+=time;
            }
            promTime = promTime/promCount;

            System.out.println("n: " + sizes[i]+ "  tProm:" + promTime +"ms" );


        }
		
        sizes = new int[]{605870911};

        int m = 1;
        for(int i = 0; i<sizes.length;i++){
            int[] testArray = GetDescOrderArray(sizes[i],sizes[i], false);
            double promTime = 0.0;
			
            for(int j=0; j<promCount; j++) {
                //System.out.println(Arrays.toString(testArray));
                long tInit, tEnd;
                tInit = System.currentTimeMillis();
                ShellShort.sort(testArray);
                tEnd = System.currentTimeMillis();
                double time = (double) ((tEnd - tInit));
                //System.out.println("n: " + sizes[i]+ " - t:" + time +"ms" );
                promTime+=time;
            }
            promTime = promTime/promCount;

            //System.out.println(Arrays.toString(testArray));
            System.out.println("n: " + sizes[i]+ "  tProm:" + promTime +"ms" );


        }
    }

}
