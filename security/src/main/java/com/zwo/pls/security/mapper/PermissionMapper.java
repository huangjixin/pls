package com.zwo.pls.security.mapper;

import com.zwo.pls.security.domain.Permission;
import com.zwo.pls.security.domain.PermissionCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

}