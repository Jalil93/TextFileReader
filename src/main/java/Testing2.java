import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Testing2 {

    public static void testOne() throws IOException {

        Set<Integer> testset = new HashSet<Integer>();
        testset.add(45);
        testset.add(435);
        testset.add(-456);
        testset.add(5900);
        testset.remove(5900);

        for (int i : testset) {
            System.out.println(testset);
        }

//        System.out.println("Hello World!!!");
//       TextToDataStructure.processFile("src/main/java/list.txt");
    }

    public static void main(String[] args) throws IOException {
        testOne();
    }
}
