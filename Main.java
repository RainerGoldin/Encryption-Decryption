import java.util.*;

public class Main{
  private static ArrayList<Character> list = new ArrayList<>();
  private static ArrayList<Character> shuffledList = new ArrayList<>();
  private static char letter;
  private static char[] letters;
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args){
    while (true){
      System.out.println("************************************************");
      System.out.println("What are you going to do?");
      System.out.print("(N)ewkey, (G)etkey, (E)ncrypt, (D)ecrypt, (Q)uit\nOption: ");
      char option = Character.toUpperCase(sc.nextLine().charAt(0));

      switch (option){
        case 'N':
          newKey();
          break;
        case 'G':
          getKey();
          break;
        case 'E':
          encrypt();
          break;
        case 'D':
          decrypt();
          break;
        case 'Q':
          System.exit(0);
        default:
          System.out.println("Not a valid option!");;
      }
    }
  }

  private static void newKey(){
    letter = ' ';
    list.clear();
    shuffledList.clear();

    for(int i = 32;i < 127; i++){
      list.add(Character.valueOf(letter));
      letter++;
    }

    shuffledList = new ArrayList<Character>(list);
    Collections.shuffle(shuffledList);
    System.out.println("Generated a new key!");
  }

  private static void getKey(){
    System.out.println("Key:");

    System.out.print("Original: ");
    for (char x : list){
      System.out.print(x);
    }
    System.out.println();

    System.out.print("Shuffled: ");
    for (char x : shuffledList){
      System.out.print(x);
    }
    System.out.println();
  }

  private static void encrypt(){
    System.out.print("Enter a message to be encrypted: ");
    String message = sc.nextLine();
    letters = message.toCharArray();

    for (int i = 0; i < letters.length; i++){
      for (int j = 0; j < list.size(); j++){
        if(letters[i] == list.get(j)){
          letters[i] = shuffledList.get(j);
          break;
        }
      }
    }

    System.out.print("Encrypted: ");
    for (char x : letters){
      System.out.print(x);
    }
    System.out.println();
  }

  private static void decrypt(){
    System.out.print("Enter a message to be decrypted: ");
    String message = sc.nextLine();
    letters = message.toCharArray();

    for (int i = 0; i < letters.length; i++){
      for (int j = 0; j < shuffledList.size(); j++){
        if(letters[i] == shuffledList.get(j)){
          letters[i] = list.get(j);
          break;
        }
      }
    }

    System.out.print("Decrypted: ");
    for (char x : letters) {
      System.out.print(x);
    }
    System.out.println();
  }
}