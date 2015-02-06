package simulator.domain.infusion.calculations;

import java.util.ArrayList;
import java.util.List;

public class PumpStatus
{
    private List<ESCComponentValues> effectSiteUdf;
    private List<PlasmaComponentValues> plasmaUdf;

    PumpStatus(final PumpStatus pumpStatus)
    {
        effectSiteUdf = new ArrayList<>(pumpStatus.effectSiteUdf);
        plasmaUdf = new ArrayList<>(pumpStatus.plasmaUdf);
    }

    PumpStatus(
        final ESCComponentValues effectSiteValues,
        final PlasmaComponentValues plasmaValues,
        final int maximumTime) {
        effectSiteUdf = new ArrayList<>(maximumTime);
        plasmaUdf = new ArrayList<>(maximumTime);
        storeEffectSiteUdfValue(
            effectSiteValues.getC1(),
            effectSiteValues.getC2(),
            effectSiteValues.getC3(),
            effectSiteValues.getC4());
        storePlasmaUdfValue(plasmaValues.getP1(), plasmaValues.getP2(), plasmaValues.getP3());
    }

    public List<PlasmaComponentValues> getPlasmaUdf()
    {
        return new ArrayList<>(plasmaUdf);
    }

    public List<ESCComponentValues> getEffectSiteUdf()
    {
        return new ArrayList<>(effectSiteUdf);
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
        this.effectSiteUdf.add(new ESCComponentValues(temp1, temp2, temp3, temp4));
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
        this.plasmaUdf.add(new PlasmaComponentValues(pTemp1, pTemp2, pTemp3));
    }

    ESCComponentValues getLatestEffectSiteUdf()
    {
        return effectSiteUdf.get(effectSiteUdf.size() - 1);
    }

    PlasmaComponentValues getLatestPlasmaUdf()
    {
        return plasmaUdf.get(plasmaUdf.size() -1);
    }
}
