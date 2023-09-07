package com.example.AgenceImmobilier.converter;

import com.example.AgenceImmobilier.DTOs.response.LogementDto;
import com.example.AgenceImmobilier.models.logement.Logement;
import com.example.AgenceImmobilier.services.logementS.LogementService;
import com.example.AgenceImmobilier.services.user.UserService;
import com.example.AgenceImmobilier.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogementConverter {

    @Autowired
    private UserService userService;
    private static UserService userServiceStatic;

    @Autowired
    public void setStatic(){
        this.userServiceStatic=userService;
    }

    public static LogementDto convertToDto(Logement logement){

        LogementDto logementDto = new LogementDto();

        logementDto.setId(logement.getId());
        logementDto.setTitle(logement.getTitle());

        logementDto.setType(logement.getType());
        logementDto.setNumOfBeds(logement.getNumOfBeds());
        logementDto.setNumOfWc(logement.getNumOfWc());
        logementDto.setNumOfRooms(logement.getNumOfRooms());
        logementDto.setLivingRoom(logement.isLivingRoom());
        logementDto.setSquareFootage(logement.getSurface());

        logementDto.setDescription(logement.getDescription());

        logementDto.setSmoking(logement.isSmoking());
        logementDto.setAnimals(logement.isAnimals());
        logementDto.setParties(logement.isParties());
        logementDto.setMinRentDays(logement.getMinRentDays());
        logementDto.setMaxGuests(logement.getMaxGuests());

        logementDto.setLatitude(logement.getLatitude());
        logementDto.setLongitude(logement.getLongitude());
        logementDto.setCountry(logement.getCountry());
        logementDto.setCity(logement.getCity());
     //   logementDto.setNeighborhood(logement.getNeighborhood());
        logementDto.setAddress(logement.getAddress());
        logementDto.setPostalCode(logement.getPostalCode());
      //  logementDto.setTransportation(logement.getTransportation());

        logementDto.setMinCost(logement.getMinCost());
        logementDto.setCostPerExtraGuest(logement.getCostPerExtraGuest());

        logementDto.setWifi(logement.isWifi());
        logementDto.setAc(logement.isAc());
        logementDto.setHeating(logement.isHeating());
        logementDto.setKitchen(logement.isKitchen());
        logementDto.setTv(logement.isTv());
        logementDto.setParking(logement.isParking());
        logementDto.setElevator(logement.isElevator());

        logementDto.setStartDate(logement.getStartDate());
        logementDto.setEndDate(logement.getEndDate());

       // logementDto.setAverageRating(logement.getAverageRating());
       // logementDto.setNumOfReviews(logement.getNumOfReviews());

        logementDto.setHost(UserConvert.convertToDto(logement.getHost()));

       // List<ReviewDto> reviewDtoList = listing.getReviews().stream().map(ReviewConverter::convertToDto).collect(Collectors.toList());
        //List<BookingDto> bookingDtoList = listing.getBookings().stream().map(BookingConverter::convertToDto).collect(Collectors.toList());
       // List<ImageDto> imageDtoList = listing.getImages().stream().map(ImageConverter::convertToDto).collect(Collectors.toList());

        //listingDto.setReviews(reviewDtoList);
        //listingDto.setBookings(bookingDtoList);
        //listingDto.setImages(imageDtoList);

        return logementDto;
    }

    public static Logement convert(LogementDto logementDto){

        Logement logement = new Logement();

        logement.setId(logementDto.getId());
        logement.setTitle(logementDto.getTitle());

        logement.setType(logementDto.getType());
        logement.setNumOfBeds(logementDto.getNumOfBeds());
        logement.setNumOfWc(logementDto.getNumOfWc());
        logement.setNumOfRooms(logementDto.getNumOfRooms());
        logement.setLivingRoom(logementDto.isLivingRoom());
        logement.setSurface(logementDto.getSquareFootage());

        logement.setDescription(logementDto.getDescription());

        logement.setSmoking(logementDto.isSmoking());
        logement.setAnimals(logementDto.isAnimals());
        logement.setParties(logementDto.isParties());
        logement.setMinRentDays(logementDto.getMinRentDays());
        logement.setMaxGuests(logementDto.getMaxGuests());

        logement.setLatitude(logementDto.getLatitude());
        logement.setLongitude(logementDto.getLongitude());
        logement.setCountry(logementDto.getCountry());
        logement.setCity(logementDto.getCity());
      //  logement.setNeighborhood(listingDto.getNeighborhood());
        logement.setAddress(logementDto.getAddress());
        logement.setPostalCode(logementDto.getPostalCode());
       // logement.setTransportation(listingDto.getTransportation());

        logement.setMinCost(logementDto.getMinCost());
        logement.setCostPerExtraGuest(logementDto.getCostPerExtraGuest());

        logement.setWifi(logementDto.isWifi());
        logement.setAc(logementDto.isAc());
        logement.setHeating(logementDto.isHeating());
        logement.setKitchen(logementDto.isKitchen());
        logement.setTv(logementDto.isTv());
        logement.setParking(logementDto.isParking());
        logement.setElevator(logementDto.isElevator());

        logement.setStartDate(logementDto.getStartDate());
        logement.setEndDate(logementDto.getEndDate());

        //logement.setAverageRating(listingDto.getAverageRating());
       // logement.setNumOfReviews(listingDto.getNumOfReviews());


        logement.setHost(userServiceStatic.findById(logementDto.getHost().getId()));

       /* if(listingDto.getReviews() == null)
            listing.setReviews(new ArrayList<Review>());
        else {
            List<Review> reviewList = listingDto.getReviews().stream().map(ReviewConverter::convert).collect(Collectors.toList());
            listing.setReviews(reviewList);
        }*/

        /*if(listingDto.getBookings() == null)
            listing.setBookings(new ArrayList<Booking>());
        else {
            List<Booking> bookingList = listingDto.getBookings().stream().map(BookingConverter::convert).collect(Collectors.toList());
            listing.setBookings(bookingList);
        }*/

       /* if(listingDto.getImages() == null)
            listing.setImages(new ArrayList<Image>());
        else {
            List<Image> imageList = listingDto.getImages().stream().map(ImageConverter::convert).collect(Collectors.toList());
            listing.setImages(imageList);
        }
*/
        return logement;
    }
}
