package com.hpugs.commons.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hpugs.commons.entity.BaseEntity;
import com.hpugs.commons.util.PageHelper;

/**
 * 
 * @author fux
 * @Description: IBaseService 基础 service 接口
 * @date 2017年6月3日 上午10:06:53
 * @param <T>
 */
public interface IBaseService<T extends BaseEntity> {
	/**
	 * 保存或者修改。
	 * 
	 * @param obj
	 *            传入实体javabean
	 * @return 新的实体javabean
	 */
	public Object saveOrUpdateObject(Object obj);

	/**
	 * 删除。
	 * 
	 * @param id
	 *            传入ID
	 * @return 真假，是否删除
	 */
	public boolean deleteObjectById(String id);

	/**
	 * 删除。
	 * 
	 * @param params
	 *            传入条件
	 * @return 真假，是否删除
	 */
	public boolean deleteObjectByParams(String params);

	/**
	 * 根据id返回一条数据。
	 * 
	 * @param id
	 *            传入ID
	 * @return 新的实体javabean
	 */
	public Object getObjectById(String id);

	/**
	 * 根据SQL语句返回一条数据。
	 * 
	 * @param params
	 *            传入条件
	 * @return 新的实体javabean
	 */
	public Object getObjectByParams(String params);

	/**
	 * 查询最大行数。
	 * 
	 * @param params
	 *            传入条件
	 * @return 整数行数。
	 */
	public Integer getCount(String params);

	/**
	 * 查询最大行数自定义SQL。
	 * 
	 * @param params
	 *            传入条件
	 * @return 整数行数。
	 */
	public Integer getCountByHQL(String hql);

	/**
	 * 通过HQL语句以及字段投影查询
	 */
	public List findObjectsByHQL(String[] selectColumns, PageHelper pageHelper, String hql);

	/**
	 * 通过HQL
	 */
	public List findObjectsByHQL(String[] selectColumns, String hql, int limit);

	/**
	 * 通过HQL
	 */
	public List findObjectsByHQL(String[] selectColumns, String hql);

	/**
	 * 通过HQL
	 */
	public List findObjectsByHQL(String hql);

	/**
	 * 根据SQL语句返回多条数据。
	 * 
	 * @param pageHelper
	 *            传入分页
	 * @param params
	 *            传入条件
	 * @return 多个表的集合
	 */
	public List findListByPageHelperManyTable(PageHelper pageHelper, String params);

	/**
	 * 查询多个表记录数量
	 * 
	 * @param
	 * @return
	 */
	public Integer getCountManyTable(String params);

	/**
	 * 按列批量删除，o.key = ids 查找删除。
	 * 
	 * @param key
	 *            传入某一列
	 * @param ids
	 *            传入ID，可以是串：13,506,102
	 * @return 新的实体javabean集合
	 */
	public boolean deleteObjectsByIds(String key, String ids);

	/**
	 * 查询所有。
	 * 
	 * @param params
	 *            传入条件
	 * @return 新的实体javabean集合
	 */
	public List<T> findObjects(String params);

	/**
	 * @author leisure
	 * @param params
	 *            传入条件
	 * @return 新的实体javabean集合
	 */
	public List<T> findObjectsByCollections(String params, Collection collections);

	/**
	 * 查询所有。
	 * 
	 * @param params
	 *            传入条件
	 * @return 真假，是否删除
	 */
	public List findObjects(String[] selectColumns, String params);

	/**
	 * 获取list<map>集合
	 * 
	 * @param sql自定义sql
	 *            语句
	 * @return返回结果为list<map>
	 */
	public List<Map> findListMapByHql(String sql);

	/**
	 * 获取List<Map<String,Object>>集合
	 * 
	 * @param sql自定义sql
	 *            语句
	 * @return返回结果为list<map>
	 */
	public List<Map<String, Object>> findListMapByHql2(String hql);

	/**
	 * 获取List<Map<String,Object>>集合
	 * 
	 * @param hql
	 * @param firstIndex
	 * @param maxResult
	 * @return
	 */
	public List<Map<String, Object>> findSomeListMapByHql2(String hql, int firstIndex, int maxResult);

	/**
	 * 根据SQL语句返回多条数据。
	 * 
	 * @param pageHelper
	 *            传入分页
	 * @param params
	 *            传入条件
	 * @return 新的实体javabean集合
	 */
	/*
	 * public List findListByPageHelper(PageHelper pageHelper, String params);
	 */
	/**
	 * 根据SQL语句返回多条数据。
	 * 
	 * @param selectColumns投影的字段数组
	 * @param pageHelper
	 *            传入分页
	 * @param params
	 *            传入条件
	 * @return 新的实体javabean集合
	 */
	public List<T> findListByPageHelper(String[] selectColumns, PageHelper pageHelper, String params);

	/**
	 * 获取list<map>集合 自定义Hql 语句，返回结果为list<map>
	 * 
	 * @param Hql
	 * @return
	 * @author
	 */
	public List<Map> findListMapPage(String hql, PageHelper pageHelper);

	/**
	 * 获取多表联合查询的数据总数 自定义Hql 语句，返回结果为int总数
	 * 
	 * @param Hql
	 * @return
	 * @author
	 */
	public int getMultilistCount(String hql);

	/**
	 * 根据一个列查询最大数据
	 * 
	 * @author 刘青松
	 */
	public T getMaxData(String column, String whereCondition);


	/**
	 * 根据一个列的所有数据，去重复
	 * 
	 * @author 刘青松
	 */
	public List<T> findUnDistinctList(String column, String params);

	/**
	 * 获取一些数据 firstIndex 开始索引 maxResult 需要获取的最大记录数 params where 条件参数
	 */
	public List<T> findSome(int firstIndex, int maxResult, String whereCondition);
	
	/**
	 * 获取一条随机记录
	 * 
	 * @param whereCondition
	 * @return
	 */
	public T getRandomObject(String whereCondition);

	/**
	 * 获取查询的数据总数(多表，单表都可以) 自定义Hql 语句，返回结果为int总数
	 * 
	 * @param Hql
	 * @return
	 * @author modle :select count(a.id) from table a
	 */
	public int getMoreTableCount(String hql);

	/**
	 * 获取list<map>集合 自定义Hql 语句，返回结果为list<map>
	 * 
	 * @param Hql
	 * @return
	 * @author
	 */
	public List<Map<String, Object>> findListMapBySql(String sql);

	/**
	 * 获取list<map>集合 自定义Hql 语句，返回结果为list<map>
	 * 
	 * @param sql
	 * @return
	 * @author
	 */
	public List<Map<String, Object>> findListMapPageBySql(String sql, PageHelper pageHelper);

	/**
	 * 获取指定条数数据 selectColumns：投影字段 beginIndex：开始索引 endIndex：结束索引 where：条件语句
	 * 
	 * @author mqr
	 * @return List 指定条数的集合
	 */
	public List<?> findListSpecifiedNumber(String[] selectColumns, Integer beginIndex, Integer endIndex, String where);

	/**
	 * 通过占位符的方式进行查询一个分页集合
	 * 
	 * @param whereHQL
	 *            条件语句
	 * @param paramsMap
	 *            参数Map
	 * @param sortParam
	 *            排序字段
	 * @return List
	 */
	public List<T> findListByParamsMap(String selectColumns[], PageHelper pageHelper, String whereHQL,
			Map<Object, Object> paramsMap, String sortParam);

	/**
	 * 通过占位符的方式进行查询一个对象
	 * 
	 * @param whereHQL
	 *            条件语句
	 * @param paramsMap
	 *            参数Map
	 * @param sortParam
	 *            排序字段
	 * @return T
	 */
	public T findObjectByParamsMap(String selectColumns[], String whereHQL, Map<Object, Object> paramsMap);
	/**
	 * 
	  *  @Description  通过主键批量更新field值
	  *  @param fieldKey 待更新field域
	  *  @param fieldValue 待更新field值
	  *  @param pkName 主键名字
	  *  @param values 值的集合,以','分隔
	  *  @return
	  *
	  *  @author  付雄
	  *  @version  1.0
	  *  @date  创建时间：2017年7月5日  下午4:18:34
	 */
	public boolean updateObjectsFieldByPK(String fieldKey,String fieldValue,String pkName,String values);
	/**
	 * 
	  *  @Description  通过主键更新某行数据的指定列的值
	  *  @param input Map类型,key需要修改的字段,value要修改的值
	  *  @param pkName 主键的名字,例如id
	  *  @param pkValue 主键的具体值
	  *  @return
	  *
	  *  @author  付雄
	  *  @version  1.0
	  *  @date  创建时间：2017年7月20日  上午10:20:12
	 */
	public boolean updateFieldsByPK(Map<String, String> input, String pkName, String pkValue);
	
	public boolean updateFieldsForMany(Map<String, String> input, String whereHql);
}
