package com.zwo.pls.security.mapper;

import com.zwo.pls.security.domain.RolePermission;
import com.zwo.pls.security.domain.RolePermissionCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RolePermissionMapper extends Mapper<RolePermission> {

}