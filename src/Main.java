import java.io.*;
import java.util.*;
/*
3
dog,Larry
cat,Kitty,3.5
turtle,Leonardo,2.3,12.10.2021
*/
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Pet> pets = new ArrayList<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      pets.add(Pet.parsePet(br.readLine()));
    }
    System.out.println("\nYour pets:");
    for (Pet pet : pets) {
      System.out.printf("\u001B[34m %n%s %s%n\u001B[0m", pet.getKind(), pet.getName());
      if (pet.getWeight() != 0) {
        System.out.println(" Weighs: " + pet.getWeight());
      }
      if (pet.getBirthDate() != null) {
        System.out.println(" Born on: " + pet.getBirthDate());
      }
    }
  }
}
