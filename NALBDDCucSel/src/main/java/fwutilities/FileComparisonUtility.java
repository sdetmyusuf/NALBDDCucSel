package fwutilities;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class FileComparisonUtility {
	
	  public static void main( String[] args ) throws IOException
	  {

	    ArrayList< String > objFirstColArrayList = new ArrayList< String >();
	    ArrayList< String > objSecondColArrayList = new ArrayList< String >();
	    HashSet< String > set1 = new HashSet< String >(), set2 = new HashSet< String >();
	    BufferedReader br = null;

	    objFirstColArrayList.addAll( readTextFile( "C:\\Users\\Mohd Yusuf\\OneDrive\\Desktop\\Work-Notes\\test.txt", 0 ));
	    objSecondColArrayList.addAll( readTextFile( "C:\\Users\\Mohd Yusuf\\OneDrive\\Desktop\\Work-Notes\\master.txt", 0 ));

	    File file1 = new File( "C:\\Users\\Mohd Yusuf\\OneDrive\\Desktop\\Work-Notes\\15.txt" );
	    // if file doesnt exists, then create it
	    if ( !file1.exists() )
	    {
	      file1.createNewFile();
	    }
	    FileWriter fw = new FileWriter( file1.getAbsoluteFile() );
	    BufferedWriter bw = new BufferedWriter( fw );

	    for ( int i = 0; i < objFirstColArrayList.size(); i++ )
	    {
	      try
	      {

	       if ( objSecondColArrayList.contains( objFirstColArrayList.get( i ) ) )
	        {
	          //    / bw.write("Match Value>>>>>"+objFirstColArrayList.get(i)+">>>>>Attribute Value>>>>>"+objSecondColArrayList.indexOf(objFirstColArrayList.get(i))+"\n");
	          bw.write( "Match Value>>>>>" + objFirstColArrayList.get( i ) + "\n" );
	        }
	        else
	        {
	          bw.write( "\n Not matched>>>" + objFirstColArrayList.get( i ) +">>>>>Attribute Value>>>>>" + objSecondColArrayList.indexOf( objFirstColArrayList.get( i ) ) + "\n" );
	        
	        }
	        /* for(int in=0;in<objSecondColArrayList.size();in++){
	         if(objFirstColArrayList.get(i).equals(objSecondColArrayList.get(in))){
	          
	          System.out.println("Match Value"+objFirstColArrayList.get(i)+">>>>>Attribute Value"+objSecondColArrayList.get(in)+"\n");
	         // System.out.println("\n");
	        */

	        //System.out.println("Done");

	      }
	      catch ( IOException e )
	      {
	        e.printStackTrace();
	      }
	    }
	    /* }
	     
	     
	     //System.out.println("ListFirstValue:"+objFirstColArrayList.get(i));
	    }*/
	    bw.close();

	    /*try {

	     String sCurrentLine;

	     br = new BufferedReader(new FileReader("C:\\Users\\tyagisar\\Desktop\\product.txt"));

	     while ((sCurrentLine = br.readLine()) != null) {
	      System.out.println(sCurrentLine);
	      String[] str=sCurrentLine.split("|");
	      set1.add(str[2]);
	      set1.add(str[1]);
	      
	      
	     }

	    } catch (IOException e) {
	     e.printStackTrace();
	    } finally {
	     try {
	      if (br != null)br.close();
	     } catch (IOException ex) {
	      ex.printStackTrace();
	     }
	    }*/
	  }

	  public static Set< String > readTextFile( String fileName, int index )
	  {
	    Set set = new HashSet< String >();
	    BufferedReader br = null;
	    try
	    {

	      String sCurrentLine;

	      br = new BufferedReader( new FileReader( fileName ) );

	      while ( ( sCurrentLine = br.readLine() ) != null )
	      {
	        //System.out.println(sCurrentLine);
	        String[] str = sCurrentLine.split( "\\|" );
	        set.add( str[ index ] );
	        /*set1.add(str[1]);*/

	      }

	    }
	    catch ( IOException e )
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	    	
	      try
	      {
	        if ( br != null )
	        {
	          br.close();
	        }
	      }
	      catch ( IOException ex )
	      {
	        ex.printStackTrace();
	      }
	    }
	    return set;
	  }

	}

