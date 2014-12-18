package simulator.restservices.parameter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import simulator.domain.parameter.Parameter;
import simulator.domain.parameter.IParameterService;
import simulator.restservices.parameter.ParameterResource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ParameterResourceTest
{
    @Mock
    IParameterService mockSystemParameterService;

    private static final int PARAMETER_ID = 1;
    private static final String PARAMETER_NAME = "PARAMETER_NAME";

    private ParameterResource testInstance;

    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        Parameter parameter = new Parameter();
        parameter.setId(1L);
        parameter.setName(PARAMETER_NAME);

        MockitoAnnotations.initMocks(this);
        testInstance = new ParameterResource(mockSystemParameterService, null);
        mockMvc = standaloneSetup(testInstance).build();

        when(mockSystemParameterService.getSystemParameter(PARAMETER_ID)).thenReturn(parameter);
    }

    @Test
    public void testGetParameter() throws Exception
    {
        mockMvc.perform(get("/parameters/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$.id").value(PARAMETER_ID)).andExpect(jsonPath("$.name").value(PARAMETER_NAME));
    }
}
