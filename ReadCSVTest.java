package com.argive.qa.excel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sumitmadan
 * Date: 2019-05-16
 * Time: 4:28 PM
 * Description: Sample test to read a csv file into a 2D array
 */
public class ReadCSVTest {

  // Constants ---------------------------------------------------------------------------------------------- Constants


  // Instance Variables ---------------------------------------------------------------------------- Instance Variables


  // Constructors ---------------------------------------------------------------------------------------- Constructors


  // Public Methods ------------------------------------------------------------------------------------ Public Methods

  @Test
  public void testReadCommaSeparatedContent() throws Exception {

      String csvFile = "/Users/sumitmadan/Downloads/test1.csv";
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
      boolean headerRowExists = true;

      int numCols = 11;
      int numRows = 11;
      String[][] csvData = new String[numRows][numCols];    // To extract the data to be stored

      try {

          br = new BufferedReader(new FileReader(csvFile));
          int count = 0;

          if(headerRowExists)   {
              if( (line = br.readLine()) != null )  {
                  String[] header = line.split(cvsSplitBy);
              }
          }

          while ((line = br.readLine()) != null) {

              // use comma as separator
              csvData[count] = line.split(cvsSplitBy);
              count++;


          }
          for (int i = 0; i < numRows-1; i++)   {
              for (int j = 0; j < numCols; j++) {
                  System.out.println(csvData[i][j]);
              }
              System.out.println("\n");
          }

      }
      catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      catch (IOException e) {
          e.printStackTrace();
      }
      finally {

          if (br != null) {
              try {
                  br.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }
}

  // Protected Methods ------------------------------------------------------------------------------ Protected Methods


  // Private Methods ---------------------------------------------------------------------------------- Private Methods


  // Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

