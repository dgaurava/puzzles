public class StoneSolution {
    public static void main(String[] args) {
        int[][] stones = new int[5][2];
        stones[0] = new int[]{0, 0};
        stones[1] = new int[]{0, 2};
        stones[2] = new int[]{1, 1};
        stones[3] = new int[]{2, 0};
        stones[4] = new int[]{2, 2};

        int[][] stones2 = new int[3][2];
        stones2[0] = new int[]{0, 1};
        stones2[1] = new int[]{1, 0};
        stones2[2] = new int[]{1, 1};

        int[][] stones3 = new int[6][2];
        stones3[0] = new int[]{0, 1};
        stones3[1] = new int[]{1, 2};
        stones3[2] = new int[]{1, 3};
        stones3[3] = new int[]{3, 3};
        stones3[4] = new int[]{2, 3};
        stones3[4] = new int[]{0, 2};


        System.out.println("stones.length: " + stones.length);
        int x = removeStones(stones);
        // int y = removeStones2(stones3);
        System.out.println(x);
        //System.out.println(y);
    }

    public static int removeStones(int[][] stones) {

        int stn = 0;
        int k = 0;

        while (k < stones.length) {
            /*if(removed[k]>0){
                k++;
                continue;
            }*/
            int r = stones[k][0];
            int c = stones[k][1];
            System.out.println("------- row, column: " + r + "," + c + " at " + k);
            int l = 0;
            int[] removed = new int[stones.length];
            int stn2 = 0;
            int m = l + 1;
            while (l < stones.length) {
                while (l != k && m < stones.length) {

                    if (l != m && (stones[m][0] == r || stones[m][1] == c)) {
                        System.out.println("Marked for removal: " + m);
                        removed[k] = 1;
                        stn2 += 1;

                        //l=0;
                        //m=l;
                    }
                    m++;
                    //l++;
                }
                //m++;

            }
            if (stn < stn2) {
                stn = stn2;
            }
            k++;

            /*for (int i = 0; i < removed.length; i++) {
                stn2 += removed[i];
            }*/

        }
        return stn;
    }

    public static int removeStones2(int[][] stones) {
        int[] removed = new int[stones.length];
        int stn = 0;
        int k = stones.length - 1;
        while (k > 0) {
            /*if(removed[k]>0){
                k++;
                continue;
            }*/
            int r = stones[k][0];
            int c = stones[k][1];
            System.out.println("row, column: " + r + "," + c + " at " + k);
            int l = k - 1;
            while (l >= 0) {

                if (stones[l][0] == r || stones[l][1] == c) {
                    System.out.println("Marked for removal: " + l);
                    removed[l] = 1;
                }
                l--;
            }
            k--;
        }
        for (int i = 0; i < removed.length; i++) {
            stn += removed[i];
        }
        return stn;
    }
}
