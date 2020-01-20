
/** The main job of this class would to process
 * the data retrieved from text file and
 * about the details of its content
 *
 * @author  Bruce Roshanravan
 * @version 1.0
 * @since   2020-01-16
*/
package analyssis;


import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public interface ContentAnalyser {
    public void addToCollection(int index);

    public void disayFileAnalsisResults();

    public Map<Integer, Integer> getWordCountMap();

    public void setWordCountMap(Map<Integer, Integer> wordCountMapIn);


    default double getAerageWordLength(Map<Integer, Integer> wordCountMap){
         DecimalFormat deimalFormatter = new DecimalFormat("#.##");
        double averageWordLength = 0;
        double totalLenghtCombination = 0 ;
        double totalLenghtToNumber = 0;

        if (!wordCountMap.isEmpty()){

            for (Map.Entry<Integer, Integer> entry : wordCountMap.entrySet()) {
                double lenght = entry.getKey();
                double count =  entry.getValue();
                totalLenghtCombination += count * count;
                totalLenghtToNumber += lenght ;
            }

            averageWordLength = totalLenghtCombination/totalLenghtToNumber;
            averageWordLength = Double.parseDouble(deimalFormatter.format(averageWordLength));
            System.out.println("Average word length = " + averageWordLength);
        }

        return averageWordLength;
    }

    default void showAllCounts(Map<Integer, Integer> wordCountMap){

        wordCountMap.forEach((length,count)->{
            System.out.println("The numbers words of length " + length  + " is: " + count);
        });
    }

    default int getMaxWordSize(Map<Integer, Integer> wordCountMap){
        int maxWordSize = 0;
        int maxSizeCount = 0;
        for (Map.Entry<Integer, Integer> entry : wordCountMap.entrySet()) {
            if (maxWordSize == 0 || entry.getKey()
                    .compareTo(maxWordSize) > 0) {
                maxWordSize = entry.getKey();
                maxSizeCount = entry.getValue();
            }
        }
        System.out.println("Maximum word length is: " + maxWordSize +
                " and the count is: " + maxSizeCount);

        return maxWordSize;
    }

    default TreeMap<Integer, Integer> getMostFrequentLegths(Map<Integer, Integer> wordCountMap){

        int mostFrequentLength = 0;

        TreeMap<Integer, Integer> mostFrequntLenghtMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : wordCountMap.entrySet()) {
            if (mostFrequentLength == 0 || entry.getValue()
                    .compareTo(mostFrequentLength) > 0) {
                mostFrequentLength = entry.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() ==mostFrequentLength) {
                mostFrequntLenghtMap.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.print("The most frequently occurring word length is " + mostFrequntLenghtMap.firstEntry().getValue());
        Set<Integer> keysSet = mostFrequntLenghtMap.keySet();
        System.out.print(" for word lengths of ");

        int i =0;
        for(int lenght:keysSet){
            System.out.print(lenght);
            if(i < keysSet.size() - 1){
                System.out.print(" & ");
            }
            i++;
        }
        System.out.println(".");
        return mostFrequntLenghtMap;
    }

    default int getMinWordSize(Map<Integer, Integer> wordCountMap){
        int minWordSize = 0;
        int minSizeCount = 0;
        for (Map.Entry<Integer, Integer> entry : wordCountMap.entrySet()) {
            if (minWordSize == 0 || entry.getKey()
                    .compareTo(minWordSize) < 0) {
                minWordSize = entry.getKey();
                minSizeCount = entry.getValue();
            }
        }
        System.out.println("Minimum word length is: " + minWordSize +
                " and the count is: " + minSizeCount);


        return minWordSize;
    }



}
