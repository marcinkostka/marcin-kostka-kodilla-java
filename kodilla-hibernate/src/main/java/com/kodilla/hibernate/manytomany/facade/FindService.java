package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(FindService.class);

    public List<Employee> findEmployeesByNamePattern(String pattern) throws FindServiceException {
        List<Employee> result = employeeDao.findEmployeesByNamePattern(pattern);

        if(result.size() == 0) {
            LOGGER.info(FindServiceException.ERR_EMPLOYEE_NOT_FOUND);
            throw new FindServiceException(FindServiceException.ERR_EMPLOYEE_NOT_FOUND);
        } else {
            return result;
        }
    }

    public List<Company> findCompaniesByNamePattern(String pattern) throws FindServiceException {
        List<Company> result = companyDao.findCompaniesByNamePattern(pattern);

        if(result.size() == 0) {
            LOGGER.info(FindServiceException.ERR_COMPANY_NOT_FOUND);
            throw new FindServiceException(FindServiceException.ERR_COMPANY_NOT_FOUND);
        } else {
            return result;
        }
    }
}