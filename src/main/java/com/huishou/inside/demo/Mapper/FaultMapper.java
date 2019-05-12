package com.huishou.inside.demo.Mapper;

import com.huishou.inside.demo.bean.BeanBadList;
import com.huishou.inside.demo.bean.BeanBadRecode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FaultMapper {
    @Select("select * from all_bad_list")
    List<BeanBadList> getBadList();
    @Select("select t.* from dbs_malfunction t where t.ah_id=#{ah_id} order by t.malfunction_time desc limit 10")
    List<BeanBadRecode> getFaultRecord(@Param("ah_id") String ah_id);
}
