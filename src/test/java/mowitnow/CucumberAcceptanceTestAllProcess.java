package mowitnow;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

public class CucumberAcceptanceTestAllProcess {
    private CommandsProcessor commandsProcessor;

    @Given("A commands processor")
    public void initCommandsProcessor() {
        commandsProcessor = new CommandsProcessor();
    }

    @When("Commands are : (.*)")
    public void setUpProcessor(List<String> commands) {
        commandsProcessor.setUp(commands);
    }

    @When("start processing")
    public void start_processing() {
        commandsProcessor.servePelouseWithTendeuses();
    }

    @Then("result should be : (.*)")
    public void result_should_be(List<String> expectedResults) {
        List<Tondeuse> listTondeuses = commandsProcessor.getPelouse().getMapTondeusesCommands().keySet().stream().collect(Collectors.toList());
        for (int i = 0; i < listTondeuses.size(); i++) {
            assertThat(listTondeuses.get(i).getPosition()).isEqualTo(expectedResults.get(i));
        }
    }
}