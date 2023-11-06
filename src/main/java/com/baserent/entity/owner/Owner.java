package com.baserent.entity.owner;

import jakarta.persistence.*;

@Entity
public class Owner {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(columnDefinition = "UNIQUE", nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static final class OwnerBuilder {
        private Owner owner;

        private OwnerBuilder() {
            owner = new Owner();
        }

        public static OwnerBuilder anOwner() {
            return new OwnerBuilder();
        }

        public OwnerBuilder withFirstName(String firstName) {
            owner.setFirstName(firstName);
            return this;
        }

        public OwnerBuilder withLastName(String lastName) {
            owner.setLastName(lastName);
            return this;
        }

        public OwnerBuilder withEmail(String email) {
            owner.setEmail(email);
            return this;
        }

        public OwnerBuilder withPassword(String password) {
            owner.setPassword(password);
            return this;
        }

        public Owner build() {
            return owner;
        }
    }
}
