package com.akshaybijawe.fooddiary.controllers;

import com.akshaybijawe.fooddiary.domain.FoodDiary;
import com.akshaybijawe.fooddiary.repository.FoodDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author arbijawe on 3/4/18
 * @project fooddiary
 */

@Controller
public class RootController {

    @Autowired
    private FoodDiaryRepository foodDiaryRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String rootMapping (ModelMap model){
        model.put("foodDiary", new FoodDiary());
        return "foodDiary";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String rootMappingPost(@ModelAttribute FoodDiary foodDiary, ModelMap model){

        foodDiaryRepository.save(foodDiary);

        model.put("foodDiary",new FoodDiary());

        return "redirect:/";
    }


    @RequestMapping(value="food-diaries/{foodDiaryId}", method=RequestMethod.GET)
    public String getFoodDiaryItem (@PathVariable Long foodDiaryId, ModelMap model)
    {
        FoodDiary foodDiaryItem = foodDiaryRepository.findOne(foodDiaryId);

        model.put("foodDiary", foodDiaryItem);

        return "foodDiary";
    }
}
