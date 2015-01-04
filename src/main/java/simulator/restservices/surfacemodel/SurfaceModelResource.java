package simulator.restservices.surfacemodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.common.DataPair;
import simulator.domain.surfacemodel.SurfaceModelCalculator;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/sf")
public class SurfaceModelResource
{
    @RequestMapping("/x/{x}/y/{y}")
    public
    @ResponseBody
    CalculationResponseDTO getPNR(@PathVariable String x, @PathVariable String y)
    {
        double xValue = Double.parseDouble(x);
        double yValue = Double.parseDouble(y);
        double value = SurfaceModelCalculator.getPNR(xValue, yValue);

        return new CalculationResponseDTO(value);
    }

    @RequestMapping("/y/{y}/pnr/{pnr:.+}")
    public
    @ResponseBody
    CalculationResponseDTO getX(@PathVariable String y, @PathVariable String pnr)
    {
        double pnrValue = Double.parseDouble(pnr);
        double yValue = Double.parseDouble(y);
        double value =  SurfaceModelCalculator.getX(yValue, pnrValue);

        return new CalculationResponseDTO(value);
    }

    @RequestMapping("/x/{x}/pnr/{pnr:.+}")
    public
    @ResponseBody
    CalculationResponseDTO getY(@PathVariable String x, @PathVariable  String pnr)
    {
        double xValue = Double.parseDouble(x);
        double pnrValue = Double.parseDouble(pnr);
        double value = SurfaceModelCalculator.getY(xValue, pnrValue);

        return new CalculationResponseDTO(value);
    }

    @RequestMapping("/pnr/{pnr:.+}")
    public
    @ResponseBody
    DataPair getXY(@PathVariable String pnr)
    {
        double pnrValue = Double.parseDouble(pnr);
        return SurfaceModelCalculator.getMinXY(pnrValue);
    }

    @RequestMapping(value = "/pnr_list", method = RequestMethod.PUT)
    public @ResponseBody List<Double>  pnrValues(final @RequestBody PNRCalculationRequestDTO pnrCalculationRequestDTO)
    {
        List<Double> pnrListValues = SurfaceModelCalculator.caculateListPNR(pnrCalculationRequestDTO.getXvalues(), pnrCalculationRequestDTO.getYvalues());

        return pnrListValues;
    }

}
