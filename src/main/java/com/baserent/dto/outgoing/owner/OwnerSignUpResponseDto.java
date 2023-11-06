package com.baserent.dto.outgoing.owner;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class OwnerSignUpResponseDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

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


    public static final class OwnerSignUpResponseDtoBuilder {
        private OwnerSignUpResponseDto ownerSignUpResponseDto;

        private OwnerSignUpResponseDtoBuilder() {
            ownerSignUpResponseDto = new OwnerSignUpResponseDto();
        }

        public static OwnerSignUpResponseDtoBuilder anOwnerSignUpResponseDto() {
            return new OwnerSignUpResponseDtoBuilder();
        }

        public OwnerSignUpResponseDtoBuilder withId(Integer id) {
            ownerSignUpResponseDto.setId(id);
            return this;
        }

        public OwnerSignUpResponseDtoBuilder withFirstName(String firstName) {
            ownerSignUpResponseDto.setFirstName(firstName);
            return this;
        }

        public OwnerSignUpResponseDtoBuilder withLastName(String lastName) {
            ownerSignUpResponseDto.setLastName(lastName);
            return this;
        }

        public OwnerSignUpResponseDtoBuilder withEmail(String email) {
            ownerSignUpResponseDto.setEmail(email);
            return this;
        }

        public OwnerSignUpResponseDto build() {
            return ownerSignUpResponseDto;
        }
    }
}
