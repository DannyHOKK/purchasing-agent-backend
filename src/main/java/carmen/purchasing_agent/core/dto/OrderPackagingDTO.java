package carmen.purchasing_agent.core.dto;

import java.util.List;

public class OrderPackagingDTO {
    private List<String> orderIdList;
    private String packageName;

    public List<String> getOrderIdList() {
        return orderIdList;
    }

    public void setOrderIdList(List<String> orderIdList) {
        this.orderIdList = orderIdList;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
