package com.greatlearning.crmmanagement.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="customer")
@Entity(name = "customer_entity")

public class Customer {
	// define fields

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;

		@Column(name="email")
		private String email;

		@Column(name="firstName")
		private String firstName;


		@Column(name="lastName")
		private String lastName;


		public Customer()
		{
			
		}
		
		public Customer(String email, String firstName, String lastName) {
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

			public String toString() {
				return "Customer [id=" + id + 
						", email=" + email + 
						", firstName=" + firstName + 
						", lastName=" + lastName + "]";
}

}