/**
 * Declaring all the methods used in
 * WordCounterDAOImpl
 *
 * @author  Bruce Roshanravan
 * @version 1.0
 * @since   2020-01-16
*/
package data;

import analyssis.ContentAnalyser;

public interface WordCounterDAO {

    public long getWordCounts(String fileNamePathIn);

    public void streamContents(String fileNamePath, ContentAnalyser contentAnalyser);
}
