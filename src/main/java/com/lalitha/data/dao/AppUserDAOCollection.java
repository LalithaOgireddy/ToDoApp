package com.lalitha.data.dao;

import com.lalitha.model.AppUser;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AppUserDAOCollection implements AppUserDAO{

    Collection<AppUser> appUsers;

    public AppUserDAOCollection(Collection<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    @Override
    public AppUser persist(AppUser appUser) {
        AppUser newAppuser = new AppUser(appUser.getUsername(),appUser.getPassword(),appUser.getRole());
        appUsers.add(newAppuser);
        return newAppuser;
    }

    @Override
    public AppUser findByUsername(String username) {
        for(AppUser user : appUsers){
            if(user.getUsername().trim().equals(username.trim())) return user;
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return Collections.unmodifiableCollection(appUsers);
    }

    @Override
    public void remove(String username) {
        for(AppUser user : appUsers){
            if(user.getUsername().trim().equals(username.trim())) {
                appUsers.remove(user);
            }
        }
    }
}
