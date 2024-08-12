package org.example;
import java.util.HashMap;
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
        if (phoneBook.containsKey(name)) {
            return phoneBook.size();
        }
        phoneBook.put(name, phoneNumber);
        return phoneBook.size();
    }
    public String findByNumber(String phoneNumber) {
        return null;
    }
}
