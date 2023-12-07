package pl.jbazil.javabase.classis.orm.web;
/*
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;
import static org.assertj.core.api.Assertions.assertThat;

import pl.jbazil.javabase.classis.orm.web.model.CreateRandomProductRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

@SpringBootTest(classes = TestClassicOrmApplication.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateRandomProduct() throws Exception {
        String productName = "testProduct";
        Long categoryId = 1L;
        String code = "code";
        ProductModel productModel = new ProductModel(null, productName, code, BigDecimal.ONE, categoryId);
        CreateRandomProductRequest createRequest = new CreateRandomProductRequest(productName, categoryId);

        Mockito.when(productService.createRandom(productName, categoryId)).thenReturn(productModel);

        String response = mockMvc.perform(MockMvcRequestBuilders.post("/products/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        
        ProductModel responseModel = objectMapper.readValue(response, ProductModel.class);

        assertThat(responseModel.categoryId()).isEqualTo(categoryId);
        assertThat(responseModel.name()).isEqualTo(productName);
    }
}*/