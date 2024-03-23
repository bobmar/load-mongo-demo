package com.wellsfargo.copymongo.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EmployeeOra {
  private final String testData =
      "  {\n" +
      "    \"employeeId\": \"123\",\n" +
      "    \"employeeName\": \"abc\",\n" +
      "    \"salaries\": [\n" +
      "      {\n" +
      "        \"date\": \"2024-03-15\",\n" +
      "        \"salary\": 5000\n" +
      "      },\n" +
      "      {\n" +
      "        \"date\": \"2024-03-20\",\n" +
      "        \"salary\": 5000\n" +
      "      }\n" +
      "    ]\n" +
      "  }\n";

  private final String testData2 =
      "  {\n" +
      "    \"employeeId\": \"234\",\n" +
      "    \"employeeName\": \"bcd\",\n" +
      "    \"salaries\": [\n" +
      "      {\n" +
      "        \"date\": \"2024-03-15\",\n" +
      "        \"salary\": 5001\n" +
      "      },\n" +
      "      {\n" +
      "        \"date\": \"2024-03-20\",\n" +
      "        \"salary\": 5001\n" +
      "      }\n" +
      "    ]\n" +
      "  }\n";
  private final ObjectMapper mapper = new ObjectMapper();
  public List<String> retrieveEmployees() {
    return Arrays.asList(new String[]{testData, testData2});
  }
}
