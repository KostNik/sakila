package ltd.model.dev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FillUrlList {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ComponentDevURLModel> componentDevURLModels = new ArrayList<>();

        ComponentDevURLModel componentDevURLModel = new ComponentDevURLModel();
        componentDevURLModel.setName("Actor urls");

        componentDevURLModel.getModelList().add(DevURLModel.builder().type("JSON").urlPath("/rest/actors").description("Get All actors").build());
        componentDevURLModel.getModelList().add(DevURLModel.builder().type("JSON").urlPath("/rest/actors/actor?id={value}").description("GET/PUT Actor by id").build());
        componentDevURLModel.getModelList().add(DevURLModel.builder().type("JSON").urlPath("/rest/actors/actor?id={value}").description("Create (POST) Actor").build());
        componentDevURLModel.getModelList().add(DevURLModel.builder().type("JSON").urlPath("/rest/actors/fullName: firstName={value}, lastName={value}").description("Get Actors by name").build());

        componentDevURLModel.getModelList().add(DevURLModel.builder().type("PAGE").urlPath("/web/actors/all").description("Get All actors").build());
        componentDevURLModel.getModelList().add(DevURLModel.builder().type("PAGE").urlPath("/web/actors/actor/{id}").description("GET Actor by id").build());

        componentDevURLModels.add(componentDevURLModel);

        URL url = FillUrlList.class.getResource("/WEB-INF/urls.json");

        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(url.getFile()));
        objectMapper.writeValue(outputStream, Collections.singletonList(componentDevURLModel));
        outputStream.close();
    }
}
