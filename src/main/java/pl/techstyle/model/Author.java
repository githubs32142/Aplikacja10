package pl.techstyle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Autor")
@Data
@NoArgsConstructor
public class Author  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_autora")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Imie")
	String name;
	@Column(name="Nazwisko")
	String surName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Autor_Ksiazka", joinColumns = @JoinColumn(name = "id_autora"), inverseJoinColumns = @JoinColumn(name = "id_ksiazki"))
	List<Book> books= new ArrayList<>();
	
}
