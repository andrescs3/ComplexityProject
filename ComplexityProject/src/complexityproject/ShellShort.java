package complexityproject;

public class ShellShort {
    public static void sort(int[] Items) {
        int n = Items.length;                                  // 1

        for (int gap = n / 2; gap > 0; gap /= 2) {             // 1 + [ log2(n) + 1 ] + (log2(n))
            for (int i = gap; i < n; i++) {                    // 1 + ({[n * (log2(n) - 1) ] + 1 } + 1) + {[n * (log2(n) - 1) ] + 1 }
                int key = Items[i];                            // 1
                int j = i;                                     // 1
                while (j >= gap && Items[j - gap] > key) {     // 4 +  log2(n) * n/2
                    Items[j] = Items[j - gap];                 // 2
                    j -= gap;                                  // 2
                }
                Items[j] = key;                                // 1
            }
        }
    }
}
