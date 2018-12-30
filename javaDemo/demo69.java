import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class demo69 {
	public static void main(String[] args) {
		demo69 demo = new demo69();
		
		switch (5) {
		default:
			return;
		case 0:
			demo.test();
			break;
		case 1:
			demo.testDur();
			break;
		case 2:
			demo.testInstant();
			break;
		case 3:
			demo.testLocalDate();
			break;
		case 4:
			demo.testLocalTime();
			break;
		case 5:
			demo.testLocalDateTime();
			break;
			// TODO: ADD TEST HERE
		}
 	}
	
	public void test() {
		/*---Clock---*/
		Clock clock = Clock.systemUTC();
		System.out.println("[Clock_instant]" + clock.instant());
		System.out.println("[Clock_getZone]" + clock.getZone());
		System.out.println("[Clock]" + Clock.systemDefaultZone() + "\n");
		
		System.out.println("[millis]" + clock.millis());
		System.out.println("[System_CurrentTimeMillis]" + System.currentTimeMillis() + "\n");
		
		
		
		System.out.println("[_INSTANT_NOW]" + Instant.now());
	}
	
	public void testDur() {
		/*---Duration---*/
		Duration duration1 = Duration.ofSeconds(10);
		Duration duration2 = Duration.ofMinutes(10);
		
		System.out.println("[Duration]" + duration1.getSeconds() + "(s)");
		System.out.println("[Duration]" + (duration2.minus(duration1).getSeconds()) + "(s)\n");
	}
	
	public void testInstant() {
		Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
		System.out.println("[Instant]" + instant.toEpochMilli());
		System.out.println("[Instant]" + instant.toString());
		System.out.println("[Instant]" + instant.minusSeconds(6000) + "\n");
		
		Instant instant1 = Instant.parse("2018-12-30T15:45:01.257039400Z");
		System.out.println("[Instant]" + instant1.plusSeconds(3600).toString());
		System.out.println("[Instant1_5_days_ago]" + instant1.minus(Duration.ofDays(5)) + "\n");
	}
	
	public void testLocalDate() {
		LocalDate ld1 = LocalDate.now();
		
		System.out.println("[LocalDate]" + "今天是一年的第" + ld1.getDayOfYear() + "天");
		System.out.println("[LocalDate]" + ld1 + "\n");
		
		LocalDate ld2 = LocalDate.of(2014, 01, 02);
		System.out.println("[LocalDate]" + ld2);
	}
	
	public void testLocalTime() {
		LocalTime ltime = LocalTime.of(23, 01);
		
		System.out.println("[LocalTime]" + ltime);
		System.out.println("[LocalTime]" + "现在是一分钟内的"
				 + LocalTime.now().getSecond() + "秒");
	}
	
	public void testLocalDateTime() {
		LocalDateTime ldt1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		LocalDateTime ldt2 = LocalDateTime.now();
		
		System.out.println("[LocalDateTime_ldt1]" + ldt1);
		System.out.println("[LocalDateTime_ldt2]" + ldt2);
	}
}
