package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.HashMap;
import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.NUMBER;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.DICTIONARY;


//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be displayed on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        //Typically these should be references to a locales.json variable - but this is just a Demo
        name = "ValuestoDictionary", label = "Values to Dictionary",
        node_label = "Dictionary Demo", description = "Demo package to demonstrate returning values in a dictionary data type", icon = "pkg.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        //Setting to DICTIONARY here to establish a dictionary return
        return_label = "Demo Dictionary Return", return_type = DICTIONARY, return_required = true)
public class ValuesToDictionary {

    //Identify the entry point for the action. Because the whole point of this is to demonstrate the return of a
    //a DictionaryValue, this is set accordingly.
    //The purpose of this bot is just to take in 2 values...one string, one number, and use those values to return as
    //a dictionary in A2019.
    @Execute
    public DictionaryValue action(
            //Idx 1 would be displayed first, with a text box for entering the value. Because we want to take in
            //a String, this should be set as TEXT
            @Idx(index = "1", type = TEXT)
            //UI labels.
            @Pkg(label = "String to return in Dictionary")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
                    String providedString,

            //Idx 2 would be displayed second, with a text box for a number only. Because we want to take in
            //a Number (A2019 data format), this should be set as NUMBER
            @Idx(index = "2", type = NUMBER)
            @Pkg(label = "Number to return in Dictionary")
            @NotEmpty
                Double providedNumber){

        //Dictionary isn't standard a Java datatype, so we'll create a Map.
        //Within AA, a dictionary is going to be of type <String, Value> - where Value is an AA botcommand.datatype
        //So we'll use Value in the map definition, then fill that with a String, Number, or Boolean
        Map<String, Value> sampleMap = new HashMap<String, Value>();

        //Because Value is a botcommand.datatype, we need to only put other botcommand datatypes in it.
        //So we need to convert from standard Java types to botcommand datatypes
        StringValue botcommandString = new StringValue(providedString);
        sampleMap.put("FirstValue", botcommandString);

        //Same thing for storing the number in the map
        NumberValue botcommandNumber = new NumberValue(providedNumber);
        sampleMap.put("SecondValue", botcommandNumber);

        //Because we need to return this as a Dictionary Value, we'll create a new dictionary
        //value and provide our Java Map.
        return new DictionaryValue(sampleMap);

    }
}
