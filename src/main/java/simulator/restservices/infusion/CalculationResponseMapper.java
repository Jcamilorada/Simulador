package simulator.restservices.infusion;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import simulator.domain.common.Patient;
import simulator.domain.infusion.CalculationResponse;
import simulator.dto.CalculationResponseDTO;
import simulator.dto.PatientDTO;

@Component
public class CalculationResponseMapper extends PropertyMap<CalculationResponse, CalculationResponseDTO>
{
    @Override
    protected void configure()
    {
        map().setErrorCode(source.getErrorCode().getValue());
    }
}
