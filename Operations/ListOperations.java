package Operations;

import List.List;

public class ListOperations {

    List<String> list;

    public ListOperations() {

        List<String> list1 = new List<String>();
        List<String> list2 = new List<String>();

        list1.add("1");
        list1.add("2");

        list2.add("2");
        list2.add("4");

        list = union(list1, list2);
        System.out.println(list);

        list = difference(list1, list2);
        System.out.println(list);

        System.out.println(belong(list1, list2));

    }

    public List<String> union(List<String> list1, List<String> list2) { // funciona

        List<String> union = new List<String>();

        for (String s : list1) {
            union.add(s);
        }

        for (String s : list2) {
            union.add(s);
        }

        return union;
    }

    public boolean belong(List<String> list1, List<String> list2) {

        for (String s : list1) {
            if (verify(s, list2)) {
                return true;
            }
        }
        return false;
    }

    private boolean verify(String arg, List<String> args) {

        for (String s : args) {
            if (s.equals(arg)) {
                return true;
            }
        }
        return false;
    }

    public List<String> difference(List<String> list1, List<String> list2) {

        List<String> difference = new List<String>();

        for (String s : list1) {
            if (!verify(s, list2)) {
                difference.add(s);
            }
        }

        for (String s : list2) {
            if (!verify(s, list1)) {
                difference.add(s);
            }
        }

        return difference;
    }

    public static void main(String[] args) {
        new ListOperations();
    }

}
