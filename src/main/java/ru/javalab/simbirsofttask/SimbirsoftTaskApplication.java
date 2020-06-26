package ru.javalab.simbirsofttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import ru.javalab.simbirsofttask.service.Solve;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class SimbirsoftTaskApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SimbirsoftTaskApplication.class, args);
        Solve solve = applicationContext.getBean(Solve.class);
        if (args.length < 1 || args.length>2 ){
            System.err.println("Enter two args: First - link to download and count \n" +
                    "Second: type of save - \"db\" or \"file\" ");
            System.exit(1);
        }
        if (!args[1].equals("db") && !args[1].equals("file")) {
            System.err.println("Choose one of two implementations: db or file");
            System.exit(1);
        }
        solve.solve(args[0], args[1]);
    }
}
