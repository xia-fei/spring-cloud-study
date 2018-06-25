package org.xiafei.spring.cloud.nosql.datasource.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmployeeMapper {

	@Select("select Id id,Name name,Salary salary,DepartmentId departmentId from Employee ")
	List<Employee> selectAll();

}