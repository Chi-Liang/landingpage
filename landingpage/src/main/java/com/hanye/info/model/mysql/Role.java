package com.hanye.info.model.mysql;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Nationalized;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Role {

	@Id
    @Column(length = 100)
    private String rid;

    @Basic
    @Nationalized
    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
    
	public Role(String rid) {
		super();
		this.rid = rid;
	}

}
