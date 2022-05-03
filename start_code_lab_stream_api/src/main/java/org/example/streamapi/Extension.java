package org.example.streamapi;

import org.example.streamapi.model.Bodybuilder;
import org.example.streamapi.model.Friend;
import org.example.streamapi.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Extension {
    /*
        Given two int numbers a and b, return int [] with values that are in the range between smaller and bigger arg:
        - use IntStream.range
        - swap the argument's values without introducing a new, local variable.
    */
    public int [] streamNumbers(int a, int b) {

        // Implement me :)
        if(b < a) {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        int[] result = IntStream.range(a, b).toArray();

        return result;
    }

    /*
        Given a list of users, return a User with the given user id. If there is no user with this id,
        return new user with the name "New user", given id, gender "unknown".

        (use Optional API)
    */
    public User getUserByIdOrCreateNew(List<User> users, long userId) {
        // Implement me :)
        Optional<User> findUser = Optional.of(users.stream()
                .filter(users1 -> users1.getId() == userId)
                .findAny()
                .orElse(new User(userId, "New user", User.GENDER.UNKNOWN)));

        return findUser.get();
    }

    /*
        Given List<Friend>, filter the ones who are available on Saturday and want to party:
        - getAvailableDay returns "Saturday" and
        - getActivity returns "Party"
        - define predicates and use '.and' method.
    */

    public List<String> partyWithFriends(List<Friend> friends) {
        // Implement me :)
        Predicate<Friend> availableOnSaturday = person -> person.getAvailableDay().equals("Saturday");
        Predicate<Friend> availableParty = person -> person.getActivity().equals("Party");

        List<String> result = friends
                .stream()
                .filter(availableOnSaturday.and(availableParty))
                .map(Friend::getName)
                .toList();

        return result;
    }

    /*
        Return names of sorted bodybuilders.

        Sort List<Bodybuilder> using your custom comparator.

        Write a comparator for type BodyBuilder that will sort bodybuilders by:
        - who can lift more,
        - then who is younger,
        - then name alphabetically.
     */
    public List<String> sortBodybuilders(List<Bodybuilder> bodybuilders) {
        // Implement me :)

        Comparator<Bodybuilder> byLiftMore_younger_nameAlphabetically =
                Comparator.comparingInt(Bodybuilder::getLift).reversed().
                        thenComparing(Bodybuilder::getAge)
                        .thenComparing(Bodybuilder::getName);

        List<String> result = bodybuilders
                .stream()
                .sorted(byLiftMore_younger_nameAlphabetically)
                .map(Bodybuilder::getName)
                .toList();
        return result;
    }

}
