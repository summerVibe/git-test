package my;

import java.util.Arrays;

public class Lambda_test {
	
	@org.junit.Test
	public void test1(){
		/*Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );*/
		
		/*Arrays.asList( "a", "b", "d" ).forEach( e -> {
		    System.out.print( e );
		    System.out.print( e );
		} );*/
		
		/*Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );*/
		
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
	}

}
