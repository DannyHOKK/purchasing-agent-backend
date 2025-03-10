package carmen.purchasing_agent.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderPackagingDTO {
    private List<Integer> orderIdList;
    private String packageName;
    private String packagingToGoName;

}
