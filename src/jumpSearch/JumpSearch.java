package jumpSearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JumpSearch {

    private static int jumpSearch(List<Integer> list, Integer element) {
        int listSize = list.size();
        int jumpBlockSize = (int) Math.floor(Math.sqrt(listSize));
        int startLoc = -1;
        int endLoc = -1;
        System.out.println(list);
        System.out.println("jump size " + jumpBlockSize);
        for (int i=0; i < listSize; i+=jumpBlockSize) {
            System.out.println("index " + i);
            if (list.get(i).equals(element)) {
                return i;
            } else if (element < list.get(i)) {
                startLoc = Math.max(i - jumpBlockSize + 1, 0);
                endLoc = Math.max(i - 1, 1);
                break;
            }
        }
        if (startLoc == -1 && endLoc == -1) {
            return -1;
        }
        System.out.println(" start and end " + startLoc + " " + endLoc);
        while (startLoc <= endLoc) {
            if (list.get(startLoc).equals(element)) {
                return startLoc;
            }
            startLoc++;
        }
        return -1;
    }

    private static int jumpSearch2(List<Integer> list, Integer element) {
        int listSize = list.size();
        int jumpBlockSize = (int) Math.floor(Math.sqrt(listSize));
        int startLoc = -1;
        int endLoc = -1;
        System.out.println(list);
        System.out.println("jump size " + jumpBlockSize);
        System.out.println("list size " + listSize);
        int currentLoc = 0, previousLoc = 0;
        if (element < list.get(0)) {
            return -1;
        }
        while (element > list.get(currentLoc)) {
            System.out.println("cur " + currentLoc + " prev " + previousLoc);
            previousLoc = currentLoc;
            currentLoc+=jumpBlockSize;
            if (currentLoc > listSize && list.get(listSize - 1) < element) {
                return -1;
            }
        }
        currentLoc = Math.min(currentLoc, listSize - 1);
        if (list.get(currentLoc).equals(element)) {
            return currentLoc;
        }

        System.out.println(" start and end " + previousLoc + " " + currentLoc);
        int i = previousLoc;
        while (i < currentLoc) {
            if (list.get(i).equals(element)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Integer> list = Arrays.asList(3, 4, 6, 7, 9, 11, 1, 0, 23, -43);
        //List<Integer> list = Arrays.asList(3, 4, 6);
        list.sort(Comparator.naturalOrder());

        int location = jumpSearch2(list, 23);
        if (location != -1) {
            System.out.println("found elem at location " + location + " " + list.get(location));
        }
    }
}
