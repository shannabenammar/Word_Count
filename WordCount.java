package assignments;

import java.util.*;
import java.io.*;

/*
 * Name: Shanna Benammar 
 * 
 * Objective: To print all the unique words found inside the script of 
 * the Bee movie. 
 * 
 * The Bee movie is an Adventure/Comedy film released in 
 * 2007. The movie delves into the common misconceptions of life 
 * and the meaning of self. Told from the point of view of a self-doubtful
 * bee suffering from both paranoia and depression. He find himself bonding
 * with a polar opposite version of himself making for a perfect story of
 * the wonderful journey to self discovery while also being a great
 * Children's film. 
 * 
 */

public class WordCount {
	
	/*
	 * Method: main
	 * 
	 * Objective:
	 * 1.Instantiates objects for the input and output files
	 * 2.Throws a FileNotFoundException in a case where program cannot find file
	 * 3.has a while loop to read input in. 
	 * 4.Inside the while loop is an if else statement.
	 * 5. If- checks to see that the word doesnt already exist in the hashmap.
	 * If it doesnt it places the word inside the hashmap with the starting
	 * value of 1. 
	 * else- since the value was already in the hashmap it is sent to the else statement
	 * where the word is put in the hasmap followed by the value of the word count
	 * plus one
	 * For loop- print out all the value of the hasmap
	 * Input:
	 * N/A
	 * 
	 * Output:
	 * Print out the total number of words followed by each word 
	 * and the number of times that word appeared in the script. 
	 * 
	 */
		
    public static void main( String[] args ) throws FileNotFoundException  {

        // open the file
        Scanner console = new Scanner(System.in);
        File testFile = new File("Script.txt");
        Scanner input = new Scanner(testFile);

        // count occurrences
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            String clean = next.replaceAll("\\p{Punct}", "").toLowerCase();

            if (!wordCounts.containsKey(clean)) {
                wordCounts.put(clean, 1);
            } else {
                wordCounts.put(clean, wordCounts.get(clean) + 1);
            }
        }


        System.out.println("Total words = " + wordCounts.size());

        HashMap<String, Integer> sortedMapAsc = WordCount.sortByValue(wordCounts);

        // Report frequencies
        for (String word : sortedMapAsc.keySet()) {
            int count = sortedMapAsc.get(word);
            
            System.out.println(count + ": " + word);
            
        }
    }
    /*
     * Method: sortByValue
     * 
     * Objective:
     * 1.Creates a list of the elements in the hashmap 
     * 2.Sorts the list from largest to smallest
     * 3.Returns the sorted list into a hashmap
     * Input:
     * Hashmap of strings and integers
     * Output:
     * Returns the sorted hashmap to the main method
     * 
     */
    	
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

        
        java.util.List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

      
        Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
          public int compare(Map.Entry<String, Integer> o1,
                             Map.Entry<String, Integer> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
          }
        });

        
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
          temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
      }

}
