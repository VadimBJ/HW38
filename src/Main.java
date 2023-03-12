import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Pet> pets = new ArrayList<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      pets.add(Pet.parsePet(br.readLine()));
    }
  }
}
//Pet dog = Pet.parsePet("dog,Lary");
//Pet cat = Pet.parsePet("cat,Kitty,3.5");
//Pet turtle = Pet.parsePet("turtle,Leonardo,2.3,12.10.2021");
/*
3
dog,Lary
cat,Kitty,3.5
turtle,Leonardo,2.3,12.10.2021
*/