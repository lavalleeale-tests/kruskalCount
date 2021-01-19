import java.util.ArrayList;

public class Main {
    public static void main(String[] Args) {
        String[] clock = new String[]{"Twelve", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven"};
        int[] clockLen = new int[clock.length];
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> toRemove = new ArrayList<>();
        int lastNum;
        int curNum;
        ArrayList<Integer> curArrList;
        ArrayList<Integer> checkArrList;
        ArrayList<ArrayList<Integer>> newPaths;

        for (int i = 0; i < clock.length; i++) {
            clockLen[i] = clock[i].length();
            paths.add(new ArrayList<>());
            paths.get(i).add(clockLen[i]);
        }
        while (paths.size()!=1) {
            for (ArrayList<Integer> path : paths) {
                lastNum = path.get(path.size() - 1);

                curNum = lastNum + clockLen[lastNum];
                path.add(curNum % 12);
            }
            for (int i = 0; i < paths.size(); i++) {
                curArrList = paths.get(i);
                if (toRemove.contains(i)) {
                    continue;
                }
                for (int j = 0; j < paths.size(); j++) {
                    if (toRemove.contains(j)) {
                        continue;
                    }
                    checkArrList = paths.get(j);
                    if (i==j) {
                        continue;
                    }
                    if (curArrList.get(checkArrList.size() - 1).equals(checkArrList.get(checkArrList.size() - 1))) {
                        toRemove.add(j);
                    }
                }
            }
            newPaths = (ArrayList<ArrayList<Integer>>) paths.clone();
            for (Integer integer : toRemove) {
                newPaths.remove(paths.get(integer));
            }
            toRemove = new ArrayList<>();
            paths=newPaths;
        }
        System.out.printf("Final number: %s\nGoes: %s\n", clock[paths.get(0).get(paths.get(0).size()-1)], paths.get(0).size());
    }
}
