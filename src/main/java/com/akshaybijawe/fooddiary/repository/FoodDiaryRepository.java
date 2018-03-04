package com.akshaybijawe.fooddiary.repository;

import com.akshaybijawe.fooddiary.domain.FoodDiary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author arbijawe on 3/4/18
 * @project fooddiary
 */

public interface FoodDiaryRepository extends JpaRepository<FoodDiary, Long> {
}
