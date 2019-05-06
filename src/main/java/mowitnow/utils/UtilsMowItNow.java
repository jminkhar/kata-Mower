package mowitnow.utils;

import mowitnow.enums.Orders;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UtilsMowItNow {

    public static List readCommandsFromFile(File commandsFile) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(commandsFile))){
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw e;
        }
        return lines;
    }
    public static List<Orders> convertToListCommands(String commands){
        return Arrays.stream(commands.split(""))
                .map(c-> Orders.getNameByCode(c))
                .filter(c->!c.equals(Orders.NULL))
                .collect(Collectors.toList());
    }
}
