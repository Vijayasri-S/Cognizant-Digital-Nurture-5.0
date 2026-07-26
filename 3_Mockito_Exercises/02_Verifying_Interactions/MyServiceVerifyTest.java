package com.sample.mockito_demo;

// JUnit test annotation
import org.junit.jupiter.api.Test;

// Mockito core functions
import static org.mockito.Mockito.*;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {

        // STEP 1: Create mock object (fake API)
        ExternalAPI mockApi = mock(ExternalAPI.class);

        // STEP 2: Inject mock into service
        MyService service = new MyService(mockApi);

        // STEP 3: Call method under test
        // This internally calls mockApi.getData()
        service.fetchData();

        // STEP 4: VERIFY interaction
        // Check: did getData() method get called?
        verify(mockApi).getData();
    }
}