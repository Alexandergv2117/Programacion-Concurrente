public class season {
  String[] seasons = {"Primavera", "Verano", "Otoño", "Invierno"};
    double[] multiplier = {1, 1.5, 2, .5};
    String currentSeason;
    double currentMultiplier;
  
    int seasonLength = seasons.length;

    public season(int season) {
      currentSeason = seasons[season];
      currentMultiplier = multiplier[season];

      System.out.println("La temporada actual es: " + currentSeason + " con un multiplicador de: " + currentMultiplier + "x\n");
    }
  
    public void setChangeSeason() {
      System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$   Cambiando de estación...   $$$$$$$$$$$$$$$$$$$$$$$$$\n");
      for (int i = 0; i < seasonLength; i++) {
        if (currentSeason.equals(seasons[i])) {
          if (i == seasonLength - 1) {
            currentSeason = seasons[0];
            currentMultiplier = multiplier[0];
            break;
          }
          currentSeason = seasons[i + 1];
          currentMultiplier = multiplier[i + 1];
          break;
        }
      }
      System.out.println("La temporada actual es: " + currentSeason + " con un multiplicador de: " + currentMultiplier + "x\n");
    }
  
    public String getCurrentSeason() {
      return this.currentSeason;
    }
  
    public double getCurrentMultiplier() {
      return this.currentMultiplier;
    }
}
