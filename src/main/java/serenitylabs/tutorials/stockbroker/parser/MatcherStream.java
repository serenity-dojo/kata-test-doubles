package serenitylabs.tutorials.stockbroker.parser;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class MatcherStream {
    private MatcherStream() {
    }

    public static Stream<MatchResult> find(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);

        Spliterator<MatchResult> spliterator = new Spliterators.AbstractSpliterator<MatchResult>(
                Long.MAX_VALUE, Spliterator.ORDERED | Spliterator.NONNULL) {
            @Override
            public boolean tryAdvance(Consumer<? super MatchResult> action) {
                if (! matcher.find()) return false;
                action.accept(matcher);
                return true;
            }
        };

        return StreamSupport.stream(spliterator, false);
    }
}
