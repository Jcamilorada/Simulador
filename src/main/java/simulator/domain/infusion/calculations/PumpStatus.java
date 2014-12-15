package simulator.domain.infusion.calculations;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PumpStatus
{
    private List<Double> effectSiteUdf;
    private List<Double> plasmaUdf;
    @Getter
    private double temp1;
    @Getter
    private double temp2;
    @Getter
    private double temp3;
    @Getter
    private double temp4;
    @Getter
    private double pTemp1;
    @Getter
    private double pTemp2;
    @Getter
    private double pTemp3;

    PumpStatus(final int maximumTime)
    {
        effectSiteUdf = new ArrayList<>(maximumTime);
        plasmaUdf = new ArrayList<>(maximumTime);
        temp1 = 0;
        temp2 = 0;
        temp3 = 0;
        temp4 = 0;
        pTemp1 = 0;
        pTemp2 = 0;
        pTemp3 = 0;
        effectSiteUdf.add(0D);
        plasmaUdf.add(0D);
    }

    PumpStatus(final PumpStatus pumpStatus)
    {
        effectSiteUdf = new ArrayList<>(pumpStatus.effectSiteUdf);
        plasmaUdf = new ArrayList<>(pumpStatus.plasmaUdf);
        temp1 = pumpStatus.temp1;
        temp2 = pumpStatus.temp2;
        temp3 = pumpStatus.temp3;
        temp4 = pumpStatus.temp4;
        pTemp1 = pumpStatus.pTemp1;
        pTemp2 = pumpStatus.pTemp2;
        pTemp3 = pumpStatus.pTemp3;
    }

    /**
     * Convenient method to store the actual status of the algorithm.
     * This method will always add to the end of the lists.
     *
     * @param temp1
     * @param temp2
     * @param temp3
     * @param temp4
     */
    void storeEffectSiteUdfValue(
        final double temp1, final double temp2, final double temp3, final double temp4)
    {
        this.effectSiteUdf.add(temp1 + temp2 + temp3 + temp4);
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
    }

    /**
     * Convenient method to store the actual status of the algorithm for plasma.
     * This method will always add to the end of the lists.
     *
     * @param pTemp1
     * @param pTemp2
     * @param pTemp3
     */
    void storePlasmaUdfValue(final double pTemp1, final double pTemp2, final double pTemp3)
    {
        this.plasmaUdf.add(pTemp1 + pTemp2 + pTemp3);
        this.pTemp1 = pTemp1;
        this.pTemp2 = pTemp2;
        this.pTemp3 = pTemp3;
    }

    double getLatestEffectSiteUdf()
    {
        return effectSiteUdf.get(effectSiteUdf.size() - 1);
    }

    public List<Double> getPlasmaUdf() {
        return new ArrayList<>(plasmaUdf);
    }

    public List<Double> getEffectSiteUdf() {
        return new ArrayList<>(effectSiteUdf);
    }
}
