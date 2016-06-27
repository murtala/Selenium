package dataDriven.parametrization;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DataGeneratorTest {

	  private String datum;
      private String expected;
      
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
    
    public DataGeneratorTest(String datum, String expected)
     {
        this.datum = datum;
        this.expected = expected;
        System.out.println("==> " + datum + " ==> " + expected);
     }
    
    
    
	//*
    /* Test data generator.
    /* This method is called the the JUnit parameterized test runner and
    /* returns a Collection of Arrays.  For each Array in the Collection,
    /* each array element corresponds to a parameter in the constructor.
    /*/
   @Parameters
   public static Collection<Object[]> generateData()
   {
	   
	// In this example, the parameter generator returns a List of
          // arrays.  Each array has two elements: { datum, expected }.
          // These data are hard-coded into the class, but they could be
          // generated or loaded in any way you like.
     
          
	return Arrays.asList(new Object[][]{ {"AGCCG", "AGTTA"}, {"AGTTA", "GATCA"}, {"GGGAT", "AGCCA"}});
      
   }
   
   //*
    /* The test.
    /* This test method is run once for each element in the Collection returned
    /* by the test data generator -- that is, every time this class is
    /* instantiated. Each time this class is instantiated, it will have a
    /* different data set, which is available to the test method through the
    /* instance's fields.
    /*/
   @Test
   public void testWhatever()
   {
    DataGenerator dg  = new DataGenerator(datum, expected);
   //  dg.generateData(datum);
      //assertThat(actualResult, is(this.expectedResult));
   }

}
