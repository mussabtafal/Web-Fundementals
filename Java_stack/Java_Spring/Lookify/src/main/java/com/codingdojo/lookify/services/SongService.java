package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;


@Service
public class SongService {
	private final SongRepository songRepository;
	
	 public SongService(SongRepository songRepository) {
	        this.songRepository = songRepository;
	    }
	 
	 public List<Song> allSongs() {
	        return songRepository.findAll();
	    }
	 
	 public Song findSong(Long id) {
	        Optional<Song> optionalSong = songRepository.findById(id);
	        if(optionalSong.isPresent()) {
	            return optionalSong.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public List<Song> findSong(String artist) {
	        List<Song> artistSongs = songRepository.findByArtistContainsAllIgnoreCase(artist);
	            return artistSongs;
	    }
	 
	 public List<Song> topTen(){
			return songRepository.findTop10ByOrderByRatingDesc();
		}
	 
	 public Song createSong(Song e) {
	        return songRepository.save(e);
	    }
	    
    public void deleteSong(Long id) {
    	Song deleteSong = songRepository.findById(id).orElse(null); 
    	songRepository.delete(deleteSong);
  	}
}
