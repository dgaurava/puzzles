import java.util.ArrayList;

public class QueueTallerSolution {
    public static ArrayList<Integer> findOrder(ArrayList<Integer> height, ArrayList<Integer> infront) {

        ArrayList<Integer> result = new ArrayList(height.size());
        for(int k =0;k<height.size();k++){
            result.add(height.get(k));
        }
        // Write your code here.
        int idx = 0;
        for(int i=0;i<height.size();i++){
            int h = height.get(i);
            int f = infront.get(i);
            int bigger = 0;
            int li = 0;
            for(int j=0;j<height.size() ;j++){

                if(h < height.get(j)){
                    bigger++;
                }
                if((h > height.get(j) && f >= infront.get(j) && j>i)
                        ||
                        (h < height.get(j) && f > infront.get(j) && j>i && bigger <= f)
                        ||
                        (h < height.get(j) && f > infront.get(j) && j<i && bigger > f)) {

                    li = j;

                    int temp = height.get(i);
                    height.set(i, height.get(j));
                    height.set(j, temp);
                }

            }

        }
        return height;
    }
}
