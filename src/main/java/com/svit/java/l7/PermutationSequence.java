package com.svit.java.l7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


/**
 * Write a program to generate ALL unique permutations of those characters. Unique. You may not
 * store in an array or list, due to memory constraints. e.g. for input of abc your program should
 * give 6 permutations but for aba your program should give 3. Hint: make the list alphabetical.
 *
 * input "abc" output [abc, acb, bac, bca, cab, cba]
 *
 *
 * input "aba" output [baa, aab, aba]
 *
 * @author Brian
 *
 */
public class PermutationSequence {
  public static void main(String[] args) {
    // System.out.println(permutations("aba"));
    System.out.println(permutationsIterative("aba"));

  }

  public static ArrayList<String> permutations(String input) {
    ArrayList<String> result = new ArrayList<String>();
    helper(input, "", result);

    return result;
  }

  private static void helper(String input, String sol, ArrayList<String> result) {
    if (input.length() == 0) {
      result.add(sol);
    }

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (input.substring(i + 1).indexOf(c) != -1)
        continue;

      helper(input.substring(0, i) + input.substring(i + 1), sol + c, result);
    }
  }


  // iterative solution - to do
  public static LinkedList<String> permutationsIterative(String input) {

    LinkedList<String> res = new LinkedList<>();
    res.add("");
    for (int i = 0; i < input.length(); i++) {
      Set<String> cache = new HashSet<>();
      while (res.peekFirst().length() == i) {
        String l = res.removeFirst();
        for (int j = 0; j <= l.length(); j++) {
          String x = l.substring(0, j) + input.charAt(i) + l.substring(j);
          if (cache.add(x)) {
            res.add(x);
          }
        }

      }
    }
    return res;

  }
}
