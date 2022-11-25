import java.util.regex.Matcher;
import java.util.regex.Pattern;
 abstract class Car {
     /**
      * The license plate of the car
      */
     private String licensePlate;
     /**
      * The chauffeur of the car
      */
     private Chauffeur chauffeur;
     /**
      * The brand of the car
      */
     private Brand brand;


     /**
      * Create a car
      * @param licensePlate
      * @param chauffeur
      * @param brand
      */
     public Car(String licensePlate, Chauffeur chauffeur, Brand brand) {
         /**
          * If the license plate has the right format, add it to the object in uppercase letters
          */
         checkLicensePlate(licensePlate);
         this.chauffeur = chauffeur;
         this.brand = brand;
     }

     /**
      * Set the licensePlate of the car
      * @param licensePlate
      */
     public void setLicensePlate(String licensePlate) {
         checkLicensePlate(licensePlate);
     }

     /**
      * Get the chauffeur of the car
      * @return The chauffeur of the car
      */
     public Chauffeur getChauffeur() {
         return this.chauffeur;
     }

     /**
      * Set the chauffeur of the car
      * @param chauffeur
      */
     public void setChauffeur(Chauffeur chauffeur) {
         this.chauffeur = chauffeur;
     }

     /**
      * Check the format of a license plate
      * @param licensePlate
      * @return true or false
      */
     public boolean checkLicensePlate(String licensePlate) {
         /**
          * Check if the license plate matches the format '999-XX-9' after the string has been put to uppercase letters
          */
         Matcher lpMatcher = Pattern.compile("[0-9]{3}-[A-Z]{2}-[0-9]").matcher(licensePlate.toUpperCase());
         if (lpMatcher.find()) {
             this.licensePlate = licensePlate.toUpperCase();
             return true;
         } else {
             return false;
         }
     }

     /**
      * Calculate the costs of a single trip
      * This class can't be used to create an object
      * @return The costs of a trip in euro's
      */
     public abstract double calculateTripCosts(double distance);
 }



