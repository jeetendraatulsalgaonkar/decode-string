package com.salgaonkar.decode.string;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String encodedString) {
        String decodedString = "";
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int count = 0;
        for (int i = 0; i < encodedString.length(); ++i) {
            if (encodedString.charAt(i) >= '0' && encodedString.charAt(i) <= '9' ) {
                count = count * 10 + encodedString.charAt(i) - '0';
            } else if (encodedString.charAt(i) == '[') {
                integerStack.push(count);
                stringStack.push(decodedString);
                count = 0;
                decodedString = "";
            } else if (encodedString.charAt(i) == ']') {
                int k = integerStack.pop();
                String next = stringStack.pop();
                for (int j = 0; j < k; ++j) {
                    next += decodedString;
                }
                decodedString = next;
            } else {
                decodedString += encodedString.charAt(i);
            }
        }
        return decodedString;
    }
}
