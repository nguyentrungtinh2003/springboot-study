package com.TrungTinhFullStack.springboot_study.Service.JournalEntry;

import com.TrungTinhFullStack.springboot_study.Entity.JournalEntry;
import com.TrungTinhFullStack.springboot_study.Entity.User;
import com.TrungTinhFullStack.springboot_study.Repository.JournalEntryRepository;
import com.TrungTinhFullStack.springboot_study.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService{

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<JournalEntry> getAllJournalEntry() {
        return journalEntryRepository.findAll();
    }

    @Override
    public JournalEntry getJournalEntryById(Long id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public JournalEntry addJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    @Override
    @Transactional
    public JournalEntry updateJournalEntry(Long id, JournalEntry journalEntry) {
        JournalEntry journalEntry1 = getJournalEntryById(id);
        User user = userService.getUserById(journalEntry.getUser().getId());
        journalEntry1.setTitle(journalEntry.getTitle());
        journalEntry1.setContent(journalEntry.getContent());
        journalEntry1.setDate(LocalDateTime.now());
        journalEntry1.setUser(user);
        return null;
    }

    @Override
    @Transactional
    public JournalEntry deleteJournalEntry(Long id) {
        JournalEntry journalEntry1 = getJournalEntryById(id);
        journalEntryRepository.delete(journalEntry1);
        return journalEntry1;
    }
}
