package user.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String mail;
    private String firstName;
    private String lastName;
    private String middleName;
    private Boolean isActive;

    public UserInformation(Long id, String mail, String firstName, String lastName, String middleName, Boolean isActive) {
        this.id= id;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.isActive = isActive;
    }

    public UserInformation(Long id,String mail, String firstName, String lastName, String middleName) {
        this.id = id;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public UserInformation(String mail, String firstName, String lastName, String middleName, Boolean isActive) {
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.isActive = isActive;
    }

    public UserInformation() {

    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Boolean getActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformation that = (UserInformation) o;
        return Objects.equals(id, that.id) && Objects.equals(mail, that.mail) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(middleName, that.middleName) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, firstName, lastName, middleName, isActive);
    }
}
