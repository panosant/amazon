package com.antonakospanos.amazon.exam.ex1.usecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SimilarMovies {

	public static class Movie {
		private final int movieId;
		private final float rating;
		private List<Movie> similarMovies; // Similarity is bidirectional

		public Movie(int movieId, float rating) {
			this.movieId = movieId;
			this.rating = rating;
			similarMovies = new ArrayList<Movie>();
		}

		public int getId() {
			return movieId;
		}

		public float getRating() {
			return rating;
		}

		public void addSimilarMovie(Movie movie) {
			similarMovies.add(movie);
			movie.similarMovies.add(this);
		}

		public List<Movie> getSimilarMovies() {
			return similarMovies;
		}
	}

	public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
		// Initialzation
		List<Movie> movieRecommendations = new ArrayList<>();
		List<Movie> limitedMovieRecommendations = new ArrayList<>();

		// Find all similarMovies
		movieRecommendations = getSimilarMovies(movie, movieRecommendations);

		// Sort the similarMovies based on their rating
		sortMoviesBasedOnTheirRating(movieRecommendations);

		// Limit the movieRecommendations till the requested numTopRatedSimilarMovies value
		limitedMovieRecommendations = getRequestedNumberOfSimilarMovies(movieRecommendations, numTopRatedSimilarMovies);

		return limitedMovieRecommendations;
	}

	private static List<Movie> getSimilarMovies(Movie movie, List<Movie> alreadyAddedSimilarMovies) {
		for (Movie similarMovie : movie.getSimilarMovies()) {

			if (!alreadyAddedSimilarMovies.contains(similarMovie)) {
				alreadyAddedSimilarMovies.add(similarMovie);
				getSimilarMovies(similarMovie, alreadyAddedSimilarMovies);
			}
		}

		return alreadyAddedSimilarMovies;
	}

	private static List<Movie> sortMoviesBasedOnTheirRating(List<Movie> movieRecommendations) {

		Collections.sort(movieRecommendations, new Comparator<Movie>() {
			public int compare(Movie movie1, Movie movie2) {
				Float rating1 = Float.valueOf(movie1.getRating());
				Float rating2 = Float.valueOf(movie2.getRating());
				return rating1.compareTo(rating2);
			}
		});

		return movieRecommendations;
	}

	private static List<Movie> getRequestedNumberOfSimilarMovies(List<Movie> sortMoviesBasedOnTheirRating, int numTopRatedSimilarMovies) {
		if (sortMoviesBasedOnTheirRating.size() <= numTopRatedSimilarMovies) {
			return new ArrayList<Movie>(sortMoviesBasedOnTheirRating.subList(0, sortMoviesBasedOnTheirRating.size()));
		} else {
			return new ArrayList<Movie>(sortMoviesBasedOnTheirRating.subList(0, numTopRatedSimilarMovies));
		}
	}
}