package com.hanye.info.model.mysql;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class User {
	
	@Id
	@Column(length = 15)
	private String uid;
	
	@Column(length = 100)
	private String pwd;
	
	@Basic
    @Nationalized
    @Column(length = 50)
	private String name;
	
	@CreatedDate
	private Date createDate;
	
	@LastModifiedDate
    private Date updateDate;

	@ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "UserRole",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "uid"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "rid"))
	private Set<Role> roles = new HashSet<Role>();

}
