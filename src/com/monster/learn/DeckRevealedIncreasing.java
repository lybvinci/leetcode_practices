package com.monster.learn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//69.21%
public class DeckRevealedIncreasing {
  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    Deque<Integer> queue = new LinkedList<>();
    for (int i = deck.length - 1; i >= 0; i--) {
      if (!queue.isEmpty()) {
        queue.addFirst(queue.pollLast());
      }
      queue.addFirst(deck[i]);
    }
    int[] res = new int[deck.length];
    for (int i = 0; i < deck.length; i++) {
      res[i] = queue.poll();
    }
    return res;
  }

  public static void main(String[] args) {
    DeckRevealedIncreasing dri = new DeckRevealedIncreasing();
    int[] ret = dri.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
    System.out.println(ret);
  }
}