/**
 * This class will run all the unit trsts
 * on application unctionality
 * and its performance
 *
 * @author  Bruce Roshanravan
 * @version 1.0
 * @since   2020-01-16
 */
package analysis;

import org.junit.BeforeClass;
import org.junit.Test;
import analyssis.ContentAnalyser;
import analyssis.ContentAnalyserImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ContentAnalyserTst {

    static ContentAnalyser contentAnalyser = new ContentAnalyserImpl();
    static Map<Integer, Integer> referenceMap = new HashMap();


    @BeforeClass
    public static void setUpBaseClass() {
        referenceMap.put(1, 1);
        referenceMap.put(2, 23);
        referenceMap.put(3, 23);
        referenceMap.put(4, 13);
        referenceMap.put(5, 12);
        referenceMap.put(6, 15);
        referenceMap.put(7, 13);
        referenceMap.put(8, 9);
        referenceMap.put(9, 8);
        referenceMap.put(10, 7);
        referenceMap.put(11, 3);
        referenceMap.put(12, 2);
        contentAnalyser.setWordCountMap(referenceMap);
    }


    @Test
    public void testAddToCollection() {
        contentAnalyser.addToCollection(10);
        int num = referenceMap.get(10);
        assert (num == 8);
    }

    @Test
    public void testGetAerageWordLength() {
        double averageWordLrnght = contentAnalyser.getAerageWordLength(referenceMap);
        assert (averageWordLrnght == 25.49);
    }

    @Test
    public void testGetMostFrequentLegths() {
        TreeMap<Integer, Integer> mostFrequrntLenghtsMap = contentAnalyser.getMostFrequentLegths(referenceMap);
        assert (mostFrequrntLenghtsMap.size() == 2);
        assert (mostFrequrntLenghtsMap.firstEntry().getKey() == 2);
        assert (mostFrequrntLenghtsMap.firstEntry().getValue() == 23);
    }


    @Test
    public void testGetMaxWordSize() {
        int maxWordSize = contentAnalyser.getMaxWordSize(referenceMap);
        assert(maxWordSize == 12);
    }


    @Test
    public void testGetMinWordSize() {
        int minWordSize = contentAnalyser.getMinWordSize(referenceMap);
        assert(minWordSize == 1);
    }






}
