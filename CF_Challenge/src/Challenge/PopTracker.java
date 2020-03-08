package Challenge;

import java.util.Objects;

public class PopTracker {
    String country;
    String country_code;
    long population;
    String year;

    public PopTracker(){}

    public PopTracker(String country, String country_code, long population, String year) {
        this.country = country;
        this.country_code = country_code;
        this.population = population;
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopTracker that = (PopTracker) o;
        return population == that.population &&
                Objects.equals(country, that.country) &&
                Objects.equals(country_code, that.country_code) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, country_code, population, year);
    }

    @Override
    public String toString() {
        return "PopTracker{" +
                "country='" + country + '\'' +
                ", country_code='" + country_code + '\'' +
                ", population=" + population +
                ", year='" + year + '\'' +
                '}';
    }
}
