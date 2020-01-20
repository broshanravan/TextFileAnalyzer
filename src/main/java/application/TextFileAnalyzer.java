package application;

    /**
     * This is the class that interact
     * with the user to get the file details and
     * output the results on the screen
     *
     * @author  Bruce Roshanravan
     * @version 1.0
     * @since   2020-01-16
     */

import analyssis.ContentAnalyser;
import analyssis.ContentAnalyserImpl;
import data.WordCounterDAO;
import data.WordCounterDAOImpl;

import java.io.InputStreamReader;
import java.util.Scanner;


 public class TextFileAnalyzer{

        public static void main(String[] args){
            ContentAnalyser contentAnalyser = new ContentAnalyserImpl();
            String namePath = getFileNamePath();
            WordCounterDAO wordCounterDAOImpl = new WordCounterDAOImpl();
            long wordCount = wordCounterDAOImpl.getWordCounts(namePath);
            System.out.println("The number of words within your file is: " + wordCount);
            wordCounterDAOImpl.streamContents(namePath,contentAnalyser);
            contentAnalyser.disayFileAnalsisResults();

        }


        public static String getFileNamePath(){
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            System.out.println("Please enter The file full name Path;");
            String namePath = scanner.next();

            return namePath;
        }
    }


