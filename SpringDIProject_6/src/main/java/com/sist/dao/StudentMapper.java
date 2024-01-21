package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// => MapperFactoryBean
/*
 *  1. <select> ==> @select()
 *  2. id ==> 메소드명
 *  3. resultType ==> return형
 *  4. parameterType  ==> 매개변수
 *  
 *  public List<EmpVO> empListData();
	       resultType    id      parameterType
 */
import java.util.*;
public interface StudentMapper {
	@Select("SELECT * FROM student") 
	public List<StudentVO> studentListData();
	/*
	 * <select id="studentDetailData" resultType="StudentVO" parameterType="int">
	 */
	@Select("SELECT * FROM student WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	/*
	 * <insert id="studentInsert" parameterType="StudentVO">
	 * INSERT INTO student VALUES(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})
	 * </insert>
	 */
	
	@Insert("INSERT INTO student VALUES(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})") 
	public void studentInsert(StudentVO vo);
	
	/*
	 * <delete id="studentDelete" parameterType="int">
	 * DELETE FROM student WHERE hakbun=#{hakbun}
	 * </delete>
	 */
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	/*
	 * <update id="studentUpdate" parameterType="StudentVO">
	 *  UPDATE student SET name=#{name},kor=#{kor},eng=#{eng},math=#{math} WHERE hakbun
	 * 							=======> vo.getname
	 *  </update> 
	 */
	// type="클래스명"(class) property="변수명" => p:
	// Class.forName() => setXxxx()
	@Update("UPDATE student SET name=#{name},kor=#{kor},eng=#{eng},math=#{math} WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
}
