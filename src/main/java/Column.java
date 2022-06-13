import java.util.Objects;

public class Column {

    String col_name;
    String col_size;
    String type_name;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getCol_name() {
        return col_name;
    }

    public void setCol_name(String col_name) {
        this.col_name = col_name;
    }

    public String getCol_size() {
        return col_size;
    }

    public void setCol_size(String col_size) {
        this.col_size = col_size;
    }


    /**
     * The definition of equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column colum = (Column) o;
        if (type_name.equals("timestamp")) {
            boolean isEqual = Objects.equals(col_name, colum.col_name) && Objects.equals(col_size, colum.col_size);
            return isEqual;
        } else {
            boolean isEqual = Objects.equals(col_name, colum.col_name) && Objects.equals(col_size, colum.col_size) && Objects.equals(type_name, colum.type_name);
            return isEqual;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(col_name, col_size, type_name);
    }
    @Override
    public String toString() {
        return "Colum{" +
                "col_name='" + col_name + '\'' +
                ", col_size='" + col_size + '\'' +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
