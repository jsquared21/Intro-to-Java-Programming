/*
(Geography: estimate areas) Find the GPS locations for Atlanta, Georgia;
Orlando, Florida; Savannah, Georgia; and Charlotte, North Carolina from
www.gps-data-team.com/map/ and compute the estimated area enclosed by these
four cities. (Hint: Use the formula in Programming Exercise 4.2 to compute the
distance between two cities. Divide the polygon into two triangles and use the
formula in Programming Exercise 2.19 to compute the area of a triangle.)
*/
public class Exercise_04_03 {  
    public static void main(String[] args) {  
        final double RADIUS = 6371.01;
        double AtlantaLatitude = Math.toRadians(33.753746);
        double AtlantaLongitude = Math.toRadians(-84.386330);
        double OrlandoLatitude = Math.toRadians(28.5383355);
        double OrlandoLongitude = Math.toRadians(-81.3792365);
        double SavannahLatitude = Math.toRadians(32.0835407);
        double SavannahLongitude = Math.toRadians(-81.0998342);
        double CharlotteLatitude = Math.toRadians(35.2270869);
        double CharlotteLongitude = Math.toRadians(-80.8431267);
        
        double distanceAtlantaOrlando =
                RADIUS * Math.acos(Math.sin(AtlantaLatitude)
                                * Math.sin(OrlandoLatitude)
                        + Math.cos(AtlantaLatitude)
                                * Math.cos(OrlandoLatitude) 
                                * Math.cos(AtlantaLongitude - OrlandoLongitude)
                );

        double distanceOrlandoSavannah = 
                RADIUS * Math.acos(Math.sin(OrlandoLatitude)
                                * Math.sin(SavannahLatitude)
                        + Math.cos(OrlandoLatitude)
                                * Math.cos(SavannahLatitude) 
                                * Math.cos(OrlandoLongitude - SavannahLongitude)
                );
        
        double distanceSavannahCharlotte =
                RADIUS * Math.acos(Math.sin(SavannahLatitude)
                                * Math.sin(CharlotteLatitude)
                        + Math.cos(SavannahLatitude)
                                * Math.cos(CharlotteLatitude) 
                                * Math.cos(SavannahLongitude - CharlotteLongitude)
                );
        
        double distanceAtlantaCharlotte =
                RADIUS * Math.acos(Math.sin(AtlantaLatitude)
                                * Math.sin(CharlotteLatitude)
                        + Math.cos(AtlantaLatitude)
                                * Math.cos(CharlotteLatitude) 
                                * Math.cos(AtlantaLongitude - CharlotteLongitude)
                );
        
        double distanceAtlantaSavannah =
                RADIUS * Math.acos(Math.sin(AtlantaLatitude)
                                * Math.sin(SavannahLatitude)
                        + Math.cos(AtlantaLatitude)
                                * Math.cos(SavannahLatitude) 
                                * Math.cos(AtlantaLongitude - SavannahLongitude)
                );
        
        double s1 = (distanceAtlantaCharlotte
                + distanceSavannahCharlotte + distanceAtlantaSavannah) / 2;
        double area1 =
                Math.pow(s1 * (s1
                        - distanceAtlantaCharlotte) * (s1
                                - distanceSavannahCharlotte) * (s1
                                        - distanceAtlantaSavannah), 0.5);
        
        double s2 = (distanceOrlandoSavannah 
                + distanceAtlantaOrlando + distanceAtlantaSavannah) / 2;
        double area2 =
                Math.pow(s2 * (s2 
                        - distanceOrlandoSavannah) * (s2 
                                - distanceAtlantaOrlando) * (s2 
                                        - distanceAtlantaSavannah), 0.5);
        
        System.out.println("Areea = "
                + Math.round((area1 + area2) * 100) / 100. + " km^2");
    }  
}
