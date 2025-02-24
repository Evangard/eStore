package framework.models;

public class Customer {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Customer() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private Customer(final Builder builder) {
        email = builder.email;
        password = builder.password;
    }

   public static final class Builder {
        private String email;
        private String password;

        private Builder() {
       }

       public Builder withEmail(final String val) {
           email = val;
           return this;
       }

       public Builder withPassword(final String val) {
           password = val;
           return this;
       }

       public Customer build() {
           return new Customer(this);
       }
    }
}
