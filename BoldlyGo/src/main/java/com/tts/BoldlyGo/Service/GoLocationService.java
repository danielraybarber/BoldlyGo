package com.tts.BoldlyGo.Service;

import java.util.List;
import java.util.Random;

import com.tts.BoldlyGo.Model.DistanceResponse;
import com.tts.BoldlyGo.Model.GeocodingResponse;
import com.tts.BoldlyGo.Model.GoLocation;
import com.tts.BoldlyGo.Model.Location;
import com.tts.BoldlyGo.Model.User;
import com.tts.BoldlyGo.Repository.GoLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoLocationService {
    @Value("${geocoding_url}")
    public String geocodingUrl;

    @Value("${distance_url}")
    public String distanceUrl;

    @Value("${google_api_key}")
    public String googleApiKey;

    @Autowired
    private GoLocationRepository goLocationRepository;

    @Autowired
    private UserService userService;

    public Location getCoordinates(String description) {
        description = description.replace(" ", "+");
        description = description.replace(",", "");
        String url = geocodingUrl + description + "&key=" + googleApiKey;
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location location = response.results.get(0).geometry.location;
        return location;
    }

    public static Location getRandomLocation(double x0, double y0, int radius) {
        Random random = new Random();
        Location location = new Location();
    
        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;
    
        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);
    
        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));
    
        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        location.setLng(String.valueOf(foundLongitude));
        location.setLat(String.valueOf(foundLatitude));
        return location;
    }

    private double getDistance(Location origin, Location destination) {
        String url = distanceUrl + "origins=" + origin.lat + "," + origin.lng + "&destinations=" + destination.lat + "," + destination.lng + "&key=" + googleApiKey;
        RestTemplate restTemplate = new RestTemplate();
        DistanceResponse response = restTemplate.getForObject(url, DistanceResponse.class);
        return response.rows.get(0).elements.get(0).distance.value*0.000621371;
    }

    public void saveLocation(Location location) {
        GoLocation goLocation = new GoLocation();
        goLocation.setLocation(location);
        goLocationRepository.save(goLocation);
    }

    public List<GoLocation> findAll() {
        List<GoLocation> locations = goLocationRepository.findAllByOrderByCreatedAtDesc();
        return locations;
    }

    public List<GoLocation> findAllByUser(User user) {
        List<GoLocation> locations = goLocationRepository.findAllByUserOrderByCreatedAtDesc(user);
        return locations;
    }

    public List<GoLocation> findAllByUsers(List<User> users) {
        List<GoLocation> locations = goLocationRepository.findAllByUserInOrderByCreatedAtDesc(users);
        return locations;
    }

    // public void checkIfUserReachesLocation(Location location) {
    //     User loggedInUser = userService.getLoggedInUser();
    //     Location currentLocation = new Location(); //change this to user's location
    //     List<GoLocation> userLocations = (goLocationRepository.findAllByUserOrderByCreatedAtDesc(loggedInUser));
    //     GoLocation[] locationsArray = new GoLocation[userLocations.size()];
    //     locationsArray = userLocations.toArray(locationsArray);

    //     for (int i=0; i<locationsArray.length; i++) {
    //         if (getDistance(locationsArray[i].getLocation(), currentLocation) <= 0.25) {
    //             locationsArray[i].setHasBeenReached(true);
    //         }
    //     }
    // }
}