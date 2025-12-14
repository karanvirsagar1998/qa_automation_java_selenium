public class largestSecond {
    // largest second
    public static void main(String[] args) {
        int[][] testCases = {
                { 10, 45, 2, 99, 23 }, { -10, -45, -2, -99, -23 }, { 5, 5, 3, 3, 1 }, { 100, 90, 80, 70 },
                { 1, 2, 3, 4, 5 }, { 10, 20 }, { 7, 7, 7, 7 }, { 42 }, { -1, -2, -3, -4 } };
        for (int[] arr : testCases) {
            int l = Integer.MIN_VALUE;
            int sl = Integer.MIN_VALUE;
            int i = 0;
            while (i < arr.length) {
                if (arr[i] > l) {
                    sl = l;
                    l = arr[i];
                } else if (arr[i] < l && arr[i] > sl) {
                    sl = arr[i];
                }
                i++;
            }
            if (sl != Integer.MIN_VALUE) {
                System.out.println(sl);
            } else {
                System.out.println("No second largest exists in array");
            }

        }
    }
}
