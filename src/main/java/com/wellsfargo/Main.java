package com.wellsfargo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.copymongo.service.EmployeeService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  private final static ObjectMapper mapper = new ObjectMapper();
  public static void main(String[] args) {
    EmployeeService service = new EmployeeService();
    service.saveEmployees(service.retrieveEmpOra());
  }
}