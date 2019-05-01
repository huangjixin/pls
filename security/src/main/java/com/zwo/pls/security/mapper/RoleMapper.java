package com.zwo.pls.security.mapper;

import com.zwo.pls.security.domain.Role;
import com.zwo.pls.security.domain.RoleCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

}