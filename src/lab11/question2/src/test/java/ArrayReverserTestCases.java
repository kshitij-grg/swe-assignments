import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName(value = "Array Reverser test suite")
@SelectClasses(value = {ArrayReverserTest.class})
public class ArrayReverserTestCases {
}
