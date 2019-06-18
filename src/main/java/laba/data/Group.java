package laba.data;

        import javax.persistence.*;
        import java.io.Serializable;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "group_name")
    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public static final String DB_NAME = "groups";

    public static class Columns{
        public static final String ID = "id";
        public static final String NAME = "group_name";
    }
}
