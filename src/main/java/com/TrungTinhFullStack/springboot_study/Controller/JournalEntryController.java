package com.TrungTinhFullStack.springboot_study.Controller;
import com.TrungTinhFullStack.springboot_study.Entity.JournalEntry;
import com.TrungTinhFullStack.springboot_study.Service.JournalEntry.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journalEntry")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/all")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntry() {
        return ResponseEntity.ok(journalEntryService.getAllJournalEntry());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(journalEntryService.getJournalEntryById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<JournalEntry> addJournalEntry(@RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok(journalEntryService.addJournalEntry(journalEntry));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable Long id,@RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok(journalEntryService.updateJournalEntry(id,journalEntry));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JournalEntry> deleteJournalEntry(@PathVariable Long id) {
        return ResponseEntity.ok(journalEntryService.deleteJournalEntry(id));
    }

}
