package simulator.restservices;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import simulator.domain.SystemParameter;
import simulator.services.systemparameter.ISystemParameterService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ParametersControllerTest
{
    @Mock
    ISystemParameterService mockSystemParameterService;

    private static final int PARAMETER_ID = 1;
    private static final String PARAMETER_NAME = "PARAMETER_NAME";

    private ParametersController testInstance;

    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        SystemParameter systemParameter = new SystemParameter();
        systemParameter.setId(1L);
        systemParameter.setName(PARAMETER_NAME);

        MockitoAnnotations.initMocks(this);
        testInstance = new ParametersController(mockSystemParameterService);
        mockMvc = standaloneSetup(testInstance).build();

        when(mockSystemParameterService.getSystemParameter(PARAMETER_ID)).thenReturn(systemParameter);
    }

    @Test
    public void testGetParameter() throws Exception
    {
        mockMvc.perform(get("/parameters/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$.id").value(PARAMETER_ID)).andExpect(jsonPath("$.name").value(PARAMETER_NAME));
    }
}
