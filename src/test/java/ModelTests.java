import com.trainings.Model.RandomizeModel;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ModelTests {

    private RandomizeModel model = new RandomizeModel();
    private int smallest = 1;
    private int largest = 99;
    private int zero = 0;
    private int hundred = 100;

    /**
     *
     */
    @Ignore
    @Test
    public void testGenerateSmallestCorrectValue() {
        checkEqualityToRandomGenerated(smallest);
        Assert.assertEquals(smallest, model.getWinCondition());
    }

    @Ignore
    @Test
    public void testGenerateLargestCorrectValue() {
        checkEqualityToRandomGenerated(largest);
        Assert.assertEquals(largest, model.getWinCondition());
    }

    @Ignore
    @Test
    public void testRangeZeroValue() {
        checkEqualityToRandomGenerated(zero);
        Assert.assertNotEquals(zero, model.getWinCondition());
    }

    @Ignore
    @Test
    public void testRangeHundredValue() {
        checkEqualityToRandomGenerated(hundred);
        Assert.assertNotEquals(hundred, model.getWinCondition());
    }

    private void checkEqualityToRandomGenerated(int value) {
        int i = 0;
        System.out.println("checking for " + value);
        while (i < 10000) {
            model.generateWinCondition(RandomizeModel.RAND_START, RandomizeModel.RAND_END);
            //System.out.println(i + " - i , wincond = " + model.getWinCondition());
            i++;
            if (model.getWinCondition() == value) {
                break;
            }
        }
        System.out.println("tries spent for check: " + i);
    }
}
