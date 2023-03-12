public class Pet {
  enum Kind {
    DOG,
    CAT,
    TURTLE,
  }

  private Kind kind;
  private String name;
  private String birthDate;
  private double weight;

  private Pet(String kind, String name) {
    this.kind = Kind.valueOf(kind);
    this.name = name;
  }

  private Pet(String kind, String name, double weight) {
    this.kind = Kind.valueOf(kind);
    this.name = name;
    this.weight = weight;
  }

  private Pet(String kind, String name,  double weight,String birthDate) {
    this.kind = Kind.valueOf(kind);
    this.name = name;
    this.birthDate = birthDate;
    this.weight = weight;
  }

  //  "turtle,кличка,вес,дата рождения"
  public static Pet parsePet(String line) {
    String[] lines = line.split(",", 4);
    String kind = lines[0].toUpperCase();
    String name = lines[1];
    double weight;
    switch (lines.length) {
      case 2 -> {
        return new Pet(kind, name);
      }
      case 3 -> {
        weight = Double.parseDouble(lines[2]);
        return new Pet(kind, name, weight);
      }
      case 4 -> {
        weight = Double.parseDouble(lines[2]);
        String birthDate = lines[3];
        return new Pet(kind, name, weight, birthDate);
      }
      default -> throw new IllegalArgumentException("Wrong line: " + line);
    }


  }
}
