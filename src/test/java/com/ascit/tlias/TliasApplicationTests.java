package com.ascit.tlias;

import com.ascit.tlias.entity.Dept;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class TliasApplicationTests {
@Autowired
private serviceTest serviceTest;
	@Test
	void contextLoads() {
		QueryWrapper<Dept> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.eq("name","就业部");
		QueryWrapper<Dept> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.like("name","部");
		serviceTest.list(queryWrapper2).forEach(System.out::println);
		QueryWrapper<Dept> queryWrapper3 = new QueryWrapper<>();
queryWrapper3.like("name","部").and(query->query.ge("update_time",LocalDateTime.parse("2024-09-25T09:47:40")).or().lt("update_time",LocalDateTime.parse("2025-04-03T18:23:59")));
		QueryWrapper<Dept> queryWrapper4 = new QueryWrapper<>();
		queryWrapper4.orderByAsc("update_time");

serviceTest.list(queryWrapper3).forEach(System.out::println);
		List<Dept> depts=serviceTest.list(queryWrapper1);
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		serviceTest.list(queryWrapper4).forEach(System.out::println);
		serviceTest.list(queryWrapper3).forEach(System.out::println);

	}

}
