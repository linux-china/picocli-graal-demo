package org.mvnsearch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
public class PicoCliRunner implements CommandLineRunner, ExitCodeGenerator {
    private final CliCommand cliCommand;
    private final IFactory factory;
    private int exitCode;

    public PicoCliRunner(CliCommand cliCommand, IFactory factory) {
        this.cliCommand = cliCommand;
        this.factory = factory;
    }

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(cliCommand, factory)
                .setUnmatchedArgumentsAllowed(true)
                .execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
