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

  public int getCityCount() {
    return cityList.size();
  }

  public City getCityByName(String cityName, String stateName) {
    for (City currentCity : cityList) {
      if (currentCity.getName().equals(cityName) && currentCity.getState().equals(stateName)) {
        return currentCity;
      }
    }
    return null;
  }

  public void printHottestCities() {
    City firstBest = null;
    City nextBest = null;
    double highestTemp = 0;

    for (City currentCity : cityList) {
      if (currentCity.getHighTemp() > highestTemp) {
        firstBest = currentCity;
        highestTemp = currentCity.getHighTemp();
      }
    }

    highestTemp = 0;
    for (City currentCity : cityList) {
      if ((currentCity.getHighTemp() > highestTemp) && (currentCity != firstBest)) {
        nextBest = currentCity;
        highestTemp = currentCity.getHighTemp();
      }
    }

    firstBest.printInfo();
    nextBest.printInfo();
  }

  public void printColdestCities() {
    City firstBest = null;
    City nextBest = null;
    double lowestTemp = 0;

    for (City currentCity : cityList) {
      if (currentCity.getLowTemp() > lowestTemp) {
        firstBest = currentCity;
        lowestTemp = currentCity.getLowTemp();
      }
    }

    lowestTemp = 0;
    for (City currentCity : cityList) {
      if ((currentCity.getLowTemp() > lowestTemp) && (currentCity != firstBest)) {
        nextBest = currentCity;
        lowestTemp = currentCity.getLowTemp();
      }
    }

    firstBest.printInfo();
    nextBest.printInfo();
  }

  public void printAllCities() {
    for (City currentCity : cityList) {
      currentCity.printInfo();
    }
  }
}