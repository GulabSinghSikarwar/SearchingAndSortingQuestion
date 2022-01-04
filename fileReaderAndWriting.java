import java.io.*;
import java.util.*;

public class fileReaderAndWriting {
    
    public static void main(String[] args)throws IOException {
        
     /* String inputString="""
      3
      10
      4 1 2 3 4
      8
      1 1
      8
      8 1 1 1 1 1 1 1 1
      """;
        System.out.println(inputString);

      try{
        FileWriter inputFile= new FileWriter("input.txt");
        inputFile.write(inputString.trim());
        inputFile.close();
        System.out.println();
      }
      catch(IOException e)
      {
          System.out.println("error eccured ");
          e.printStackTrace();
      }*/

      try{
          
    File inputFile=new File("input.txt");

    Scanner fileReader=new Scanner(inputFile);
fileReader.nextLine();

    while(fileReader.hasNext())

    {
        String order=fileReader.nextLine();
        String CookAndRating=fileReader.nextLine();
        System.out.println("oder : "+order);
        System.out.println("CookAndRating : "+CookAndRating);



    }
    fileReader.close();
      }
      catch(IOException e){
          System.out.println("Error Occured ");
          e.printStackTrace();
      }





    }
}
