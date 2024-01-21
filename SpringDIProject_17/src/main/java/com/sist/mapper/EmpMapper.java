package com.sist.mapper;
import java.util.*;

import com.sist.dao.*;
/*
 * <select id="empDetailData" resultMap="empMap" parameterType="int">
 */
public interface EmpMapper {
	public List<EmpVO> empAllData();
	
	public EmpVO empDetailData(int empno);
}
