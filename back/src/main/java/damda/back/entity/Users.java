package damda.back.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class Users {
    public static final String TABLE_NAME = "Users";

    @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDbAttribute("id")})
    private String id;

    @Getter(onMethod_ = {@DynamoDbAttribute("pw")})
    private String pw;
}
