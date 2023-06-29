package pojos.single_user;

import java.util.Objects;

public class SingleUserRoot {
    public Data data;
    public Support support;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleUserRoot that = (SingleUserRoot) o;
        return Objects.equals(data, that.data) && Objects.equals(support, that.support);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, support);
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "SingleUserRoot(data=[" + this.getData().toString() + "], support=[" + this.getSupport().toString() + "])";
    }
}
