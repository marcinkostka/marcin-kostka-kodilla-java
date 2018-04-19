package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindServiceTestSuite {

    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    FindService findService;

    @Test
    public void findEmployeesByNamePattern() throws FindServiceException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieCarmi = new Employee("Stephanie", "Carmi");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieCarmi);

        //When
        List<Employee> employeesByPattern = findService.findEmployeesByNamePattern("mi");

        //Then
        Assert.assertEquals(2,employeesByPattern.size());

        //CleanUp
        try {
            employeeDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void findCompaniesByNamePattern() throws FindServiceException {
        //Given
        Company dataMaesters = new Company("Great Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When
        List<Company> companiesByPattern = findService.findCompaniesByNamePattern("te");

        //Then
        Assert.assertEquals(2,companiesByPattern.size());

        //CleanUp
        try {
            companyDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }
}