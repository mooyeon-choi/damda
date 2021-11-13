package damda.back.Repository;

import damda.back.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class UserRepository {
    private final DynamoDbTable<User> userTable;

    public UserRepository(@Autowired DynamoDbEnhancedClient dynamo) {
        this.userTable = dynamo.table(User.TABLE_NAME, TableSchema.fromBean(User.class));
    }

    public void save(User user) {
        userTable.putItem(user);
    }

    public User get(String id) {
        return userTable.getItem(Key.builder().partitionValue(id).build());
    }

    public void update(User user) {
        userTable.updateItem(user);
    }

    public void delete(String id) {
        userTable.deleteItem(Key.builder().partitionValue(id).build());
    }
}
