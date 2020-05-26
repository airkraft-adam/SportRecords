package adam.biegi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class BiegiApplication {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		ConfigurableApplicationContext ctx = SpringApplication.run(BiegiApplication.class, args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DeskApi deskapi = ctx.getBean(DeskApi.class);
				deskapi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				deskapi.setVisible(true);

			}
		});
	}
}
