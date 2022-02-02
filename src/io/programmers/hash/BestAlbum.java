package io.programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BestAlbum {

    public static class Music {

        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Music{" + "genre='" + genre + '\'' + ", play=" + play + ", idx=" + idx + '}';
        }
    }


    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<>();

        // 각 genre 의 play time 의 총합을 구하기 위한 for 문
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
        }

        ArrayList<String> genresOrdered = new ArrayList<>();

        // 장르 선정 sorting
        while (!map.isEmpty()) {
            int maxPlayTime = -1;
            String maxPlayGenre = "";

            for (String genre : map.keySet()) {
                Integer totalPlayTime = map.get(genre);

                if (maxPlayTime < totalPlayTime) {
                    maxPlayTime = totalPlayTime;
                    maxPlayGenre = genre;
                }
            }

            genresOrdered.add(maxPlayGenre);
            map.remove(maxPlayGenre);
        }

        ArrayList<Music> result = new ArrayList<>();

        for (String genre : genresOrdered) {

            ArrayList<Music> musics = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    musics.add(new Music(genre, plays[i], i));
                }
            }

            // play time 을 기준으로 내림 차순 sorting
            musics.sort((music1, music2) -> music2.play - music1.play);
            result.add(musics.get(0));

            if (musics.size() > 1) {
                result.add(musics.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).idx;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

}
