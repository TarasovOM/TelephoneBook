package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private static final PhoneBook PHONE_BOOK = new PhoneBook();
    private static final Map<String, String> phoneBook = new HashMap<>();

    private PhoneBook() {
    }

    public static PhoneBook getInstance() {
        return PHONE_BOOK;
    }

    public int add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
        }
        phoneBook.put(name, phoneNumber);
        return phoneBook.size();
    }

    public String findByNumber(String phoneNumber) {
        return phoneBook.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(phoneNumber))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }

    public List<String> printAllNames() {
        return null;
    }
}
