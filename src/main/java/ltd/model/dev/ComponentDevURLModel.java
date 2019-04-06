package ltd.model.dev;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ComponentDevURLModel {

    private String            name;
    private List<DevURLModel> modelList;

    public ComponentDevURLModel() {
        modelList = new ArrayList<>();
    }
}
