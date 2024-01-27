package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;
public interface SeoulMapper {
	
	/*
	 * CREATE OR REPLACE PROCEDURE seoulLocationData(
    pStart NUMBER,
    pEnd NUMBER,
    pResult OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN pResult FOR
    SELECT no,title,poster,msg,address,hit,num
    FROM(SELECT no,title,poster,msg,address,hit,ROWNUM as num
    FROM(SELECT no,title,poster,msg,address,hit
    FROM seoul_location ORDER BY no ASC))
    WHERE num BETWEEN pStart AND pEnd;
END;
/
	 */
	// => 파라미터맵 (IN => 매개변수 OUT => 리턴)
	@Select(value="{CALL seoulLocationData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<SeoulVO> seoulListData(Map map);
	
	/*
	 * CREATE OR REPLACE PROCEDURE seoulLocationTotalPage(
    pTotal OUT NUMBER
)
IS
BEGIN
SELECT CEIL(COUNT(*)/12.0) INTO pTotal
FROM seoul_location;
END;
/
	 */
	/*
	 * <select id="seoulLocationTotalPage" resultType="int">
 		SELECT CEIL(COUNT(*)/12.0) FROM seoul_location
 	</select>
	 */
	@Select(value="{CALL seoulLocationTotalPage(#{pTotal,mode=OUT,jdbcType=INTEGER})}")
	@Options(statementType = StatementType.CALLABLE)
	public Integer seoulTotalPage(Map map);
//	public int seoulTotalPage();

}
