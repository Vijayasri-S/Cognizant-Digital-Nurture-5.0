package com.sample.mockito_demo;

// JUnit assertion (used to check expected vs actual)
import static org.junit.jupiter.api.Assertions.assertEquals;

// Mockito stubbing method
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test  // tells JUnit this is a test method
    public void testExternalApi() {

        // STEP 1: Create a MOCK (fake object) of ExternalAPI
        // This is NOT real ExternalAPI object anymore
        ExternalAPI mockApi = Mockito.mock(ExternalAPI.class);

        // STEP 2: STUB method behavior
        // When getData() is called on mockApi,
        // DON'T call real method, instead return "Mock Data"
        when(mockApi.getData()).thenReturn("Mock Data");

        // STEP 3: Inject mock into service
        // MyService now uses fake API instead of real API
        MyService service = new MyService(mockApi);

        // STEP 4: Call service method
        // Internally it calls mockApi.getData()
        String result = service.fetchData();

        // STEP 5: Print result (for learning/debugging only)
        System.out.println("OUTPUT: " + result);

        // STEP 6: Assert (check correctness)
        // Expected = "Mock Data"
        // Actual = result from service
        assertEquals("Mock Data", result);
    }
}