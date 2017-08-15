
/**
 * Created by Lupus on 8/9/2017.
 */

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

public class Snippets {
    
    private static ArrayList<Snippet> snippets = new ArrayList<Snippet>();


    public Snippets(ArrayList<Snippet> snippets) {
        super();
        Snippets.setSnippets(snippets);
    }

    public static Snippet getSnippet(int id)
    {
        for(Snippet s: getSnippets())
        {
            if(s.getId() == id)
            {
                System.out.println("NASAO");
                return s;
            }
        }
        return null;
    }

    public static void addSnippet(Snippet snippet)
    {
        Snippets.getSnippets().add(snippet);
        save();
    }

    public static Snippet deleteSnippet(int id)
    {
        for(Snippet s: getSnippets())
        {
            if(s.getId() == id)
            {
                getSnippets().remove(s);
                save();
                return s;
            }
        }
        return null;
    }

    public static void load(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/snippets.json"));
            String json = "";
            String line;
            while((line = reader.readLine()) != null)
            {
                json += line;
            }
            Snippets.setSnippets(mapper.readValue(json,
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Snippet.class)));
            reader.close();

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

    public static void save() {
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in file
        try {
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("./src/snippets.json"), Snippets.snippets);
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

    public static ArrayList<Snippet> getSnippets() {
        Snippets.load();
        return snippets;
    }

    public static void setSnippets(ArrayList<Snippet> snippets) {
        Snippets.snippets = snippets;
    }

    public void setUsers(ArrayList<Snippet> snippets) {
        this.setSnippets(snippets);
    }
}
