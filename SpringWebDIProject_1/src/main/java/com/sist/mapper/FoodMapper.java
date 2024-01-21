package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface FoodMapper {
@Select("SELECT fno,poster,name,num "
		+ "FROM (SELECT fno,poster,name,ROWNUM as num "
		+ "FROM (SELECT fno,poster,name "
		+ "FROM food_menu_house ORDER BY fno ASC)) "
		+ "WHERE num BETWEEN #{start} AND #{end}")
public List<FoodVO> foodListData(Map map);

@Select("SELECT CEIL(COUNT(*)/12) FROM food_menu_house")
public int foodTotalPage();
}
