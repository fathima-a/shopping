package com.wondroussoft.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wondroussoft.shopping.model.Wear;
import com.wondroussoft.shopping.model.Category;
import com.wondroussoft.shopping.model.Item;
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

	@GetMapping("/seasons/{seasonId}/wears")
	public String getWearsBySeasonId(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		List<Wear> wears = new ArrayList<Wear>();
		
		if(seasonId.equals(1L)) {
			wears.add(new Wear(1L, "Winter Specials", seasonId));
			wears.add(new Wear(2L, "Winter Specials 2", seasonId));
			wears.add(new Wear(3L, "Winter Specials 3", seasonId));
		} else if(seasonId.equals(2L)) {
			wears.add(new Wear(4L, "Summer Specials", seasonId));
			wears.add(new Wear(5L, "Summer Specials 2", seasonId));
			wears.add(new Wear(6L, "Summer Specials 3", seasonId));
		} else if(seasonId.equals(3L)) {
			wears.add(new Wear(7L, "Spring Specials", seasonId));
			wears.add(new Wear(8L, "Spring Specials 2", seasonId));
			wears.add(new Wear(9L, "Spring Specials 3", seasonId));
		} else if(seasonId.equals(4L)) {
			wears.add(new Wear(10L, "Rainy Specials", seasonId));
			wears.add(new Wear(11L, "Rainy Specials 2", seasonId));
			wears.add(new Wear(12L, "Rainy Specials 3", seasonId));
			wears.add(new Wear(13L, "Rainy Specials 4", seasonId));
		}

		map.put("wears", wears);

		return "wears";
	}


@GetMapping("/wears/{wearId}/categories")
public String getCategoryByWearId(ModelMap map, @PathVariable(name = "wearId") Long wearId) {
	List<Category> categories = new ArrayList<Category>();
	
	if(wearId.equals(1L)) {
		categories.add(new Category(1L, "TOP Wear", wearId));
		categories.add(new Category(2L, "Bottom Wear", wearId));
		categories.add(new Category(3L, "TOP Wear", wearId));
		
	} else if(wearId.equals(2L)) {
		categories.add(new Category(4L, "Bottom Wear", wearId));
		categories.add(new Category(5L, "TOP Wear", wearId));
		categories.add(new Category(6L, "BOTTOM WEAR", wearId));
		
		
	} else if(wearId.equals(3L)) {
		categories.add(new Category(7L, "TOP Wear", wearId));
		categories.add(new Category(8L, "BOTTOM WEAR", wearId));
		categories.add(new Category(9L, "TOP Wear", wearId));
		
	} else if(wearId.equals(4L)) {
		categories.add(new Category(10L, "BOTTOM WEAR", wearId));
		categories.add(new Category(11L, "TOP Wear", wearId));
		categories.add(new Category(12L, "BOTTOM WEAR", wearId));
		categories.add(new Category(13L, "TOP Wear", wearId));
		
	
	}
	map.put("categories", categories);

	return "categories";
}
@GetMapping("/categories/{categoryId}/items")
public String getitemBycategoryId(ModelMap map, @PathVariable(name = "categoryId") Long categoryId) {
	List<Item> items = new ArrayList<Item>();
	
	if(categoryId.equals(1L)) {
		items.add(new Item(1L, "Pullover",categoryId));
		items.add(new Item(2L, "Jacket ", categoryId));
		items.add(new Item(3L, "Jeans pant", categoryId));
	} else if(categoryId.equals(2L)) {
		items.add(new Item(4L, "Pullover", categoryId));
		items.add(new Item(5L, "sweatshirt", categoryId));
		items.add(new Item(6L, "Formal Trousers", categoryId));
	} else if(categoryId.equals(3L)) {
		items.add(new Item(7L, "Leather jacket", categoryId));
		items.add(new Item(8L, "Jacket ",categoryId));
		items.add(new Item(9L, "Training pants", categoryId));
	} else if(categoryId.equals(4L)) {
		items.add(new Item(10L, "Pullover", categoryId));
		items.add(new Item(11L, "Jacket ", categoryId));
		items.add(new Item(12L, "cotton Jeans",categoryId));
		items.add(new Item(13L, "cotton pants", categoryId));
	}

	map.put("items", items);

	return "items";
}
}
