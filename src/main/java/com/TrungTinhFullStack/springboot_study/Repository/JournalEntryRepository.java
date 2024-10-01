package com.TrungTinhFullStack.springboot_study.Repository;

import com.TrungTinhFullStack.springboot_study.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry,Long> {
}
