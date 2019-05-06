package mowitnow;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandsProcessingUat {
    File testFile = new File("/Users/jminkhar/IdeaProjects/GildedRose-Refactoring-Kata/mowerkata/src/main/resources/testcommands");
    File testFileForExceptions = new File("/Users/jminkhar/IdeaProjects/GildedRose-Refactoring-Kata/mowerkata/src/main/resources/testcommandsforexceptions");
    File testFileForExceptionsOrientation = new File("/Users/jminkhar/IdeaProjects/GildedRose-Refactoring-Kata/mowerkata/src/main/resources/testcommandsforexceptionsOrientation");
    File testFileForExceptionsPosition = new File("/Users/jminkhar/IdeaProjects/GildedRose-Refactoring-Kata/mowerkata/src/main/resources/testcommandsforexceptionsNumbersPosition");

    @Test(expected = FileNotFoundException.class)
    public void should_throw_exception_when_file_not_found() throws IOException {
        //Arrange
        CommandsProcessor commandsProcessing = new CommandsProcessor();
        //Act
        commandsProcessing.setUp(new File(""));
    }
    @Test
    public void servePelouseWithTendeusesAndReturnPositions() throws IOException {
        //Arrange
        CommandsProcessor commandsProcessing = new CommandsProcessor();
        //Act
        commandsProcessing.setUp(testFile);
        commandsProcessing.servePelouseWithTendeuses();
        //Assert
        List<Tondeuse> listTondeuses = commandsProcessing.getPelouse().getMapTondeusesCommands().keySet().stream().collect(Collectors.toList());
        assertThat(listTondeuses.get(0).getPosition()).isEqualTo("1 3 N");
        assertThat(listTondeuses.get(1).getPosition()).isEqualTo("5 1 E");
        assertThat(listTondeuses.get(2).getPosition()).isEqualTo("1 2 S");
        assertThat(listTondeuses.get(3).getPosition()).isEqualTo("3 3 W");
        assertThat(listTondeuses.get(4).getPosition()).isEqualTo("3 2 S");
        assertThat(listTondeuses.get(5).getPosition()).isEqualTo("3 2 S");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_when_dimensions_are_not_numbers() throws IOException {
        //Arrange
        CommandsProcessor commandsProcessing = new CommandsProcessor();
        //Act
        commandsProcessing.setUp(testFileForExceptions);
        commandsProcessing.servePelouseWithTendeuses();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_orientation_is_not_in_N_E_S_W() throws IOException {
        //Arrange
        CommandsProcessor commandsProcessing = new CommandsProcessor();
        //Act
        commandsProcessing.setUp(testFileForExceptionsOrientation);
        commandsProcessing.servePelouseWithTendeuses();
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_position_not_number() throws IOException {
        //Arrange
        CommandsProcessor commandsProcessing = new CommandsProcessor();
        //Act
        commandsProcessing.setUp(testFileForExceptionsPosition);
        commandsProcessing.servePelouseWithTendeuses();
    }
}