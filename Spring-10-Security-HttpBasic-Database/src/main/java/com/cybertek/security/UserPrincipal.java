package com.cybertek.security;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {  // name does not matter it can be anyname "UserPrincipal"

    // we can say this is the template for security

    private  User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // In my table there are role and permission
        // In this part we are saying Security part which one is role which one is permission
        List<GrantedAuthority> authorityList=new ArrayList<>();

        // Extract List of Permissions
        // converting authorities to user Details
        user.getPermissionList().forEach(p->{
            GrantedAuthority authority= new SimpleGrantedAuthority(p);
            authorityList.add(authority);

        });

        // Extract List of Roles
        // converting roles to user Details
        user.getRoleList().forEach(r->{
            GrantedAuthority authority= new SimpleGrantedAuthority("ROLES_"+r);  // This is namingConvention for ROLES
            authorityList.add(authority);

        });

        return authorityList;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
