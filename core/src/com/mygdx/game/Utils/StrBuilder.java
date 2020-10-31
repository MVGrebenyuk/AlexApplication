package com.mygdx.game.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class StrBuilder {

    private static final int maxShortDescriptionLenght = 47;
    private static final int maxDescriptionLenght = 49;
    private static final int maxAdsDescriptionLenght = 45;
    private static final int maxVoteDescriptionLenght = 45;

    public static String createShortDescr(String str){
        int maxStrLength = maxShortDescriptionLenght;
        String circleString;
        ArrayList<Character> charArray = new ArrayList<>();
        String description = " ";
        char[] string = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char oneChar : string){
            charList.add(oneChar);
        }
        for (int i = maxStrLength; i > 0; i--) {
            try {
                if (charList.get(i).equals(' ')) {
                    for (int j = 0; j < i; j++) {
                        charArray.add(charList.get(0));
                        charList.remove(0);
                    }
                    StringBuilder sb = new StringBuilder(charArray.size());
                    for (char c : charArray) {
                        sb.append(c);
                    }
                    circleString = sb.toString();
                    description = description.concat(circleString);
                    description = description.concat("\n");
                    charArray.clear();
                    i = maxStrLength;
                }
            } catch (IndexOutOfBoundsException e){
                StringBuilder sb = new StringBuilder(charArray.size());
                for (char c : charList) {
                    sb.append(c);
                }
                circleString = sb.toString();
                description = description.concat(circleString);
                break;
            }
        }
        return description;
    }

    public static String createDescr(String str){
        int maxStrLength = maxDescriptionLenght;
        String circleString;
        ArrayList<Character> charArray = new ArrayList<>();
        String description = " ";
        char[] string = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char oneChar : string){
            charList.add(oneChar);
        }
        for (int i = maxStrLength; i > 0; i--) {
            try {
                if (charList.get(i).equals(' ')) {
                    for (int j = 0; j < i; j++) {
                        charArray.add(charList.get(0));
                        charList.remove(0);
                    }
                    StringBuilder sb = new StringBuilder(charArray.size());
                    for (char c : charArray) {
                        sb.append(c);
                    }
                    circleString = sb.toString();
                    description = description.concat(circleString);
                    description = description.concat("\n");
                    charArray.clear();
                    i = maxStrLength;
                }
            } catch (IndexOutOfBoundsException e){
                StringBuilder sb = new StringBuilder(charArray.size());
                for (char c : charList) {
                    sb.append(c);
                }
                circleString = sb.toString();
                description = description.concat(circleString);
                break;
            }
        }
        return description;
    }

    public static String createVoteDescr(String str){
        int maxStrLength = maxVoteDescriptionLenght;
        String circleString;
        ArrayList<Character> charArray = new ArrayList<>();
        String description = " ";
        char[] string = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char oneChar : string){
            charList.add(oneChar);
        }
        for (int i = maxStrLength; i > 0; i--) {
            try {
                if (charList.get(i).equals(' ')) {
                    for (int j = 0; j < i; j++) {
                        charArray.add(charList.get(0));
                        charList.remove(0);
                    }
                    StringBuilder sb = new StringBuilder(charArray.size());
                    for (char c : charArray) {
                        sb.append(c);
                    }
                    circleString = sb.toString();
                    description = description.concat(circleString);
                    description = description.concat("\n");
                    charArray.clear();
                    i = maxStrLength;
                }
            } catch (IndexOutOfBoundsException e){
                StringBuilder sb = new StringBuilder(charArray.size());
                for (char c : charList) {
                    sb.append(c);
                }
                circleString = sb.toString();
                description = description.concat(circleString);
                break;
            }
        }
        return description;
    }

    public static String createAdsDescription(String str){
        int maxStrLength = maxAdsDescriptionLenght;
        String circleString;
        ArrayList<Character> charArray = new ArrayList<>();
        String description = " ";
        char[] string = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char oneChar : string){
            charList.add(oneChar);
        }
        for (int i = maxStrLength; i > 0; i--) {
            try {
                if (charList.get(i).equals(' ')) {
                    for (int j = 0; j < i; j++) {
                        charArray.add(charList.get(0));
                        charList.remove(0);
                    }
                    StringBuilder sb = new StringBuilder(charArray.size());
                    for (char c : charArray) {
                        sb.append(c);
                    }
                    circleString = sb.toString();
                    description = description.concat(circleString);
                    description = description.concat("\n");
                    charArray.clear();
                    i = maxStrLength;
                }
            } catch (IndexOutOfBoundsException e){
                StringBuilder sb = new StringBuilder(charArray.size());
                for (char c : charList) {
                    sb.append(c);
                }
                circleString = sb.toString();
                description = description.concat(circleString);
                break;
            }
        }
        return description;
    }
}
