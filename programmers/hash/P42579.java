import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0,genres.length).mapToObj(i ->new Song(genres[i], i, plays[i]))
                .collect(Collectors.groupingBy(Song::getGenre)).values()
                .stream().sorted(this::compareSongs).flatMap(l->l.stream().sorted().limit(2))
                .mapToInt(Song::getCode).toArray();
    }

    private int compareSongs(List<Song> x, List<Song> y){
        return y.stream().mapToInt(Song::getPlay).reduce(0, Integer::sum) - x.stream().mapToInt(Song::getPlay).reduce(0, Integer::sum);
    }
}
class Song implements Comparable<Song>{
    private String genre;
    private int code, play;

    Song(String genre, int code, int play){
        this.genre = genre;
        this.code = code;
        this.play = play;
    }

    int getPlay() {return play;}
    String getGenre() {return genre;}
    int getCode() {return code;}

    @Override
    public int compareTo(Song o) {
        return (this.play == o.play) ? this.code - o.code : o.play-this.play;
    }

    @Override
    public String toString() {
        return "Genre : "+genre+", Code : "+code+", play : "+play;
    }
}