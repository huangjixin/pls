package com.zwo.pls.security.dto;

import com.zwo.pls.security.domain.Permission;
import com.zwo.pls.security.domain.Role;
import com.zwo.pls.security.domain.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 一句话描述该类功能：本类应该继承自System模块的User
 * Created by Tony(黄记新) in 2019/4/27
 */
@Data
public class UserDto extends User implements Serializable, UserDetails  {

    private List<Permission> permissions = new ArrayList<Permission>();
    private List<Role> roles = new ArrayList<Role>();
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
