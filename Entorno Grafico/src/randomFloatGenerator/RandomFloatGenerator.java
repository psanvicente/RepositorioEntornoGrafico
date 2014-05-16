package randomFloatGenerator;

import java.util.ArrayList;
import java.util.Random;


public class RandomFloatGenerator {

    
    static String messageRange="Max must be higher than Min";
  
    static String messageNoData="Please, check data to generate numbers";
   
    static Random random=new Random();

    
    private static float generateRandomNumber(float min, float max,Random random)
    {
        return random.nextFloat()*(max-min)+min;
    }

  
    public static boolean checkRange(float min, float max)
    {
        if(max>min)
            return true;
        return false;
    }
    
    private static String formatRandomNumber(float randomNumber, int precision)
    {
        return String.format("%."+precision+"f", randomNumber);
    }
   
 
    public static String getGroupOfNumbers(int amount, float min, float max, int precision)
    {
    	ArrayList<String> al = new ArrayList<String>(amount);
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<amount; i++)
    		al.add(formatRandomNumber(generateRandomNumber(min, max, random),precision));
    		
		for(String string: al)
		{
			sb.append(string+"\n");
		}
    	return sb.toString();
    }
    
}