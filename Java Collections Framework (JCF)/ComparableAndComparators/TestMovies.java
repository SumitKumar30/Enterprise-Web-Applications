package ComparableAndComparators;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMovies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MovieRanking> list = new ArrayList<>();
		list.add(new MovieRanking("GodFather", 9, 90));
		list.add(new MovieRanking("Endgame", 8, 85));
		list.add(new MovieRanking("Star Wars", 7, 78));
		list.add(new MovieRanking("Inception", 9, 95));
		list.add(new MovieRanking("Interstellar", 10, 88));
		list.add(new MovieRanking("Avatar", 6, 73));
		
		System.out.println("Movie Rankings before sorting: "+list);
		
		// call to compareTo() method using Collections.sort() 
		
		CompareMovieName name = new CompareMovieName();
		CompareUserRating user = new CompareUserRating();
		CompareCriticScore critics = new CompareCriticScore();
		/*
		 * Another method using Anonymous class
		 * 
		Comparator<MovieRanking> name = new Comparator<MovieRanking>(){
				public int compare(MovieRanking m1, MovieRanking m2) {
					return m1.getMovie_name().compareTo(m2.getMovie_name());
				}
		};
		*/
		
		// Java 8 --> name.comparing(MovieRanking:: getMovie_name());
		
		Collections.sort(list, name);
		
		System.out.println("Movies Sorted According to name: "+list);
		
		Collections.sort(list, user);
		
		System.out.println("Movies Sorted According to rating: "+list);
		
		Collections.sort(list, critics);
		
		System.out.println("Movies Sorted According to Critics: "+list);
		
		System.out.println();
		
//		System.out.println("Movie Rankings after sorting: "+ list);
		
	}

}
