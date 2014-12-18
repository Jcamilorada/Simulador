package simulator.restservices.graphic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.surfacemodel.ISurfaceDataMeshService;
import simulator.dto.SurfaceMeshDTO;

@Controller
@RequestMapping("/mesh")
public class MeshResource
{
    private ISurfaceDataMeshService surfaceDataMeshService;

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
