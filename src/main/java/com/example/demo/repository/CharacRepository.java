package com.example.demo.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Charac;

@Mapper
public interface CharacRepository {

	@Insert("""
			INSERT INTO charac
			SET regDate = NOW(),
			updateDate = NOW(),
			memberId = #{loginedMemberId}
			""")
	public void characCreation(int loginedMemberId);

	@Select("""
			SELECT C.*, W.img extra__weapon
			         FROM charac C
			         INNER JOIN weapon W
			         ON C.weaponId = W.id
			         WHERE memberId = #{loginedMemberId}
				""")
	public Charac characChack(int loginedMemberId);

	@Update("""
			UPDATE charac
			SET updateDate = NOW(),
			hp = #{hp},
			`floor` = #{floor},
			room = #{room},
			clearTime = #{clearTime}
			WHERE memberId = #{memberId}
			""")
	public void update(int hp, int floor, int room, int clearTime, int memberId);

	@Update("""
			UPDATE charac
			SET updateDate = NOW(),			
			weaponId = #{weaponId}
			WHERE memberId = #{memberId}
			""")
	public void weaponChange(int memberId, int weaponId);

	@Update("""
			UPDATE charac
			SET updateDate = NOW(),
			`floor` = 1,
			room = 0,
			hp = 100,
			`power` = 0,
			speed = 50,
			weaponId = 1,
			clearTime = 0
			WHERE memberId = #{memberId}
			""")
	public void reset(int memberId);

	@Update("""
			<script>
			UPDATE charac
			SET updateDate = NOW(),
			<if test="ability == 1">
			`power` = #{point}
			</if>
			<if test="ability == 2">
			speed = #{point}
			</if>
			WHERE memberId = #{memberId}
			</script>
			""")
	public void itemGet(int memberId, int ability, int point);
}