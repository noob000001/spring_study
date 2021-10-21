package com.kh.spring.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.spring.member.model.dto.Member;

@Mapper
public interface MybatisRepository {

   @Select("select password from member where user_id = #{userId}")
   String selectPasswordByUserId(String userId);
   
   @Select("select * from member where user_id = #{userId}")
   Member selectMemberByUserId(String userId);
   
   @Select("select * from member inner join rent_master using(user_id) where user_id = #{userId}")
   List<Map<String,Object>> selectRentAndMemberByUserId(String userId);
   
   @Select("select user_id, rm_idx, rb_idx, rent_book_cnt, bk_idx, rentable_date from member inner join rent_master using(user_id)\r\n"
		   + " inner join rent_book using(rm_idx) where user_id = #{userId} ")
   List<Map<String,Object>> selectRentBookByUserId(String userId);
   
   @Select("insert into member(user_id, password, tell, email) values(#{userId},#{password},#{tell},#{email})")
   Member insertWithDto(String member);
   
   
   
   
   
   
   
   
   
}