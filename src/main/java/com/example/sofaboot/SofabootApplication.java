package com.example.sofaboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class SofabootApplication {

	public static void main(String[] args) {
		System.out.println("run as: Client" );
		runAsClient(args);
	}

	private static void runAsClient(String[] args) {
		//change port to run in local machine
		//System.setProperty("server.port", "8081");
		SpringApplication springApplication = new SpringApplication(
				SofabootApplication.class);
		ApplicationContext applicationContext = springApplication.run(args);

		final AnnotationClientImpl annotationService = applicationContext
				.getBean(AnnotationClientImpl.class);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					String result = annotationService.sayClientAnnotation("annotation");
					System.out.println("invoke result:" + result);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		t.start();

	}
}
