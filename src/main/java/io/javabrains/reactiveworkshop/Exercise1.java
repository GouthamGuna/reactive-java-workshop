package io.javabrains.reactiveworkshop;

public class Exercise1 {

    /**
     * Last Exercise : REF
     * One TO One -> map();
     * One TO Many -> FlatMap()
     */
    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(numbers -> numbers < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(numbers -> numbers > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer values = StreamSources.intNumbersStream()
                .filter(numbers -> numbers > 5)
                .findFirst()
                .orElse(-1);

        System.out.println("values = " + values);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream()
                        .filter(getUsers -> getUsers.getId() == id))
                .map(User::getFirstName)
                .forEach(users -> System.out.println("users = " + users)); // return user object

        StreamSources.userStream()
                .map(users -> StreamSources.intNumbersStream()
                        .anyMatch(id -> id == users.getId()))
                .forEach(users -> System.out.println("usersI = " + users)); // return boolean
    }

}
