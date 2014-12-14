package simulator.restservices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.common.DataPair;
import simulator.surfacemodel.SurfaceModelCalculator;

@Controller
@RequestMapping("/sf")
public class SurfaceModelController
{
    @RequestMapping("/x/{x}/y/{y}")
    public
    @ResponseBody
    String getPNR(@PathVariable String x, @PathVariable String y)
    {
        double xValue = Double.parseDouble(x);
        double yValue = Double.parseDouble(y);
        String result = "{ value :" + String.valueOf(SurfaceModelCalculator.getPNR(xValue, yValue)) + "}";
        return result.replace('.',',');
    }

    @RequestMapping("/y/{y}/pnr/{pnr}")
    public
    @ResponseBody
    Double getX(@PathVariable String y, @PathVariable String pnr)
    {
        double pnrValue = Double.parseDouble(pnr);
        double yValue = Double.parseDouble(y);

        return SurfaceModelCalculator.getX(yValue, pnrValue);
    }

    @RequestMapping("/x/{x}/pnr/{pnr}")
    public
    @ResponseBody
    String getY(@PathVariable String x, @PathVariable  String pnr)
    {
        double xValue = Double.parseDouble(x);
        double pnrValue = Double.parseDouble(pnr);

        String result = "{ value :" + String.valueOf(SurfaceModelCalculator.getY(xValue, pnrValue)) + "}";
        return result;
    }

    //@RequestMapping("/pnr/{pnr:/^\\d*.?\\d*$}")
    @RequestMapping("/pnr/{pnr:.+}")
    public
    @ResponseBody
    DataPair getXY(@PathVariable String pnr)
    {
        double pnrValue = Double.parseDouble(pnr);
        return SurfaceModelCalculator.getMinXY(pnrValue);
    }
}
