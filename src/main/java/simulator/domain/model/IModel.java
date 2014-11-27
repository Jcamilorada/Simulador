package simulator.domain.model;

/**
 * Created by alevalv on 11/18/14.
 */
public interface IModel {
    /**
     * Gets the microrate constants between compartments. The necessary values are:
     * <ul>
     *     <li>K(1,0)</li>
     *     <li>K(1,2)</li>
     *     <li>K(1,3)</li>
     *     <li>K(1,4)</li>
     *     <li>K(2,1)</li>
     *     <li>K(3,1)</li>
     *     <li>K(4,1)</li>
     * </ul>
     * @param from
     * @param to
     * @return
     */
    double getK(int from, int to);

    /**
     * Gets the central volume of the patient, value must be on milliliters. Maybe is the amount of blood idk.
     *
     * @return the central volume of the patient.
     */
    double getCentralVolume();
}
