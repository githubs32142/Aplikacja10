package pl.techstyle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Ksiazka")
@Data
@NoArgsConstructor
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ksiazki")
	private int id;
	@Column(name="Nazwa_ksiazki")
	private String title;
	
	@ManyToMany(mappedBy="books")
	List<Author> authors= new ArrayList<>();
}
