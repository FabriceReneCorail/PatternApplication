import com.example.pattern.DataManager.persistence.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.when;
@Data
public class UserMock {


    public User createMockUser(int index) {
        User mockUser = new User();
        when(mockUser.getLastname()).thenReturn("Doe"+ (index));
        when(mockUser.getName()).thenReturn("Josh"+ (index));
        when(mockUser.getId()).thenReturn((long) (index + 1));
        when(mockUser.getAge()).thenReturn(34 + (index));
        return mockUser;
    }
    public List<User> mock(){
       return IntStream.range(0,10)//
                .mapToObj(e->createMockUser(e))//
                .collect(Collectors.toList());
    }





}
