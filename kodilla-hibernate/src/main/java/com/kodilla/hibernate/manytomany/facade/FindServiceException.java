package com.kodilla.hibernate.manytomany.facade;

public class FindServiceException extends Exception {

    public static String ERR_EMPLOYEE_NOT_FOUND = "No results for pattern";
    public static String ERR_COMPANY_NOT_FOUND = "No results for pattern";

    public FindServiceException(String message) {
        super(message);
    }
}
