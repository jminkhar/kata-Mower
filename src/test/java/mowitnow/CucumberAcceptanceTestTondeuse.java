package mowitnow;

import cucumber.api.java.en.*;
import mowitnow.utils.UtilsMowItNow;
import static org.assertj.core.api.Assertions.*;

public class CucumberAcceptanceTestTondeuse {
    int maxX;
    int maxY;
    Tondeuse tondeuse;
    @Given("^A maximum of height : (\\d+) and width : (\\d+)$")
    public void generateStandardTondeuseInPelouse(int maxHeight, int maxWidth) {
        maxX = maxHeight;
        maxY = maxWidth;
    }
    @When("^Tondeuse in (\\d+) (\\d+) \"([^\"]*)\"$")
    public void giveTondeusePositionAndDirection(int x, int y, String orientation){
        tondeuse = new Tondeuse(x,y,orientation,maxY,maxY);
    }
    @When("^Tondeuse receive order \"([^\"]*)\"$")
    public void giveTondeuseOrders(String commands){
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));
    }
    @Then("^result should be \"([^\"]*)\"$")
    public void compareResultAndExpected(String expected){
        assertThat(tondeuse.getPosition()).isEqualTo(expected);
    }

}
