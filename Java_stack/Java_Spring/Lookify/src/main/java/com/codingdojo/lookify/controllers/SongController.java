package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;


@SpringBootApplication
@Controller
public class SongController {
	@Autowired
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	@RequestMapping("/")
    public String Landing() {
        return "Landing.jsp";
    }
	
	@GetMapping("/dashboard")
    public String newLanguage(@ModelAttribute("songArtist") Song song, Model model) {
		List<Song> AllSongs = songService.allSongs(); 
		model.addAttribute("songs", AllSongs);
        return "Dashboard.jsp";
    }
	
	@RequestMapping("search/topten")
	public String topTen(Model model) {
		List<Song> top = songService.topTen();
		model.addAttribute("songs",top);
		return "TopTen.jsp";
		
	}
	
	@PostMapping ("/search")
	public String search(@ModelAttribute("songArtist") Song song) {
		return"redirect:/search/"+song.getArtist();
	}
	
	@GetMapping("/search/{artist}")
    public String result(@ModelAttribute("songArtist") Song song, @PathVariable("artist") String artist, Model model) {
		List<Song> artistSongs = songService.findSong(artist); 
		model.addAttribute("songs", artistSongs);
		model.addAttribute("artist", artist);
        return "Search.jsp";
    }
	
	@GetMapping("/songs/new")
    public String addForm(@ModelAttribute("song") Song song) {
        return "AddForm.jsp";
    }

    @PostMapping("/songs/new")
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "AddForm.jsp";
        } else {
        	songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @GetMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "showSong.jsp";
    }
    
    
    @DeleteMapping("/dashboard/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
