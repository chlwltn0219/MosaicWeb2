package com.hybrid.mapper;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hybrid.MosaicWeb2Application;
import com.hybrid.domain.Dept;

public class MapperTest {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MosaicWeb2Application.class, args);
		
		try {
			
			DeptMapper mapper = ctx.getBean(DeptMapper.class);
			
			mapper.delete(55);
			/*
			 * Insert
			 */
			mapper.insert(new Dept(55, "xxx", "yyy"));
			Dept d = mapper.SelectByDeptno(55);
			System.out.println("Insert => " + d);
			List<Dept> depts = mapper.SelectAll();
			depts.forEach(dept -> {
				System.out.println(dept);
			});
			
			/*
			 * Update
			 */
			mapper.update(new Dept(55, "xxx1", "yyy1"));
			d = mapper.SelectByDeptno(55);
			System.out.println("update => " + d);
			depts = mapper.SelectAll();
			depts.forEach(dept -> {
				System.out.println(dept);
			});
			
			/*
			 * Delete
			 */
			d = mapper.SelectByDeptno(55);
			System.out.println("Delete => " + d);
			mapper.delete(55);
			depts = mapper.SelectAll();
			depts.forEach(dept -> {
				System.out.println(dept);
			});
		} finally {
			
			ctx.close();
			
		}
	}

}
