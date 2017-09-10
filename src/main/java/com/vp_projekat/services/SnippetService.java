package com.vp_projekat.services;

import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.Snippet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/15/2017.
 */

@Service
public interface SnippetService {

    String createSnippet(SnippetDTO snippetDTO);

    Snippet removeSnippet(SnippetDTO snippetDTO);

    Snippet blockSnippet(SnippetDTO snippetDTO);

    Snippet unblockSnippet(SnippetDTO snippetDTO);

    ArrayList<Snippet> getAll();
}
