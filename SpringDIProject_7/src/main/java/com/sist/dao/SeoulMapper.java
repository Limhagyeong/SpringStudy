package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
	@Select("SELECT no,title FROM seoul_nature ORDER BY no ASC")
	public List<SeoulVO> seoulListData();
	
	@Select("SELECT no,title,address,msg FROM seoul_nature WHERE no=#{no}")
	public SeoulVO seoulDetailData(int no);
	
	@Select("SELECT no,title,address,msg FROM seoul_nature WHERE title LIKE '%'||#{title}||'%'")
	public List<SeoulVO> seoulFindData(String title);
}
