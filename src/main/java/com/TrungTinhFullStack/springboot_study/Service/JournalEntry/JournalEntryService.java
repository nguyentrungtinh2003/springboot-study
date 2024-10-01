package com.TrungTinhFullStack.springboot_study.Service.JournalEntry;

import com.TrungTinhFullStack.springboot_study.Entity.JournalEntry;

import java.util.List;

public interface JournalEntryService {

    List<JournalEntry> getAllJournalEntry();
    JournalEntry getJournalEntryById(Long id);
    JournalEntry addJournalEntry(JournalEntry journalEntry);
    JournalEntry updateJournalEntry(Long id,JournalEntry journalEntry);
    JournalEntry deleteJournalEntry(Long id);
}
