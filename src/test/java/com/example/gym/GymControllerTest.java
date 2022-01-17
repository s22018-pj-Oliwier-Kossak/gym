package com.example.gym;

import com.jayway.jsonpath.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GymControllerTest {

    @Autowired
    private MockMvc  MockMvc;



    @Test
    void shouldprintHelooWorld() throws Exception{
        MockMvc.perform(get("/Person")).andDo(print()).andExpect(status().isOk()).andExpect
                (content().string("hello World"));
    }

    @Test
    void BenchPressTest() throws Exception{

        MockMvc.perform(get("/Person/BenchPress2?wiek=2")
                        .param("imie","test")
                        .param("Nazwisko","test")).andDo(print()).andExpect(jsonPath("$.wiek", Matchers.is(2)))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":2,\"waga\":2,\"data\":\"data\",\"ciezar\":2.0,\"powtorzenia\":2.0,\"cwiczenie\":\"Bench Press\",\"maksymalny_ciezar\":2.0,\"poziom_sily\":1,\"nazwisko\":\"test\"}"));


    }
    @Test
    void BenchPressTest3() throws Exception{
      //  MockMvc.perform(get("/Person/method")).andExpect(MockMvcResultMatchers.status().is(200));
        MockMvc.perform(get("/Person/BenchPress2")
                .param("imie","test")
                .param("Nazwisko","test")
                .param("wiek","1")
                ).andDo(print()).andExpect(status().isOk()).andExpect(content().string("da"));





    }
    @Test
    void BenchPressTest2() throws Exception{
        MockMvc.perform(get("/Person/BenchPress")
                .param("imie","test")
                .param("Nazwisko","test")
                .param("wiek","1")
                .param("waga","1")
                .param("data","2")
                .param("ciezar","3")
                .param("powtorzenia","2")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":1,\"data\":\"2\",\"ciezar\":3.0,\"powtorzenia\":2.0,\"cwiczenie\":\"Bench Press\",\"maksymalny_ciezar\":3.0,\"poziom_sily\":1,\"nazwisko\":\"test\"}"));



    }
    //{imie}/{Nazwisko}/{wiek}/{waga}/{data}/{ciezar}/{powtorzenia}
}
