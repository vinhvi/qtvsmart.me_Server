package com.qtvsmart.qtvsmartServer.entity;

import java.util.List;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {
	@Column(nullable = false, unique = true)
	private String position;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;

	@OneToMany(mappedBy = "employee")
	private List<ImportOrder> importOrders;

}
