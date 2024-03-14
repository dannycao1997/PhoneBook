package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
    private final Map<String, List<String>> phonebook; //MAP

    public PhoneBook(Map<String, List<String>> map) {
        if(map == null) {
        this.phonebook = new LinkedHashMap<>();
    } else {
            this.phonebook = new LinkedHashMap<>();
        }
    }


    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumbers = phonebook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phonebook.put(name, phoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook != null && phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    public String reverseLookup(String phoneNumber) {
        if (phonebook != null) {
            for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
                if (entry.getValue().contains(phoneNumber)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();
        if (phonebook != null) {
            contactNames.addAll(phonebook.keySet());
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return new LinkedHashMap<>(phonebook);
    }
}
