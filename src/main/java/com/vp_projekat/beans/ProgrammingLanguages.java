package com.vp_projekat.beans;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lupus on 8/9/2017.
 */
public class ProgrammingLanguages {
    private static ArrayList<String> languages;

    public static ArrayList<String> getLanguages() {
        return languages;
    }

    public static void setLanguages(ArrayList<String> languages) {
        ProgrammingLanguages.languages = languages;
        load();
    }

    public static void addLanguage(String language)
    {
        ProgrammingLanguages.languages.add(language);
        load();
    }

    public static void load()
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedReader reader = new BufferedReader(new FileReader
                    ("./src/languages.json"));
            String json = "";
            String line;
            while((line = reader.readLine()) != null)
            {
                json += line;
            }
            ProgrammingLanguages.languages = mapper.readValue(json,
                    mapper.getTypeFactory().constructCollectionType
                            (ArrayList.class, String.class));
            reader.close();
            System.out.println(languages.get(0));
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ProgrammingLanguages()
    {
        load();
    }

    public static boolean getLanguage(String language)
    {
        for(String l : ProgrammingLanguages.languages)
        {
            if(l.equalsIgnoreCase(language))
            {
                return true;
            }
        }
        return false;
    }

    public static void save()
    {
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in file
        try {

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("./src/languages.json"), ProgrammingLanguages.languages);
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
