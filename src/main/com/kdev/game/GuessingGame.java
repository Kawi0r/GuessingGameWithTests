package com.kdev.game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1;
    private int counter = 0;

    public String guess(int guessedNumber) {
        counter++;
        String tryMsg = counter == 1 ? "try" : "tries";
        String winningMessage = String.format("You Win, in %d %s", counter, tryMsg);
        String response;
        if (counter == 4 && (guessedNumber != getRandomNumber())) {
            response = String.format("You didn't get it, in %d %s! Game Over!", counter, tryMsg);
        } else if (counter > 4) {
            response = "Sorry, you are limited to only 4 tries! Game Over!";
        } else {
            String lowHighText = (guessedNumber < getRandomNumber()) ? "low" : "high";
            String loseText = String.format("You didn't get it! - you're too %s", lowHighText);
            response = guessedNumber == getRandomNumber() ? winningMessage : loseText;
        }
        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter a number: ");
            String input = sc.nextLine();
            if ("q".equals(input)) {
                return;
            }
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            if (output.contains("You Win") || output.contains("Game Over")) {
                loopShouldContinue = false;
            }
        } while (loopShouldContinue);
    }
}
