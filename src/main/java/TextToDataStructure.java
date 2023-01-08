import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextToDataStructure {

    public static void processFile(String filePath) throws IOException {
//
//        System.out.println("Today, we will learn about Data Structures");
        String textRead = readFile(filePath);
        System.out.println(generateList(textRead));
    }

    public static String readFile(String filePath) throws IOException {
        Scanner in = new Scanner(
                new FileReader(filePath)
        );
        StringBuilder sb = new StringBuilder();


//        Scanner scannerobject = new Scanner(new FileReader(""));
//        StringBuilder sbobject = new StringBuilder();
//        while(scannerobject.hasNext()){
//            sbobject.append(scannerobject.hasNext());
//        }

        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }

    public static LinkedList<String> generateList(String text) {
        String[] splitArray = text.toLowerCase().split(" ");
        LinkedList<String> finalList = new LinkedList<String>(Arrays.asList(splitArray));
        try{
            System.out.println("first item is "+ finalList.get(0));
            System.out.println("second item is "+ finalList.get(1));
        } catch(Exception e) {
            System.out.println("Error in returning multiple elements");
        }
//        System.out.println("The list is as follows: "+finalList+"\n");
        return finalList;
    }
}
