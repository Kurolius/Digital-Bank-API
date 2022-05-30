package me.majbar.digitalbankingrestapi.exceptions;

public class BankAccountNotFoundExcetion extends Exception {
    public BankAccountNotFoundExcetion(String message) {
        super(message);
    }
}
