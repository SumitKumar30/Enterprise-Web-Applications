package ComparableAndComparators;

import java.util.Comparator;

public class CompareUserRating implements Comparator<MovieRanking> {
		@Override
		public int compare(MovieRanking m1, MovieRanking m2) {
			if(m1.getUser_rating() < m2.getUser_rating())
				return -1;
			else if(m1.getUser_rating() > m2.getUser_rating())
					return 1;
			else
				return 0;
		}
}
