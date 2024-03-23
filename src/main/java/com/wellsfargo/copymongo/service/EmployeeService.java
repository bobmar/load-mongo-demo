package com.wellsfargo.copymongo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.copymongo.dao.EmployeeCollection;
import com.wellsfargo.copymongo.dao.EmployeeOra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {
  private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
  private final String dbName = "demo";
  private final ObjectMapper mapper = new ObjectMapper();
  private EmployeeCollection employeeCollection = new EmployeeCollection(dbName);
  private EmployeeOra employeeOra = new EmployeeOra();

  public List<String> retrieveEmpOra() {
    return employeeOra.retrieveEmployees();
  }
  public void saveEmployees(List<String> employeeJson) {
    List<Map<String,Object>> employeeMapList = new ArrayList<>();
    employeeJson.forEach(json->{
      try {
        employeeMapList.add(mapper.readValue(json, Map.class));
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    });
    long deletedCnt = this.employeeCollection.deleteAll();
    LOGGER.info("Deleted {} documents", deletedCnt);
    this.employeeCollection.save(employeeMapList);
  }
}
