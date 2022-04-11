package com.codingdojo.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.waterbnb.models.Listing;
import com.codingdojo.waterbnb.repositories.ListingRepository;

@Service
public class ListingService {
	private final ListingRepository listingRepository;

	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}
	
	public List<Listing> allListings(){
        return listingRepository.findAll();
    }

    public List<Listing> containAddress(String txtsearch){
        return listingRepository.findByAddressContaining(txtsearch);
    }

    public Listing findListingtById(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if(optionalListing.isPresent()) {
            return optionalListing.get();
        } else {
            return null;
        }
    }


    public Listing createListing (Listing listing) {
        return listingRepository.save(listing);
    }

    public Listing updateListing (Listing listing) {
        Listing oldListing =listingRepository.findById(listing.getId()).orElse(null);
        oldListing.setAddress(listing.getAddress());
        oldListing.setDescription(listing.getDescription());
        oldListing.setCost(listing.getCost());
        oldListing.setPoolSize(listing.getPoolSize());
        return listingRepository.save(listing);
    }
	
}
