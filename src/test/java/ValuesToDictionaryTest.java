import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.samples.commands.basic.ValuesToDictionary;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ValuesToDictionaryTest {
    @Test
    public void testValuesToDictionary(){
        String expectedString = "Go be Great!";
        Double expectedNumber = 100.0;
        Map<String, Object> expectedDictionary = new HashMap<>();
        expectedDictionary.put("FirstValue", expectedString);
        expectedDictionary.put("SecondValue", expectedNumber);

        ValuesToDictionary testPackage = new ValuesToDictionary();

        DictionaryValue packageOutput = testPackage.action(expectedString, expectedNumber);
        //Write out to see results
        System.out.println("First Value: " + packageOutput.get("FirstValue").toString());
        System.out.println("Expected First Value: " + expectedString);
        Assert.assertEquals(packageOutput.get("FirstValue").toString(), expectedString);
    }
}
