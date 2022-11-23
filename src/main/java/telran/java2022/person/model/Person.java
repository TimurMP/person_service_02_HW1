package telran.java2022.person.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "persons")
public class Person {
	@Id
	Integer id;
	@Setter
	String name;
//	@Column(columnDefinition = "DATE")
//	@MapKeyTemporal(TemporalType.DATE)
//	@DateTimeFormat
//	@Temporal(TemporalType.DATE)
	LocalDate birthDate;
	@Setter
//	@Embedded
	Address address;

}
