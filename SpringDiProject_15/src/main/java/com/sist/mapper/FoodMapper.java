package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

/*
 * name => N
 * address => A
 * type => T
 * 
 * name + address => NA
 * name + type => NT
 * address + type => AT
 * name + address + type => NAT
 * 
 * prefix=\"OR\ => OR 앞에 붙여줌
 * if(ss=='N')
 * OR name LiKE ~
 * else if(ss=='A')
 * OR address LIKE ~
 * else if(ss=='T')
 * OR type LIKE ~
 * 
 * => NT => OR name LiKE ~ OR type LIKE ~
 * 		   === 제거해줘야됨
 *         => prefixOverrides=\"OR\"
 */
import java.util.*;
// OR (name LIKE '%'||#{ss}||'%') OR (address LIKE '%'||#{ss}||'%') 
// => 가장 앞에 있는 OR 지워줘야됨 =>  prefixOverrides=\"OR\"
// => 뒤에 있는 문자 제거 => suffixOverrides
// <foreach collection=\"fsArr\" item=\"fd\">"
// => for(String fd:fsArr)
public interface FoodMapper {
@Select("<script>"
		+"SELECT fno,name,type,address "
		+"FROM food_menu_house "
		+"WHERE "
		+"<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">" 
		+"<foreach collection=\"fsArr\" item=\"fd\">" 
		+"<trim prefix=\"OR\">" 
		+"<choose>"
		+"<when test=\"fd=='N'.toString()\">" 
		+"name LIKE '%'||#{ss}||'%'" 
		+"</when>"
		+"<when test=\"fd=='A'.toString()\">" 
		+"address LIKE '%'||#{ss}||'%'" 
		+"</when>"
		+"<when test=\"fd=='T'.toString()\">" 
		+"type LIKE '%'||#{ss}||'%'" 
		+"</when>" 
		+"</choose>" 
		+"</trim>" 
		+"</foreach>" 
		+"</trim>" 
		+"</script>"
		)
public List<FoodVO> foodFindData(Map map);
}
