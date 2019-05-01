package com.wondroussoft.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wondroussoft.shopping.model.Season;

@Controller
public class ShoppingController {

	@GetMapping("/seasons")
	public String getSeasons(ModelMap map) {
		List<Season> seasons = new ArrayList<Season>();

		Season season = new Season(1L, "Winter");

		seasons.add(season);
		season = new Season(2L, "Summer");

		seasons.add(season);
		season = new Season(3L, "Spring");

		seasons.add(season);
		season = new Season(4L, "Rainy");

		seasons.add(season);

		map.put("seasons", seasons);

		return "seasons";
	}

	@GetMapping("/seasons/{seasonId}")
	public String getSeasons(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Season season = new Season();
		
		if(seasonId.equals(1L)) {
			season.setId(1L);
			season.setName("Winter");
		} else if(seasonId.equals(2L)) {
			season.setId(2L);
			season.setName("Summer");
		} else if(seasonId.equals(3L)) {
			season.setId(3L);
			season.setName("Spring");
		} else if(seasonId.equals(4L)) {
			season.setId(4L);
			season.setName("Rainy");
		}

		map.put("season", season);

		return "seasons_details";
	}

	@GetMapping("/bye")
	public String bye(ModelMap map) {
		map.put("message", "GOOD BYE. Meet you soon!!!");
		return "bye";
	}
}
