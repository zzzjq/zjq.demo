package zjq.demo.dao;

import java.util.List;

import zjq.demo.model.Person;

/**
 * @author:zhangjq
 * @time:2017年7月25日 上午9:56:14
 * @version:v1.0
 */
public interface TestMapper {

	List<Person> seletList (Person person);

	int update (Person person);
	
	int insert (Person person);
}
