package com.example.gym;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class GymServiceTest2 {

    @Autowired
    private GymService GymService;

    @MockBean
    private GymRepository GymRepository;

    @Test
    void ImieTest(){
        Person person = new Person("","Nazwisko",12,22,"2222",70,12,
                "Shoulder Press",120,1);
        String imie= GymService.Imie(person,"imie");
        assertThat(imie).isEqualTo("imie");


    }
    @Test
    void ImieTest2(){
        Person person = new Person(null,"Nazwisko",12,22,"2222",70,12,
                "Shoulder Press",120,1);
        String imie= GymService.Imie(person,"imie");
        assertThat(imie).isEqualTo("imie");


    }
    @Test
    void ImieTest3(){
        Person person = new Person("imie","Nazwisko",12,22,"2222",70,12,
                "Shoulder Press",120,1);
        String imie= GymService.Imie(person,null);
        assertThat(imie).isEqualTo("imie");


    }

    @Test
    void NazwiskoTest(){
        Person person = new Person("",null,12,22,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Nazwisko(person);
        assertThat(person.getNazwisko()).isEqualTo("Kowalski");
    }
    @Test
    void NazwiskoTest2(){
        Person person = new Person("","random",12,22,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Nazwisko(person);
        assertThat(person.getNazwisko()).isEqualTo("random");
    }

    @Test
    void WiekTest(){
        Person person = new Person("","random",17,22,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Wiek(person);
        assertThat(person.getWiek()).isEqualTo(18);
    }

    @Test
    void WiekTest2(){
        Person person = new Person("","random",23,22,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Wiek(person);
        assertThat(person.getWiek()).isEqualTo(23);
    }

    @Test
    void WagaTest(){
        Person person = new Person("","random",23,22,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Waga(person);
        assertThat(person.getWaga()).isEqualTo(44);
    }
    @Test
    void WagaTest2(){
        Person person = new Person("","random",23,50,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Waga(person);
        assertThat(person.getWaga()).isEqualTo(50);
    }

    @Test
    void WagaTest3(){
        Person person = new Person("","random",23,80,"2222",70,12,
                "Shoulder Press",120,1);
        GymService.Waga(person);
        assertThat(person.getWaga()).isEqualTo(50);
    }

    @Test
    void DataTest(){
        Person person = new Person("","random",23,80,"02-03-2022",70,12,
                "Shoulder Press",120,1);
        GymService.Data(person);
        assertThat(person.getData()).isEqualTo("02-03-2022");
    }

    @Test
    void DataTest2(){
        Person person = new Person("","random",23,80,"",70,12,
                "Shoulder Press",120,1);
        GymService.Data(person);
        assertThat(person.getData()).isEqualTo("01-01-2022");
    }

    @Test
    void CiezarTest(){
        Person person = new Person("","random",23,22,"02-03-2222",-2,12,
                "Shoulder Press",120,1);
        GymService.Ciezar(person,50);
        assertThat(person.getCiezar()).isEqualTo(50);
    }

    @Test
    void CiezarTest2(){
        Person person = new Person("","random",23,22,"02-03-2222",60,12,
                "Shoulder Press",120,1);
        GymService.Ciezar(person,50);
        assertThat(person.getCiezar()).isEqualTo(60);
    }

    @Test
    void PowtorzeniaTest(){
        Person person = new Person("","random",23,22,"02-03-2222",60,-2,
                "Shoulder Press",120,1);
        GymService.Powtorzenia(person,22);
        assertThat(person.getPowtorzenia()).isEqualTo(5);
    }

    @Test
    void PowtorzeniaTest2(){
        Person person = new Person("","random",23,22,"02-03-2222",60,0,
                "Shoulder Press",120,1);
        GymService.Powtorzenia(person,5);
        assertThat(person.getPowtorzenia()).isEqualTo(1);
    }
    @Test
    void PowtorzeniaTest3(){
        Person person = new Person("","random",23,22,"02-03-2222",60,22,
                "Shoulder Press",120,1);
        GymService.Powtorzenia(person,5);
        assertThat(person.getPowtorzenia()).isEqualTo(5);
    }
    @Test
    void CwiczenieTest(){
        Person person = new Person("","random",23,22,"02-03-2222",60,22,
                null,120,1);
        GymService.Cwiczenie(person,"random");
        assertThat(person.getCwiczenie()).isEqualTo("Bench Press");
    }
    @Test
    void CwiczenieTest2(){
        Person person = new Person("","random",23,22,"02-03-2222",60,22,
                "rand",120,1);
        GymService.Cwiczenie(person,"random");
        assertThat(person.getCwiczenie()).isEqualTo("random");
    }

    @Test
    void ShouldFinID(){

        Mockito.when(GymRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(new Person()));
        Person Person= GymService.finBYId(112L);
        assertThat(Person).isNotNull();
    }
    @Test
    void notShouldFinID(){

        Mockito.when(GymRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        Person Person= GymService.finBYId(1L);
        assertThat(Person).isNull();
    }

    @Test
    void GymExistsById(){
        Mockito.when(GymRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        boolean Person = GymService.PersonExistsbyId(1L);
        assertThat(Person).isEqualTo(true);

    }

    @Test
    void GymNotExistsById(){
        Mockito.when(GymRepository.existsById(ArgumentMatchers.any())).thenReturn(false);
        boolean Gym = GymService.PersonExistsbyId(1L);
        assertThat(Gym).isEqualTo(false);
    }

    @Test
    void countById(){
        GymService.countById(12L);
        verify(GymRepository).count();
    }

    @Test
    void GetAllPerson(){
        GymService.FindAllById();
        verify(GymRepository).findAll();
    }

    @Test
    void deletePerson(){
        Person person = new Person();
        GymService.Delete(person);
        verify(GymRepository).delete(person);
    }

    @Test
    void DeleteByIdPerson(){

        GymService.DeleteById(1L);
        verify(GymRepository).deleteById(1L);

    }
}
