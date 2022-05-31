package ru.netology.repository;

public class NotInstallGameException extends RuntimeException {
    public NotInstallGameException(String s) {
        super(s);
    }
}
