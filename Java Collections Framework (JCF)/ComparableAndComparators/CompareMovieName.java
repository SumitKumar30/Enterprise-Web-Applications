package ComparableAndComparators;

import java.util.Comparator;

public class CompareMovieName implements Comparator<MovieRanking>{
		@Override
		public int compare(MovieRanking m1, MovieRanking m2) {
			return m1.getMovie_name().compareTo(m2.getMovie_name());
		}
}
