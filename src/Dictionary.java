
  
import java.io.*;
import java.util.*;


public class Dictionary
{
	public static void main(String[]  args) 
	{
        if(args.length < 1)
		{
            System.err.println("Please provide the relative path to the dictionary file");
            System.exit(1);
        }
		try
		{
			if (!doesFileExist(args[0]))
			{
				throw new FileNotFoundException("File does not exist.");
			}
			
			else 
			{
				File file = new File (args[0]);
				 if (file.length() == 0)
				{
					System.err.println("Empty file.");
					System.exit(1);
				}
				
				else
				{
					System.out.println("File exists ");
					System.out.println();
					printDictionary(file);
				}			
					
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}			
    }
    
	public static void printDictionary(File f) 
	{
		try
		{
			Scanner scanner = new Scanner(f);
			String line;
			int i =1;

			while (scanner.hasNextLine())
			{
				line = scanner.nextLine();
        		String[] word = line.split("-");
       	 		String[] meaning = word[1].split(",");
        		System.out.println("Word" + i + ": " + word[0].trim());
				i++;
		
        		for(int j=0; j < meaning.length; j++)
				{
            		System.out.println("Meaning" + (j + 1) + ": " + meaning[j].trim());
        		}
		
				System.out.println();
			}
			scanner.close();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
    public static boolean doesFileExist(String path){

        File f = new File(path);
        if(f.exists() && !f.isDirectory()){
            return true;
        }
        return false;
    }
	
	
}		
			
		