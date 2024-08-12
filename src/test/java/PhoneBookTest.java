import org.example.PhoneBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook phoneBook = PhoneBook.getInstance();
    @BeforeEach
    public void prepare() {
        phoneBook.add("Slava", "+7 999 999 99 99");
    }

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
                Arguments.of("Slava", "+7 999 999 99 97", 2),
                Arguments.of("Test", "+7 111 111 11 11", 3)
        );
    }
    @ParameterizedTest
    @MethodSource("sourceForFindByNumber")
    public void parametrizedTestFindByNumber(String phoneNumber, String expected) {

        String result = phoneBook.findByNumber(phoneNumber);
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceForFindByNumber() {
        return Stream.of(Arguments.of("+7 999 999 99 99", "Slava"),
                Arguments.of("+7 999 999 99 97", null)
        );
    }
    @Test
    public void testFindByName() {
        String expected = "+7 999 999 99 99";
        String result = phoneBook.findByName("Slava");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void printAllNames() {
        phoneBook.add("Vyacheslav", "+7 999 999 99 98");
        phoneBook.add("Test", "+7 111 111 11 11");
        List<String> expected = new ArrayList<>(Arrays.asList("Slava", "Test", "Vyacheslav"));
        List<String> result = phoneBook.printAllNames();
        Assertions.assertEquals(expected, result);
    }
}
