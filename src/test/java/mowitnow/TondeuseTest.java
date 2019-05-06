package mowitnow;

import mowitnow.utils.UtilsMowItNow;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeuseTest {

    @Test(expected = IllegalArgumentException.class)
    public void tondeuse_should_throw_exception_when_it_s_out_of_bound() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(-1, 7, "N", 6, 6);
    }

    @Test
    public void tondeuse_should_stay_in_the_same_place_when_there_no_command() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 0, "N", 6, 6);
        String commands = "";
        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));

        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 0 N");
    }

    @Test
    public void tondeuse_should_advance_when_there_is_command_A_N() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 0, "N", 6, 6);
        String commands = "A";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));

        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 1 N");

    }

    @Test
    public void tondeuse_should_advance_when_there_is_command_A_S() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 1, "S", 6, 6);
        String commands = "A";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));

        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 0 S");
    }

    @Test
    public void tondeuse_should_advance_when_there_is_command_A_W() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(1, 0, "W", 6, 6);
        String commands = "A";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));

        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 0 W");
    }

    @Test
    public void tondeuse_should_advance_when_there_is_command_A_E() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 0, "E", 6, 6);
        String commands = "A";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));

        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("1 0 E");
    }

    @Test
    public void tondeuse_should_change_orientation_when_command_D() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 0, "N", 6, 6);
        String commands = "D";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));

        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 0 E");

    }

    @Test
    public void tondeuse_should_change_orientation_when_command_G() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 0, "N", 6, 6);
        String commands = "G";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));
        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 0 W");

    }

    @Test
    public void tondeuse_should_move_when_command_AD() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(0, 0, "N", 6, 6);
        String commands = "AD";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));
        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("0 1 E");

    }

    @Test
    public void tondeuse_should_move_when_command_ADAAAGAA() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(1, 1, "N", 6, 6);
        String commands = "ADAAAGAA";

        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));
        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("4 4 N");

    }

    @Test
    public void tondeuse_should_move_when_command_ADAAAGAADAAA() {
        //Arrange
        Tondeuse tondeuse = new Tondeuse(1, 1, "N", 6, 6);
        String commands = "GDADAAAGAADAAA";
        //Act
        tondeuse.moveToNewPosition(UtilsMowItNow.convertToListCommands(commands));
        //Assert
        assertThat(tondeuse.getPosition()).isEqualTo("6 4 E");

    }
}
