package com.schoolmate.admissionregistration.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Utility {
    public static Integer ageCalculator(Date date){
        log.info("Calculating age when date of birth is: [{}]", date);
        long differenceInMillis = new Date().getTime() - date.getTime();
        // Adding 5 hours to handle leap year
        long differenceInYears = differenceInMillis / (1000L * 60L * 60L * 24L * 365L + (5L * 60L * 60L * 24L));
        log.info("Calculated Age is: [{}]", differenceInYears);
        return Math.toIntExact(differenceInYears);
    }
}
