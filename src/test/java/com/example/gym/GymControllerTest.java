package com.example.gym;

import com.jayway.jsonpath.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;



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
        MockMvc.perform(get("/Person/BenchPress")
                .param("imie","test")
                .param("Nazwisko","test")
                .param("wiek","1")
                .param("waga","1")
                .param("data","2")
                .param("ciezar","3")
                .param("powtorzenia","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":1,\"data\":\"2\",\"ciezar\":3.0,\"powtorzenia\":2.0,\"cwiczenie\":\"Bench Press\",\"maksymalny_ciezar\":3.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));

    }

    @Test
    void BenchPressTest2() throws Exception{
        MockMvc.perform(get("/Person/BenchPress/test/test/1/2/02-03-2020/100/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":2,\"data\":\"02-03-2020\",\"ciezar\":100.0,\"powtorzenia\":5.0,\"cwiczenie\":\"Bench Press\",\"maksymalny_ciezar\":117.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));

    }

    @Test
    void Deadlift() throws Exception{
        MockMvc.perform(get("/Person/Deadlift")
                        .param("imie","test")
                        .param("Nazwisko","test")
                        .param("wiek","1")
                        .param("waga","1")
                        .param("data","2")
                        .param("ciezar","3")
                        .param("powtorzenia","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":1,\"data\":\"2\",\"ciezar\":3.0,\"powtorzenia\":2.0,\"cwiczenie\":\"Deadlift\",\"maksymalny_ciezar\":3.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));


    }
    @Test
    void DeadliftTest2() throws Exception{
        MockMvc.perform(get("/Person/Deadlift/test/test/1/2/02-03-2020/100/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":2,\"data\":\"02-03-2020\",\"ciezar\":100.0,\"powtorzenia\":5.0,\"cwiczenie\":\"Deadlift\",\"maksymalny_ciezar\":115.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));

    }
    @Test
    void Squat() throws Exception{
        MockMvc.perform(get("/Person/Squat")
                        .param("imie","test")
                        .param("Nazwisko","test")
                        .param("wiek","1")
                        .param("waga","1")
                        .param("data","2")
                        .param("ciezar","3")
                        .param("powtorzenia","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":1,\"data\":\"2\",\"ciezar\":3.0,\"powtorzenia\":2.0,\"cwiczenie\":\"Squat\",\"maksymalny_ciezar\":3.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));


    }
    @Test
    void SquatTest2() throws Exception{
        MockMvc.perform(get("/Person/Squat/test/test/1/2/02-03-2020/100/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":2,\"data\":\"02-03-2020\",\"ciezar\":100.0,\"powtorzenia\":5.0,\"cwiczenie\":\"Squat\",\"maksymalny_ciezar\":114.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));

    }
    @Test
    void ShoulderPressTest() throws Exception{
        MockMvc.perform(get("/Person/ShoulderPress")
                        .param("imie","test")
                        .param("Nazwisko","test")
                        .param("wiek","1")
                        .param("waga","1")
                        .param("data","2")
                        .param("ciezar","3")
                        .param("powtorzenia","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":1,\"data\":\"2\",\"ciezar\":3.0,\"powtorzenia\":2.0,\"cwiczenie\":\"Shoulder Press\",\"maksymalny_ciezar\":3.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));


    }
    @Test
    void ShoulderPressTest2() throws Exception{
        MockMvc.perform(get("/Person/Squat/test/test/1/2/02-03-2020/100/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"imie\":\"test\",\"wiek\":1,\"waga\":2,\"data\":\"02-03-2020\",\"ciezar\":100.0,\"powtorzenia\":5.0,\"cwiczenie\":\"Squat\",\"maksymalny_ciezar\":114.0,\"poziom_sily\":5,\"nazwisko\":\"test\"}"));

    }


}
