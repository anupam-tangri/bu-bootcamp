import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class GradeAnalyserTest {

    
    @Test 
    public void calculateAverage_returnZero_whenListIsEmpty() {
        assertEquals(0.0, GradeAnalyser.calculateAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void calculateAverage_returnCorrectAverage_forTypicalScores() {
        assertEquals(85.0, GradeAnalyser.calculateAverage(Arrays.asList(80, 90, 85)), 0.01);
    }

    @Test
    public void calculateAverage_returnSingleValue_whenListHasOneElement() {
        assertEquals(85.0, GradeAnalyser.calculateAverage(Arrays.asList(85)), 0.01);
    }

    @Test
    public void calculateAverage_returnDouble_notInteger() {
        // 20 + 31 = 51, divided by 2 = 25.5, not 25
        ArrayList<Integer> scores4 = new ArrayList<>(Arrays.asList(20, 31));
        assertEquals(25.5, GradeAnalyser.calculateAverage(scores4), 0.01);
    }

    @Test
    public void calculateAverage_handleAllSameScores() {
        ArrayList<Integer> scores5 = new ArrayList<>(Arrays.asList(85, 85, 85));
        assertEquals(85.0, GradeAnalyser.calculateAverage(scores5), 0.01);
    }
}
