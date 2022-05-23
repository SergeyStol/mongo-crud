package io.sstol.mongocrud.slices.dbsequences.db.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sergey Stol
 * 2022-05-23
 */
@Data
@AllArgsConstructor
@Document("database-sequences")
public class DatabaseSequenceDao {
    private String id;
    private long seq;
}