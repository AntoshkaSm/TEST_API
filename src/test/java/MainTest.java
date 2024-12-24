import restservicetests.PositiveTest;
import restservicetests.NegativeTest;
/*
Сделано 2 класса на 1 позитивный и 1 негативный тест
на каждый из методов HTTP запросов к сервису https://reqres.in/.
*/

public class MainTest {
    public static void main(String[] args) {
        PositiveTest positiveTest = new PositiveTest();
        positiveTest.postUser();
        positiveTest.putUser();
        positiveTest.deleteUser();
        positiveTest.getUser();

        NegativeTest negativeTest = new NegativeTest();
        negativeTest.postUser();
        negativeTest.putUser();
        negativeTest.deleteUser();
        negativeTest.getUser();
    }
}
