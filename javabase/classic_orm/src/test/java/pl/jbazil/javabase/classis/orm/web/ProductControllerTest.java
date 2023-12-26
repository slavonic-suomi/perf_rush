package pl.jbazil.javabase.classis.orm.web;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import pl.jbazil.javabase.classis.orm.web.model.product.CreateRandomProductRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

@SpringBootTest(classes = TestClassicOrmApplication.class)
@AutoConfigureMockMvc
@DisabledInAotMode
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateRandomProduct() throws Exception {
        String productName = "test_create_random_name";
        Long categoryId = 1L;
        String code = "test_create_random_code";
        ProductModel productModel = new ProductModel(null, productName, code, BigDecimal.ONE, categoryId);
        CreateRandomProductRequest createRequest = new CreateRandomProductRequest(productName, categoryId);
        System.out.println(createRequest);

        Mockito.when(productService.createRandom(productName, categoryId)).thenReturn(productModel);

        String response = mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk()
                )
                .andReturn().getResponse().getContentAsString();

        ProductModel responseModel = objectMapper.readValue(response, ProductModel.class);

        assertThat(responseModel.categoryId()).isEqualTo(categoryId);
        assertThat(responseModel.name()).isEqualTo(productName);
    }

    @Test
    public void testUpdateRating() throws Exception {
        //update rating
        Mockito.when(productService.updateRating(anyLong(), any(BigDecimal.class))).then((Answer<ProductModel>) invocation -> new ProductModel(
                invocation.getArgument(0, Long.class),
                "updated product name",
                "updated product code",
                invocation.getArgument(1, BigDecimal.class),
                1L
        ));

        String updateRequestContent = """
                {"rating":"4.99"}
                """;
        System.out.println(updateRequestContent);

        String response = mockMvc.perform(
                        MockMvcRequestBuilders.put("/products/123/rating")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(updateRequestContent)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        ProductModel responseModel = objectMapper.readValue(response, ProductModel.class);

        assertThat(responseModel.id()).isEqualTo(123L);
        assertThat(responseModel.rating().toPlainString()).isEqualTo("4.99");

    }
}