package hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 베스트앨범
public class Solution42579 {

  static class MusicComparator implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
      return o2.play - o1.play;
    }
  }

  static class Music {
    int play;
    int number;

    Music(int play, int number) {
      this.play = play;
      this.number = number;
    }

    public int getNumber() {
      return number;
    }
  }

  public int[] solution(String[] genres, int[] plays) {
    int[] answer = {};
    List<Integer> result = new ArrayList<>();

    Map<String, Integer> playList = new HashMap<>();
    Map<String, List<Music>> musicList = new HashMap<>();
    Map<Integer, String> priorityPlayList = new TreeMap<>();

    for (int i = 0; i < genres.length; i++) {
      playList.put(genres[i], playList.getOrDefault(genres[i], 0) - plays[i]);
      musicList.computeIfAbsent(genres[i], k -> new LinkedList<>()).add(new Music(plays[i], i));
    }

    for(String s: playList.keySet()) {
      priorityPlayList.put(playList.get(s), s);
      List<Music> m = musicList.get(s);
      m.sort(new MusicComparator());
    }

    for(int i : priorityPlayList.keySet()) {
      int count = 0;
      List<Music> musics = musicList.get(priorityPlayList.get(i));
      for(Music music : musics) {
        result.add(music.getNumber());
        count++;
        if(count >= 2)
          break;
      }
    }

    answer = new int[result.size()];
    for(int i = 0; i < result.size(); i++) {
      answer[i] = result.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};

    Solution42579 solution = new Solution42579();
    int[] result = solution.solution(genres, plays);
    for( int i : result) {
      System.out.println(i);
    }
  }
}
