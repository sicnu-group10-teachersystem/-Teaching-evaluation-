package sicnu.cjj.myspringboot.entity;

import java.util.List;

public class LoginInfo {
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    private List<String> authorities;

    public LoginInfo(List<String> roles, List<String> authorities) {
        this.roles=roles;
        this.authorities=authorities;
    }


}
