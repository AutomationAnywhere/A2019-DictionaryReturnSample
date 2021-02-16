import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.samples.commands.basic.ValuesToDictionary;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValuesToDictionaryTest {
    @Test
    public void testValuesToDictionary(){
        String expectedString = "Go be Great!";
        Double expectedNumber = 100.0;

        //new ValuesToDictionary Object for testing
        ValuesToDictionary testPackage = new ValuesToDictionary();
        //Assigning output from the ValuesToDictionaryAction to a Dictionary
        DictionaryValue packageOutput = testPackage.action(expectedString, expectedNumber);
        //Write out to see results
        System.out.println("First Value: " + packageOutput.get("FirstValue").toString());
        System.out.println("Expected First Value: " + expectedString);
        Assert.assertEquals(packageOutput.get("FirstValue").toString(), expectedString);
    }
}
