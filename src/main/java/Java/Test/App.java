package Java.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	readCSV test = new readCSV("e:\\deniro.csv");
//    	test.printByCSVName();
    	test.getTitleGivenYear("2015");
    	System.out.println(test.getMeanScore());
    	System.out.println(test.getMedianScore());
    	
 
    }
}
