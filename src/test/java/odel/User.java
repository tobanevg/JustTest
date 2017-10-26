package Odel;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public static Builder newEntity() {
        return new User().new Builder();
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withFirstname(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public Builder withLastname(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            User.this.password = password;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
