package sicnu.cjj.myspringboot.service;

public interface RoleService {
    int selectrolebyuser(int user_id);
    String selectnamebyroleid(int role_id);
}
