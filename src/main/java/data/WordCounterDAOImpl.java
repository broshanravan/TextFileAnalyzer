/**
 * The main job of this cllass would to to access the
 * raw data within the text file and pass it to
 * other parts of the app for further analysis
 *
 * @author  Bruce Roshanravan
 * @version 1.0
 * @since   2020-01-16
 */
package data;

import analyssis.ContentAnalyser;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class WordCounterDAOImpl implements WordCounterDAO {

    final static Logger logger = Logger.getLogger(WordCounterDAOImpl.class);

    /**
     * To read the number of words
     * in the file within provided path name
     * @param fileNamePathIn
     * @return
     */
    public long getWordCounts(String fileNamePathIn){
        long wordCount = 0;

        Path textFilePath = Paths.get(fileNamePathIn);
        try {
            Stream<String> fileLines = Files.lines(textFilePath, Charset.defaultCharset());
            wordCount = fileLines.flatMap(line -> Arrays.stream(line.split(" "))).count();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return wordCount;
    }

    /**
     * To read and stream the contents
     * of text file being interrogated
     * @param fileNamePathIn
     */
    public void streamContents(String fileNamePathIn,ContentAnalyser contentAnalyser){
        Path textFilePath = Paths.get(fileNamePathIn);
        try (Stream<String> lines = Files.lines(textFilePath)){
            lines.forEach(line->   {
                Scanner check = new Scanner(line);
                while(check.hasNext()){
                    String nextWord = check.next();
                    contentAnalyser.addToCollection(nextWord.length());
                }
            });

        }catch (IOException ioe) {
            logger.debug(ioe.getStackTrace());
        }

    }

}
