import java.io.*;
import java.util.*;

public class HighScores {
    private List<Integer> scores;
    private String filename = "highscores.txt";

    public HighScores() {
        scores = new ArrayList<>();
        LoadScores();
    }

    public void LoadScores() {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                scores.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SaveScores(int score) {
        scores.add(score);
        Collections.sort(scores, Collections.reverseOrder());
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            for (int s : scores) {
                out.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Integer> GetScores() {
        return scores;
    }
}
