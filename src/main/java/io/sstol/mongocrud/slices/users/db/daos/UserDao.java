package io.sstol.mongocrud.slices.users.db.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sergey Stol
 * 2022-05-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class UserDao {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String address;
}