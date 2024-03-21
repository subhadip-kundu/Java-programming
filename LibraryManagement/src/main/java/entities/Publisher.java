package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Publisher_ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

	public Publisher() {
		super();
	}

	public Publisher(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
