package org.openapitools.api;

import org.openapitools.model.Amount;
import org.openapitools.model.CardAccountTransactionsResponse;
import org.openapitools.model.CardTransaction;
import org.openapitools.model.CardTransactionList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CardAccountsApiDelegate for Berlin Group card accounts API.
 * This service handles card account transaction retrieval as per REQ_0770.
 */
@Service
public class CardAccountsApiDelegateImpl implements CardAccountsApiDelegate {

    @Override
    public ResponseEntity<CardAccountTransactionsResponse> getCardAccountTransactions(
            String accountId,
            LocalDate dateFrom,
            LocalDate dateTo,
            String bookingStatus) {

        // Validate account ID
        if (accountId == null || accountId.trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Create sample response data
        CardAccountTransactionsResponse response = new CardAccountTransactionsResponse();
        response.setCardAccountId(accountId);

        CardTransactionList transactionList = new CardTransactionList();

        // Add booked transactions if requested
        if ("booked".equals(bookingStatus) || "both".equals(bookingStatus)) {
            transactionList.setBooked(createSampleBookedTransactions(dateFrom, dateTo));
        }

        // Add pending transactions if requested
        if ("pending".equals(bookingStatus) || "both".equals(bookingStatus)) {
            transactionList.setPending(createSamplePendingTransactions());
        }

        response.setTransactions(transactionList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Creates sample booked transactions.
     * In a real implementation, this would query the backend system.
     */
    private List<CardTransaction> createSampleBookedTransactions(LocalDate dateFrom, LocalDate dateTo) {
        List<CardTransaction> bookedTransactions = new ArrayList<>();

        CardTransaction transaction1 = new CardTransaction();
        transaction1.setTransactionId("TXN-BOOKED-001");
        transaction1.setTransactionAmount(createAmount("EUR", "256.67"));
        transaction1.setBookingDate(LocalDate.of(2024, 1, 15));
        transaction1.setValueDate(LocalDate.of(2024, 1, 15));
        transaction1.setCreditorName("Grocery Store");
        transaction1.setMerchantCategoryCode("5411");
        transaction1.setTransactionDetails("Grocery purchase");
        bookedTransactions.add(transaction1);

        CardTransaction transaction2 = new CardTransaction();
        transaction2.setTransactionId("TXN-BOOKED-002");
        transaction2.setTransactionAmount(createAmount("EUR", "89.50"));
        transaction2.setBookingDate(LocalDate.of(2024, 1, 16));
        transaction2.setValueDate(LocalDate.of(2024, 1, 16));
        transaction2.setCreditorName("Gas Station");
        transaction2.setMerchantCategoryCode("5542");
        transaction2.setTransactionDetails("Fuel purchase");
        bookedTransactions.add(transaction2);

        CardTransaction transaction3 = new CardTransaction();
        transaction3.setTransactionId("TXN-BOOKED-003");
        transaction3.setTransactionAmount(createAmount("EUR", "45.00"));
        transaction3.setBookingDate(LocalDate.of(2024, 1, 17));
        transaction3.setValueDate(LocalDate.of(2024, 1, 17));
        transaction3.setCreditorName("Online Retailer");
        transaction3.setMerchantCategoryCode("5999");
        transaction3.setTransactionDetails("Online shopping");
        bookedTransactions.add(transaction3);

        // Filter by date if provided
        if (dateFrom != null || dateTo != null) {
            bookedTransactions.removeIf(txn -> {
                LocalDate txnDate = txn.getBookingDate();
                if (dateFrom != null && txnDate.isBefore(dateFrom)) {
                    return true;
                }
                if (dateTo != null && txnDate.isAfter(dateTo)) {
                    return true;
                }
                return false;
            });
        }

        return bookedTransactions;
    }

    /**
     * Creates sample pending transactions.
     * In a real implementation, this would query the backend system.
     */
    private List<CardTransaction> createSamplePendingTransactions() {
        List<CardTransaction> pendingTransactions = new ArrayList<>();

        CardTransaction transaction1 = new CardTransaction();
        transaction1.setTransactionId("TXN-PENDING-001");
        transaction1.setTransactionAmount(createAmount("EUR", "125.00"));
        transaction1.setCreditorName("Restaurant");
        transaction1.setMerchantCategoryCode("5812");
        transaction1.setTransactionDetails("Dinner");
        pendingTransactions.add(transaction1);

        CardTransaction transaction2 = new CardTransaction();
        transaction2.setTransactionId("TXN-PENDING-002");
        transaction2.setTransactionAmount(createAmount("EUR", "35.99"));
        transaction2.setCreditorName("Coffee Shop");
        transaction2.setMerchantCategoryCode("5814");
        transaction2.setTransactionDetails("Coffee and snacks");
        pendingTransactions.add(transaction2);

        return pendingTransactions;
    }

    /**
     * Helper method to create an Amount object.
     */
    private Amount createAmount(String currency, String amount) {
        Amount amountObj = new Amount();
        amountObj.setCurrency(currency);
        amountObj.setAmount(amount);
        return amountObj;
    }
}
