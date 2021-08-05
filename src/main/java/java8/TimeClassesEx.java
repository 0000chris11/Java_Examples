package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class TimeClassesEx {

    private void localTimes() {
        LocalDate date1 = LocalDate.of(1996, 01, 30);
        LocalDate date2 = LocalDate.now();
        System.out.println("DATE: " + date1.isBefore(date2));

        LocalTime time1 = LocalTime.of(12, 30, 59);
        LocalTime time2 = LocalTime.now();
        System.out.println("TIME: " + time1.isBefore(time2));

        LocalDateTime dateTime1 = LocalDateTime.of(1996, 01, 30, 12, 30, 59);
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println("DATETIME: " + dateTime1.isBefore(dateTime2));
    }

    private void timeMeasure() {
        try {
            Instant init = Instant.now();
            Thread.sleep(1000);
            Instant end = Instant.now();
            System.out.println("timeMeasure: " + Duration.between(init, end));

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void dateMeasure(){
        LocalDate birthDate = LocalDate.of(1996, 01, 30);
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        System.out.println("dateMeasure: " + period.getYears() + " - " + period.getMonths() + " - " + period.getDays());
    }

    private void formatterEx(){
        String date = "30/01/1996";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        System.out.println("formatterEx: " + birthDate);
        System.out.println("formatterEx formatter: " + formatter.format(birthDate));
    }

    public static void main(String[] args) {
        TimeClassesEx ex = new TimeClassesEx();
        ex.localTimes();
        ex.timeMeasure();
        ex.dateMeasure();
        ex.formatterEx();

        
    }
}
