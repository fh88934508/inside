package com.huishou.inside.demo.entity;


import lombok.Data;

/**
 * Created by echisan on 2018/6/23
 */
@Data
public class User {
    public static final String ROLE_OPERATION="ROLE_OPERATION";
    public static final String ROLE_REPAIR="ROLE_REPAIR";
    public static final String ROLE_INSTALL="ROLE_INSTALL";
    public static final String ROLE_ADMIN="ROLE_ADMIN";
    public static final String ROLE_SUPPERADMIN="ROLE_SUPPERADMIN";

    private String id;

    private String name;
    private String username;


    private String password;

    private String role;


}
