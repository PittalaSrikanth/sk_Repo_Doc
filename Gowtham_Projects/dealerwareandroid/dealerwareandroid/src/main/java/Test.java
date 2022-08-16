import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
public static void main(String[] args) {
	
//	Date date = new Date();
//	// Pattern 
//	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
//	LocalTime lt =LocalTime.parse(sdf.format(date));
//	System.out.println(lt);
//	System.out.println("TIME - " + sdf.format(date));
////Boolean isBetween = ( ! now.isBefore( LocalTime.of( 18 , 0 ) )  // "not before" means "is equal to OR after".
////   && 
////   now.isBefore( LocalTime.of( 18 , 30 ) ) ;  // Half-Open, beginning is *inclusive* while ending is *exclusive*.
	
	
	//Getting time
	LocalTime t2 = LocalTime.now();
	// Pattern
	DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
	String text = t2.format(df);
	System.out.println("Time - " + text);
	
	LocalTime currentTime = LocalTime.of(Integer.parseInt(text.split(":")[0]), Integer.parseInt(text.split(":")[1]));
	System.out.println(currentTime);
	
	
	if(currentTime.isAfter( LocalTime.of( 0, 0 ) )  && currentTime.isBefore( LocalTime.of( 6, 0 ) ))
		System.out.println("slot1");
	else if((currentTime.isAfter( LocalTime.of( 6, 0 ) )  && currentTime.isBefore( LocalTime.of( 12, 0 ) )))
		System.out.println("slot2");
	else if((currentTime.isAfter( LocalTime.of( 12, 0 ) )  && currentTime.isBefore( LocalTime.of( 18, 0 ) )))
		System.out.println("slot3");
	else
		System.out.println("slot4");
	
	
//	if( lt.isAfter( LocalTime.of( 10, 0 ) ) && lt.isBefore( LocalTime.of( 18, 0 ) ) )
//		System.out.println( "Yes" );
//	else System.out.println( "No" );
	
	
}
}
