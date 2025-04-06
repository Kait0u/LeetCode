
import java.util.ArrayDeque;
import java.util.Deque;


public class Problem649 {

    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        
        private static final String RADIANT = "Radiant";
        private static final String RADIANT_SHORT = "R";
        private static final String DIRE = "Dire";
        
        public String predictPartyVictory(String senate) {
            int senateSize = senate.length();
            int radiantMembers = 0;
            int direMembers = 0;
            
            Deque<String> votingQueue = new ArrayDeque<>(senateSize);
            
            for (char memberCh : senate.toCharArray()) {
                String memberStr = Character.toString(memberCh);
                
                if (isRadiant(memberStr)) {
                    ++radiantMembers;
                } else {
                    ++direMembers;
                }
                
                votingQueue.addLast(memberStr);
            }
            
            int direBanned = 0;
            int radiantBanned = 0;
            while (radiantMembers > 0 && direMembers > 0) {
                for (int i = 0; i < senateSize; ++i) {
                    String member = votingQueue.pollFirst();
                    
                    if (isRadiant(member)) {
                        if (radiantBanned == 0) {
                            ++direBanned;
                            votingQueue.addLast(member);
                        } else {
                            --radiantBanned;
                            --radiantMembers;
                        }
                    } else {
                        if (direBanned == 0) {
                            ++radiantBanned;
                            votingQueue.addLast(member);
                        } else {
                            --direBanned;
                            --direMembers;
                        }
                    }
                }
                
                senateSize = radiantMembers + direMembers;
            }
            
            return radiantMembers > 0 ? RADIANT : DIRE;
        }
        
        private boolean isRadiant(String member) {
            return RADIANT_SHORT.equals(member);
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        System.out.println("Radiant".equals(solution.predictPartyVictory("RD")));
        System.out.println("Dire".equals(solution.predictPartyVictory("RDD")));
        System.out.println("Dire".equals(solution.predictPartyVictory("DDRRR")));
    }
}
