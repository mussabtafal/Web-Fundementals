package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
		List<Song> findAll();
		List<Song> findTop10ByOrderByRatingDesc();
		List<Song> findByArtistContainsAllIgnoreCase(String search);
	}


