//package com.antonakospanos.amazon.exam.ex1;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//import com.antonakospanos.amazon.exam.ex1.provided.Movie;
//
//public class Exercise1 {
//
//	final Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
//	Movie rootMovie = null;
//	int numTopRatedSimilarMovies = 0;
//
//	final Scanner in = new Scanner(System.in);in.useLocale(new Locale("en","US"));
//
//	while(in.hasNextLine())
//	{
//		final String type = in.next();
//
//		if (type.equals("movie")) {
//			final int id = in.nextInt();
//			final float rating = in.nextFloat();
//			movieMap.put(id, new Movie(id, rating));
//		} else if (type.equals("similar")) {
//			final Movie movie1 = movieMap.get(in.nextInt());
//			final Movie movie2 = movieMap.get(in.nextInt());
//			movie1.addSimilarMovie(movie2);
//		} else if (type.equals("params")) {
//			rootMovie = movieMap.get(in.nextInt());
//			numTopRatedSimilarMovies = in.nextInt();
//		} else {
//			// ignore comments and whitespace
//		}
//	}
//
//	final List<Movie> result = getMovieRecommendations(rootMovie, numTopRatedSimilarMovies);
//
//	String output = "result";
//
//	if(result==null)
//	{
//		output += " <null>";
//	}else
//	{
//		Collections.sort(result, new Comparator() {
//			@Override
//			public int compare(Object m1, Object m2) {
//				return ((Movie) m1).getId() - ((Movie) m2).getId();
//			}
//		});
//
//		for (Movie m : result) {
//			output += " ";
//			output += m.getId();
//		}
//	}
//
//	final String fileName = System.getenv("OUTPUT_PATH");
//	BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));bw.write(output);bw.newLine();bw.close();
//}}
