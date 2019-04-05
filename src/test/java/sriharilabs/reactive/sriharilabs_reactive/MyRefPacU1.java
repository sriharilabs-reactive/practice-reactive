package sriharilabs.reactive.sriharilabs_reactive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRefPacU1 {

	
	class FibonacciPublisher implements Publisher<Integer> {

		@Override
		@Test
	    public void subscribe(Subscriber<? super Integer> subscriber) {
	        int count = 0, a = 0, b = 1;
	        while (count < 50) {
	            int sum = a + b;
	            subscriber.onNext(b);
	            a = b;
	            b = sum;
	            count++;
	        }
	        subscriber.onComplete();
	    }
		
		@Test
		public void show() {
			FibonacciPublisher f=new FibonacciPublisher();
			f.subscribe(12);
		}
		
	}
	@Test
	public void show() {
		System.out.println("its working..");
	}
}
