package ComparableAndComparators;

import java.util.Comparator;

public class CompareCriticScore implements Comparator<MovieRanking> {
		@Override
		public int compare(MovieRanking m1, MovieRanking m2) {
			if(m1.getCritics_score() < m2.getCritics_score()) {
				return -1;
			}
			else if(m1.getCritics_score() > m2.getCritics_score())
				return 1;
			else
				return 0;
		}
}
