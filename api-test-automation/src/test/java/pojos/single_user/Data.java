package pojos.single_user;

import lombok.ToString;

import java.util.Objects;

public class Data {
    public int id;
    public String email;
    public String first_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id && Objects.equals(email, data.email) && Objects.equals(first_name, data.first_name) && Objects.equals(last_name, data.last_name) && Objects.equals(avatar, data.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, first_name, last_name, avatar);
    }

    public String last_name;
    public String avatar;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



    @Override
    public String toString() {
        return "Data(id=" + String.valueOf(this.getId()) + ", email=" + this.getEmail() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ", avatar=" + this.getAvatar() + ")";
    }
}
