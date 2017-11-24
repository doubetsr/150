//package Streams;
///*
//Good links to understand Java 8 Streams:
//    https://www.tutorialspoint.com/java8/java8_streams.htm
//    http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
//    https://zeroturnaround.com/rebellabs/java-8-streams-cheat-sheet/
// */
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Created by Josh on 3/10/2017.
// */
//public class Application {
//    public static void main(String[] args) {
//        //Create our myCDs list and fill it with users for streaming
//        ArrayList<CD> myCDs = new ArrayList();
//        myCDs.add(new CD("Tim cd", "Tim Johnson", 0, 0,1));
//        myCDs.add(new CD("Joe cd", "Joe Darnelle", 1, 2,2));
//        myCDs.add(new CD("John cd", "John Daniels", 2, 4,3));
//        myCDs.add(new CD("Roger cd", "Roger Smith", 3, 2,4));
//        myCDs.add(new CD("Richard v John", "Carlson Brothers", 4, 1,5));
//        myCDs.add(new CD("Math Rules", "Lambda", 5, 1,6));
//        myCDs.add(new CD("Ian Lim", "Bronson", 6, 3,7));
//        myCDs.add(new CD("Romeo", "Taylor Swift", 7, 4,8));
//        myCDs.add(new CD("Stephanie", "Roberts", 8, 3,9));
//        myCDs.add(new CD("antother CD", "Williams", 9, 2,10));
//
//        System.out.println("Print out each CD information");
//        System.out.println("Pre Java 8 way using a foreach loop");
//        for(CD e : myCDs) {
//            System.out.println(e.toString());
//        }
//        System.out.println("\nJava 8 way using streams and lambdas");
//        myCDs.stream().forEach(e -> System.out.println(e.toString()));
//
//        System.out.println("\nLimit to 5 myCDs");
//        System.out.println("Pre Java 8 way using for loop");
//        for(int i = 0; i<5; i++) {
//            System.out.println(myCDs.get(i).toString());
//        }
//
//        System.out.println("\nJava 8 way using streams and lambda");
//        myCDs.stream().limit(5).forEach(e -> System.out.println(e.toString()));
//
//        System.out.println("\nFilter myCDs based on number of tracks value of 2. The .collect() allows us to " +
//                "collect the results of a stream back into a list using the Collectors functionality");
//        System.out.println("Pre Java 8");
//        List<CD> filtermyCDs = new ArrayList<>();
//        for(int i = 0; i < myCDs.size(); i++) {
//            if(myCDs.get(i).getTracks() == 2) {
//                filtermyCDs.add(myCDs.get(i));
//            }
//        }
//        for(int i = 0; i < filtermyCDs.size(); i++) {
//            System.out.println(filtermyCDs.get(i).toString());
//        }
//        System.out.println("\nJava 8");
//        List<CD> filteredmyCDs = new ArrayList<>();
//        filteredmyCDs = myCDs.stream().filter(e -> e.getTracks() == 2).collect(Collectors.toList());
//        filteredmyCDs.stream().forEach(e -> System.out.println(e.toString()));
//
//        System.out.println("\nDo an 'any match' against a condition on our myCDs list");
//        System.out.println("Pre Java 8");
//        boolean anyMatch = false;
//        for(int i = 0; i < myCDs.size(); i++) {
//            if(myCDs.get(i).getID() == 1) {
//                anyMatch = true;
//                break;
//            }
//        }
//        System.out.println(anyMatch);
//
//        System.out.println("\nJava 8 way using .anyMatch()");
//        System.out.println(myCDs.stream().anyMatch(e -> e.getID() == 1));
//
//        System.out.println("\nDo an 'all match' against a condition on our myCDs list");
//        System.out.println("Pre Java 8");
//        boolean allMatch = false;
//        for(int i = 0; i < myCDs.size(); i++) {
//            if(myCDs.get(i).getID() != 1) {
//                allMatch = false;
//                break;
//            }
//        }
//        System.out.println(allMatch);
//
//        System.out.println("\nJava 8 way using .allMatch()");
//        System.out.println(myCDs.stream().allMatch(e -> e.getID() == 1));
//
//        System.out.println("\nDo an 'none match' against a condition on our myCDs list");
//        System.out.println("Pre Java 8");
//        boolean noneMatch = false;
//        for(int i = 0; i < myCDs.size(); i++) {
//            if(myCDs.get(i).getID() == 1) {
//                noneMatch = false;
//                break;
//            }
//        }
//        System.out.println(noneMatch);
//
//        System.out.println("\nJava 8 way using .noneMatch()");
//        System.out.println(myCDs.stream().noneMatch(e -> e.getID() == 1));
//
//        System.out.println("\nFilter the myCDs list and save the myCDs whose artist name contains an 'o' as a list" +
//        "\nThen filter the result of the first filter whose tracks is 2 and store this as a list" +
//        "\nFinally, print out the resulting final list");
//        System.out.println("Pre Java 8 method - less efficient as you have to create multiple lists and loops");
//        List<CD> filter1 = new ArrayList<>();
//        List<CD> filter2 = new ArrayList<>();
//        for(int i = 0; i < myCDs.size(); i++) {
//            if(myCDs.get(i).getArtist().contains("o")) {
//                filter1.add(myCDs.get(i));
//            }
//        }
//        for(int i = 0; i < filter1.size(); i++) {
//            if(filter1.get(i).getTracks() == 2) {
//                filter2.add(filter1.get(i));
//            }
//        }
//        for(int i = 0; i < filter2.size(); i++) {
//            System.out.println(filter2.get(i).toString());
//        }
//        System.out.println("\nJava 8 method - much more efficient and manageable");
//        System.out.println("You can stream back to back, you just must remember to collect appropriately the result of each stream prior" +
//        "\nto starting the next one. The values in the first stream will be passed into the second stream." +
//        "\nThe second stream will then filter the data further and pass it onto the third stream which will" +
//        "\nprint each remaining item.");
//        myCDs.stream().filter(e -> e.getArtist().contains("o")).collect(Collectors.toList())
//                .stream().filter(e -> e.getTracks() == 2).collect(Collectors.toList())
//                .stream().forEach(e -> System.out.println(e.toString()));
//    }
//}