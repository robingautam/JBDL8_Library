package org.gfg.JBDL8_DigitalLibrary.service;

import org.gfg.JBDL8_DigitalLibrary.model.Book;
import org.gfg.JBDL8_DigitalLibrary.model.Transaction;
import org.gfg.JBDL8_DigitalLibrary.repository.BookRepository;
import org.gfg.JBDL8_DigitalLibrary.repository.TransactionRepository;
import org.gfg.JBDL8_DigitalLibrary.request.BookTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    public Transaction createTransaction(BookTransactionRequest request){
        int row= transactionRepository.issueBookToStudent(request);
        if (row<=0){
            return null;
        }

        Book book = bookRepository.findBookById(request.getBookId());
        Transaction transaction = new Transaction();
        transaction.setBook(book);
        return transaction;

    }
}
