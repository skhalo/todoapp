package com.letuku.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TodoUserTable")
@Data
@NamedQuery(name = TodoUser.FIND_TO_DO_BY_EMAIL , query = "select tU from TodoUser tU where tU.email = :email")
@NamedQuery(name = TodoUser.FIND_ALL_USERS, query = "select tU from TodoUser tU order by tU.fullName")
@NamedQuery(name = TodoUser.FIND_BY_ID, query = "select tU from TodoUser tU where tU.id = :id")
@NamedQuery(name = TodoUser.FIND_BY_NAME, query = "select tU from TodoUser tU where tU.fullName like :name")
public class TodoUser extends AbstractEntity{

    public static final String FIND_TO_DO_BY_EMAIL = "TodoUser.findByEmail";
    public static final String FIND_ALL_USERS = "TodoUser.findAllUsers";
    public static final String FIND_BY_ID = "TodoUser.findById";
    public static final String FIND_BY_NAME = "TodoUser.findByName";

    @Column(length = 100)
    @NotEmpty(message = "An email must be set")
    @Email(message = "Email must be in the format user@somedomain.com")
    private String email; //varchar 255 user@domain.com


    @NotNull(message = "Password cannot be empty")
    @Size(min = 8, max = 100, message = "Password must be a min of 8 and max of 100 characters")
//@Pattern(regexp = "", message = "Password must have at least one upper case, " +
//        "one lower case, a digit and must contain at least one of $%&#!")
    private String password; //#%AdhhddS87987fjvjof


    @NotEmpty(message = "Name must be set")
    @Size(min = 2, max = 100, message = "Name must be a min of 2 and max of 100 characters")
    private String fullName;
}
