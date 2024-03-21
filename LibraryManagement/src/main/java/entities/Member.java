package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "Member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Memb_id")
	private int id;

	@Column(name = "Name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "Memb_type")
	private MemberType memberType;

	@Column(name = "Address")
	private String address;

	@Column(name = "Expiry_date")
	private LocalDate expiryDate;

	public Member() {
		super();
	}

	public Member(String name, MemberType memberType, String address, LocalDate expiryDate) {
		super();
		this.name = name;
		this.memberType = memberType;
		this.address = address;
		this.expiryDate = expiryDate;
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

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate() {
		LocalDate joinDate = LocalDate.now();
		Period oneYear = Period.ofYears(1);
		LocalDate expireOn = joinDate.plus(oneYear);
		this.expiryDate = expireOn;
	}
	

	@Override
	public String toString() {
		return "Member{" + "id=" + id + ", name='" + name + '\'' + ", memberType=" + memberType + ", address='"
				+ address + '\'' + ", expiryDate=" + expiryDate + '}';
	}
}
