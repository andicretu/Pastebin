package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@org.springframework.stereotype.Controller
public class PasteController {
    private final TextEntryRepository textEntryRepository;

    @Autowired
    public PasteController(TextEntryRepository textEntryRepository) {
        this.textEntryRepository = textEntryRepository;
    }

    @GetMapping("/paste/list")
    public String listPastes(Model model) {
        List<TextEntry> textEntries = (List<TextEntry>) textEntryRepository.findAll();
        model.addAttribute("textEntries", textEntries);
        model.addAttribute("textEntry", new TextEntry());
        return "pasteList";
    }

    @PostMapping("/paste/create")
    public String createPaste(@ModelAttribute("textEntry") TextEntry textEntry, Model model) {
        textEntry.setPreview(textEntry.getContent().substring(0, Math.min(textEntry.getContent().length(), 25)));
        textEntryRepository.save(textEntry);
        model.addAttribute("message", "Text saved successfully!");
        return "redirect:/paste/list";
    }

    @GetMapping("/paste/{id}")
    public String viewPaste(@PathVariable Long id, Model model) {
        TextEntry textEntry = textEntryRepository.findById(id).orElseThrow();
        model.addAttribute("textEntry", textEntry);
        return "pasteView";
    }
}
