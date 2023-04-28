package org.mvnsearch;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "hello-cli", mixinStandardHelpOptions = true, version = "hello 4.0",
        description = "Print hello to STDOUT.")
@Component
public class CliCommand implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "the name to welcome.")
    private String name = "Guest";
    @CommandLine.Option(names = {"-l", "--locale"}, description = "Locale, such as en, zh ..")
    private String locale = "en";

    @Override
    public Integer call() throws Exception {
        String welcome = "hello";
        if (locale.equalsIgnoreCase("zh")) {
            welcome = "你好";
        }
        System.out.println(welcome + " " + name);
        return 0;
    }

}
