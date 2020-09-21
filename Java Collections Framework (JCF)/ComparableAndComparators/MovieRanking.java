package ComparableAndComparators;

public class MovieRanking{
	String movie_name; 
	int user_rating;
	int critics_score;
	
	MovieRanking(String name, int rating, int score){
		this.movie_name = name;
		this.user_rating = rating;
		this.critics_score = score;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public int getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(int user_rating) {
		this.user_rating = user_rating;
	}

	public int getCritics_score() {
		return critics_score;
	}

	public void setCritics_score(int critics_score) {
		this.critics_score = critics_score;
	}
	
	
	// JVM --> order movie objects on the basis of user ratings
//	@Override
//	public int compareTo(MovieRanking movie) {
////		if(this.getCritics_score() < movie.getCritics_score()) {
////			return -1;
////		}
////		else if(this.getCritics_score() > movie.getCritics_score()) {
////				return 1;
////		}
////		else
////			return 0;
//		
//		return this.getMovie_name().compareTo(movie.getMovie_name());
//	}
	
	// print the data inside an object --> MovieRanking
	@Override
	public String toString() {
		return "\nMovie Name:"+ this.movie_name+"\nUser Rating:"+this.user_rating+"\nCritics Score: "+this.critics_score;
	}
	
}
