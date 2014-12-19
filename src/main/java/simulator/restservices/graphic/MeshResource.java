package simulator.restservices.graphic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.surfacemodel.ISurfaceDataMeshService;

/**
 * @author Juan Camilo Rada
 *
 * Mesh graphic data resource. Provide information about vertex and color of the model surface graphic.
 */
@Controller
@RequestMapping("/mesh")
public class MeshResource
{
    private final ISurfaceDataMeshService surfaceDataMeshService;

    @Autowired
    public MeshResource(final ISurfaceDataMeshService surfaceDataMeshService)
    {
        this.surfaceDataMeshService = surfaceDataMeshService;
    }

    @RequestMapping("/remi_prop")
    public
    @ResponseBody
    SurfaceMeshDTO getMesh()
    {
        return surfaceDataMeshService.getSurfaceMeshDTO();
    }
}
