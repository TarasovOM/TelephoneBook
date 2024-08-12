import org.example.PhoneBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @ParameterizedTest
    @MethodSource("sourceForAdd")
    public void parametrizedTestAdd(String name, String phoneNumber, int expected) {
        //act
        int result = phoneBook.add(name, phoneNumber);
        //assert
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceForAdd() {
        return Stream.of(Arguments.of("Slava", "+7 999 999 99 99", 1),
                Arguments.of("Vyacheslav", "+7 999 999 99 98", 2),
                Arguments.of("Slava", "+7 999 999 99 97", 3)
        );
    }
}
