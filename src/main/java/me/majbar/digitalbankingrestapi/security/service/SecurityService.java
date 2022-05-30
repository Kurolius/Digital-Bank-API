package me.majbar.digitalbankingrestapi.security.service;

import me.majbar.digitalbankingrestapi.security.entities.AppRole;
import me.majbar.digitalbankingrestapi.security.entities.AppUser;

import java.util.List;

public interface SecurityService {

    AppUser addNewUser( AppUser appUser);
    AppRole addNewRole( AppRole appRole);
    void addRoleToUser( String username, String roleName);
    AppUser loadUserByUsername( String username);
    List<AppUser> listUsers();
}
