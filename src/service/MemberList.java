/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import model.Member;

/**
 *
 * @author SR
 */
public class MemberList {

    private static HashMap<Integer, Member> memberMap;

    public void addMember(Member member) {
        memberMap.put(member.getId(), member);
    }

    public void deleteMember(Member member) {
        memberMap.remove(member.getId());
    }

    public Member findById(int id) {
        return memberMap.get(id);
    }

    public Member findByName(String name) {
        for (Integer i : memberMap.keySet()) {
            if (memberMap.get(i).getName().equals(name)) {
                return memberMap.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MemberList{" + "memberMap=" + memberMap + '}';
    }

    public HashMap<Integer, Member> getMemberMap() {
        return memberMap;
    }

    public void setMemberMap(HashMap<Integer, Member> memberMap) {
        this.memberMap = memberMap;
    }

    public MemberList(HashMap<Integer, Member> memberMap) {
        this.memberMap = memberMap;
    }

    public MemberList() {
        memberMap = new HashMap();
    }

}
