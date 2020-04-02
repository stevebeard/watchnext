package uk.co.stevebeard.watchnext.webapp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    protected Item() {}

    public Item(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

}
