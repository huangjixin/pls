package com.zwo.pls.modules.system.vo;

import com.zwo.pls.modules.system.domain.Permission;
import com.zwo.pls.modules.system.domain.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/5/4
 */
@Data
public class PermissionVo extends Permission  implements Serializable {
    private static final long serialVersionUID = 1L;
}
