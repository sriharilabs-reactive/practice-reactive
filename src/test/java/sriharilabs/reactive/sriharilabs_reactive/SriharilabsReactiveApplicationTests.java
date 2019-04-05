package sriharilabs.reactive.sriharilabs_reactive;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SriharilabsReactiveApplicationTests {

	

	private static List<String> words = Arrays.asList(
	        "the",
	        "quick",
	        "brown",
	        "fox",
	        "jumped",
	        "over",
	        "the",
	        "lazy",
	        "dog"
	        );
	@Test
	  public void simpleCreation() {
	     Flux<String> fewWords = Flux.just("Hello", "World");
	     Flux<String> manyWords = Flux.fromIterable(words);

	     fewWords.subscribe(System.out::println);
	     System.out.println();
	     manyWords.subscribe(System.out::println);
	  }
	
	@Test
	public void findingMissingLetter() {
	  Flux<String> manyLetters = Flux
	        .fromIterable(words)
	        .flatMap(word -> Flux.fromArray(word.split("")))
	        .distinct()
	        .sort()
	        .zipWith(Flux.range(1, Integer.MAX_VALUE),
	              (ds, count) -> String.format("%2d... %s", count, ds));

	  manyLetters.subscribe(System.out::println);
	}
	
	@Test
	public void restoringMissingLetter() {
	  Mono<String> missing = Mono.just("s");
	  Flux<String> allLetters = Flux
	        .fromIterable(words)
	        .flatMap(word -> Flux.fromArray(word.split("")))
	        .concatWith(missing)
	        .distinct()
	        .sort()
	        .zipWith(Flux.range(1, Integer.MAX_VALUE),
	              (string, count) -> String.format("%2d. %s", count, string));

	  allLetters.subscribe(System.out::println);
	}
	
	@Test
	public void shortCircuit() throws InterruptedException {
	  Flux<String> helloPauseWorld = 
	              Mono.just("Hello")
	                  .concatWith(Mono.just("world"))
	                		  .delaySubscription(Duration.ofMillis(10));
	                  

	  helloPauseWorld.subscribe(System.out::println);
	  Thread.sleep(3);
	  System.out.println("ITS completed...");
	  
	}
	
	
	
}

