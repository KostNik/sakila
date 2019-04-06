package ltd.model.dev;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DevURLModel {

    private String type;
    private String urlPath;
    private String description;


}
