package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private static final Map<Integer, String> TIE_SCORES = new HashMap<Integer, String>();
    static {
        TIE_SCORES.put(0, "Love-All");
        TIE_SCORES.put(1, "Fifteen-All");
        TIE_SCORES.put(2, "Thirty-All");
        TIE_SCORES.put(3, "Forty-All");
        TIE_SCORES.put(-1, "Deuce");
    }

    private static final Map<Integer, String> SCORES = new HashMap<Integer, String>();
    static {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }


    public String getScore() {
        // Tie
        if (m_score1 == m_score2)
            return (m_score1 < 4) ? TIE_SCORES.get(m_score1) : TIE_SCORES.get(-1);

        // Win
        if ((m_score1 > 3 || m_score2 > 3) && Math.abs(m_score1-m_score2) > 1)
            return m_score1 > m_score2 ? "Win for player1" : "Win for player2";

        // Advantage
        if (m_score1 > 3 || m_score2 > 3)
            return m_score1 > m_score2 ? "Advantage player1" : "Advantage player2";

        // Normal play
        return SCORES.get(m_score1) + "-" + SCORES.get(m_score2);
    }
}