public class Pet {
  enum Kind {
    DOG,
    CAT,
    TURTLE,
  }

  private final Kind kind;
  private final String name;
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

  private Pet(String kind, String name, double weight, String birthDate) {
    this.kind = Kind.valueOf(kind);
    this.name = name;
    this.birthDate = birthDate;
    this.weight = weight;
  }

  public Kind getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public double getWeight() {
    return weight;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  //  "turtle,кличка,вес,дата рождения"
  public static Pet parsePet(String line) {
    String[] lines = line.split(",", 4);
    if (lines.length < 2) {
      throw new IllegalArgumentException("Wrong line: " + line);
    }
    String kind = lines[0].toUpperCase();
    String name = lines[1];
    double weight;
    try {
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
      }
    } catch (NumberFormatException e) {
      System.err.println("Wrong weight: " + e.getMessage());
    }
    return new Pet(kind, name);
  }
}
