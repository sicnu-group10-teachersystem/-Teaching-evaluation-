package sicnu.cjj.myspringboot.entity;

import lombok.Data;

@Data
public class Authority {
    private int authority_id;
    private String authority_name;
    private String authority_url;
    private String parent;

    public int getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(int authority_id) {
        this.authority_id = authority_id;
    }

    public String getAuthority_name() {
        return authority_name;
    }

    public void setAuthority_name(String authority_name) {
        this.authority_name = authority_name;
    }

    public String getAuthority_url() {
        return authority_url;
    }

    public void setAuthority_url(String authority_url) {
        this.authority_url = authority_url;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
