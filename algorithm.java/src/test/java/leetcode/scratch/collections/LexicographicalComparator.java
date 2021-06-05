import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexicographicalComparator
{
    public static void main(String[] args)
    {
        exampleWithIntegers();
        exampleWithStrings();
        exampleWithPersons();
    }

    private static void exampleWithIntegers()
    {
        List<List<Integer>> list = Arrays.asList(
            Arrays.asList(4, 5, 6), 
            Arrays.asList(7, 9, 10),
            Arrays.asList(4, 7, 8), 
            Arrays.asList(1, 2, 3),
            Arrays.asList(7, 9, 12));

        Comparator<List<Integer>> comparator = lexicographicalComparator();
        list.sort(comparator.reversed());

        System.out.println("Integers, descending:");
        list.forEach(System.out::println);
    }

    private static void exampleWithStrings()
    {
        List<List<String>> list = Arrays.asList(
            Arrays.asList("B", "B", "C"), 
            Arrays.asList("C", "B", "B"),
            Arrays.asList("B", "C", "A"), 
            Arrays.asList("A", "C", "B"),
            Arrays.asList("C", "B", "A"));

        Comparator<List<String>> comparator = lexicographicalComparator();
        list.sort(comparator);

        System.out.println("Strings, ascending:");
        list.forEach(System.out::println);
    }

    private static void exampleWithPersons()
    {
        class Person 
        {
            String name;
            Person(String name)
            {
                this.name = name;
            }
            String getName()
            {
                return name;
            }

            @Override
            public java.lang.String toString()
            {
                return name;
            }
        }

        List<List<Person>> list = Arrays.asList(
            Arrays.asList(new Person("B"), new Person("B"), new Person("C")), 
            Arrays.asList(new Person("C"), new Person("B"), new Person("B")),
            Arrays.asList(new Person("B"), new Person("C"), new Person("A")), 
            Arrays.asList(new Person("A"), new Person("C"), new Person("B")),
            Arrays.asList(new Person("C"), new Person("B"), new Person("A")));

        Comparator<List<Person>> comparator = 
            lexicographicalComparator(Comparator.comparing(Person::getName));
        list.sort(comparator);

        System.out.println("Persons, by name, ascending:");
        list.forEach(System.out::println);
    }



    private static <T extends Comparable<? super T>> Comparator<List<T>> 
        lexicographicalComparator()
    {
        return (list0, list1) -> 
            compareLexicographically(list0, list1, Comparator.naturalOrder());
    }

    private static <T> Comparator<List<T>> lexicographicalComparator(
        Comparator<? super T> comparator)
    {
        return (list0, list1) -> 
            compareLexicographically(list0, list1, comparator);
    }

    private static <T> int compareLexicographically(
        List<? extends T> list0,
        List<? extends T> list1, 
        Comparator<? super T> comparator)
    {
        if (list0.size() < list1.size())
        {
            return -1;
        }
        if (list0.size() > list1.size())
        {
            return 1;
        }
        for (int i = 0; i < list0.size(); i++)
        {
            T t0 = list0.get(i);
            T t1 = list1.get(i);
            int value = comparator.compare(t0, t1);
            if (value != 0)
            {
                return value;
            }
        }
        return 0;
    }
}
