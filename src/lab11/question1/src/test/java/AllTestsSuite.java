import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName(value = "Array Flattener test suite")
@SelectClasses(value = {ArrayFlattenerTest.class})
public class AllTestsSuite {
}
