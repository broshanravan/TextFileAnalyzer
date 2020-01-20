/**
 * This class will interigaate file contents
 * passed into it via the DAO and collect
 * the details necessary to be revealed to
 * the user
 *
 * @author  Bruce Roshanravan
 * @version 1.0
 * @since   2020-01-16
 */

package analyssis;

import java.util.HashMap;
import java.util.Map;

public class ContentAnalyserImpl implements ContentAnalyser{

    /**
     * Accessor
     * @return
     */
    public Map<Integer, Integer> getWordCountMap() {
        return wordCountMap;
    }

    /**
     * Mutator
     * @param wordCountMapIn
     */
    public void setWordCountMap(Map<Integer, Integer> wordCountMapIn){
        wordCountMap = wordCountMapIn;
    }

    Map<Integer, Integer> wordCountMap = new HashMap<Integer, Integer>();

    /**
     * As getting the data from the Stream
     * adds the data into a map by updating existing size counts
     * or inserting count for sizes that are not
     * captured yet
     * @param index
     */
    public void addToCollection(int index){
       if (wordCountMap.containsKey(index)){
           int count = wordCountMap.get(index) + 1;
           wordCountMap.put(index, count);
       }else {
           wordCountMap.put(index, 1);
       }
    }

    /**
     * Displaays the final results to the
     * screen for the user to see
     */
    public void disayFileAnalsisResults(){
        System.out.println(wordCountMap);
        getAerageWordLength(wordCountMap);
        getMaxWordSize(wordCountMap);
        getMinWordSize(wordCountMap);
        showAllCounts(wordCountMap);
        getMostFrequentLegths(wordCountMap);
    }



}
