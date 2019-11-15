package complexityproject;

public class CountingSort {

    /** Counting Sort functionality
     * @param Items **/
    public static void sort(int[] Items) {
        int n = Items.length;                       // 1
        if (n == 0)                                 // 1
            return;                                 // 1
        
        int max = Items[0];                         // 1
        int min = Items[0];                         // 1
        for (int i = 1; i < n; i++) {               // 1 + n + (n - 1)
            if (Items[i] > max)                     // (n-1)
                max = Items[i];                     // (n-1)
            if (Items[i] < min)                     // (n-1)
                min = Items[i];                     // (n-1)
        }
        int k = max - min + 1;                      // 3

        int[] count = new int[k];                   // 1
        
        for (int i = 0; i < n; i++)                 // 1 + (n+1)
            count[Items[i] - min]++;                // 2n
        
        for (int i = 1; i < k; i++)                 // 2k
            count[i] += count[i - 1];               // 3(k-1)
        
        int j = 0;                                  // 1
        for (int i = 0; i < k; i++){                // 1 + (k+1) + k
            while (j < count[i]){                   // (n + k )
                Items[j++] = i + min;               // 3(n)
            }
        }
    }
}
