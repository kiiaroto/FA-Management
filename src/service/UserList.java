/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import model.User;

/**
 *
 * @author SR
 */
public class UserList {
    private static HashMap<Integer, User> memberMap;
    
    public void addMember(User user) {
        memberMap.put(user.getId(), user);
    }
    
    public void deleteMember(User user) {
        memberMap.remove(user.getId());
    }
    
    public User findById(int id) {
        return memberMap.get(id);
    }
    
    public User findByName(String name) {
        for (Integer i : memberMap.keySet()) {
            if (memberMap.get(i).getName().equals(name)){
                return memberMap.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MemberList{" + "memberMap=" + memberMap + '}';
    }

    public HashMap<Integer, User> getMemberMap() {
        return memberMap;
    }

    public void setMemberMap(HashMap<Integer, User> memberMap) {
        this.memberMap = memberMap;
    }

    public UserList(HashMap<Integer, User> memberMap) {
        this.memberMap = memberMap;
    }

    public UserList() {
        memberMap = new HashMap();
    }
}
