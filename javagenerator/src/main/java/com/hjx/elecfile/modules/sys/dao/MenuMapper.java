package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.Menu;
import com.hjx.elecfile.modules.sys.domain.MenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    long countByExample(MenuCriteria example);

    int deleteByExample(MenuCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuCriteria example);

    Menu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}