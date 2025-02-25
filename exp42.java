import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String toString() {
        return symbol + " " + value;
    }
}

public class exp42 {
    public static void main(String[] args) {
        Map<String, List<Card>> cardMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        addCard(cardMap, "Hearts", "A");
        addCard(cardMap, "Spades", "10");
        addCard(cardMap, "Diamonds", "K");
        addCard(cardMap, "Hearts", "7");
        addCard(cardMap, "Clubs", "Q");

        System.out.print("Enter a symbol to find cards: ");
        String symbol = scanner.nextLine();

        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards with symbol " + symbol + ": " + cardMap.get(symbol));
        } else {
            System.out.println("No cards found for symbol " + symbol);
        }
        scanner.close();
    }

    static void addCard(Map<String, List<Card>> cardMap, String symbol, String value) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(new Card(symbol, value));
    }
}
