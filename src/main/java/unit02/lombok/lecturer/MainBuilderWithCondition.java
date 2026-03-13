package unit02.lombok.lecturer;

public class MainBuilderWithCondition
{

    static void main() {
        String optionalFIeld = "Something is inside";

        var person = Lecturer.builder().name("asdf").id(1);

        if(optionalFIeld != null) person.email(optionalFIeld);

        Lecturer l = person.build();

    }
}
