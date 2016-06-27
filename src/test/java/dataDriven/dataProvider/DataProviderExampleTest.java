package dataDriven.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExampleTest {
@Parameters({"param1", "param2"})
  @Test
  public void usingXMLFile(int p1, String p2) {
	System.out.println("Parameter Example: Data(" + p1 + ", " + p2 + ")");
  }

@Test(dataProvider="getData")
public void usingAnnotations(int p1, String p2) {
	System.out.println("Instance DataProvider Example: Data(" + p1 + ", " + p2 + ")");
}	


@DataProvider
public Object[][] getData() {
	return new Object[][]{{5, "five"}, {6, "six"}};
}
  
}
