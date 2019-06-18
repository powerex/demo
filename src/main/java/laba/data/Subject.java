package laba.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "subject_group")
    private Long group;
    @Column(name = "subject_name")
    private String name;
    @Column(name = "subject_description")
    private String description;
    @Column(name = "subject_credits")
    private Long credits;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public static final String DB_NAME = "subjects";

    public static class Columns {
        public static final String ID = "id";
        public static final String GROUP_ID = "st_group";
        public static final String NAME = "subject_name";
        public static final String DESCRIPTION = "subject_description";
        public static final String CREDITS = "credits";

    }
}