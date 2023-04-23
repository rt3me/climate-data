import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Implement your ClimateZone class in this file
class ClimateZone {
  private ArrayList<City> cityList = null;

  public ClimateZone() {
    this.cityList = new ArrayList<City>();
  }

  public ClimateZone(String fileName) throws IOException {
    this.cityList = new ArrayList<City>();

    Scanner myFileReader = new Scanner(new FileInputStream(fileName));

    while (myFileReader.hasNext()) {
      String name = myFileReader.next();
      String state = myFileReader.next();
      double highTemp = myFileReader.nextDouble();
      double lowTemp = myFileReader.nextDouble();

      this.addCity(name, state, highTemp, lowTemp);
    }

    myFileReader.close();
  }

  public void addCity(String name, String state, double highTemp, double lowTemp) {
    City newCity = new City(name, state, highTemp, lowTemp);
    cityList.add(newCity);
  }
}