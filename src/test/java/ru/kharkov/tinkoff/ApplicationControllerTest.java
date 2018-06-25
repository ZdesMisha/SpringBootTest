package ru.kharkov.tinkoff;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.kharkov.tinkoff.repository.ApplicationRepository;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationRepository applicationRepository;

    @Before
    public void init() {
        when(applicationRepository.findLatestByContractId(1L)).thenReturn(TestUtils.prepareApplication());
    }

    @Test
    public void findLatestByContractIdJson() throws Exception {
        this.mockMvc.perform(get("/application/findLatestByContractIdJson")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(document("find-latest-by-contract-id-json",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(parameterWithName("id").description("Id контракта")),
                        relaxedResponseFields(
                                fieldWithPath("application_id").description("Id заявки"),
                                fieldWithPath("dt_created").description("Дата создания"),
                                fieldWithPath("product_name").description("Название продукта"),
                                fieldWithPath("contract_id").description("Id контракта"))));
    }

    @Test
    public void findLatestByContractIdXml() throws Exception {
        this.mockMvc.perform(get("/application/findLatestByContractIdXml")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andDo(document("find-latest-by-contract-id-xml",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(parameterWithName("id").description("Id контракта"))));
    }
}
