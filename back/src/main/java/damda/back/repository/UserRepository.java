package damda.back.repository;

import damda.back.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class UserRepository {
    private final DynamoDbTable<Users> userTable;

    public UserRepository(@Autowired DynamoDbEnhancedClient dynamo) {
        this.userTable = dynamo.table(Users.TABLE_NAME, TableSchema.fromBean(Users.class));
    }

    public void save(Users user) {
        userTable.putItem(user);
    }

    public Users get(String id) {
        return userTable.getItem(Key.builder().partitionValue(id).build());
    }

    public void update(Users user) {
        userTable.updateItem(user);
    }

    public void delete(String id) {
        userTable.deleteItem(Key.builder().partitionValue(id).build());
    }
}
