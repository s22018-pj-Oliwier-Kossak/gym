package com.example.gym;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymService {

    private final GymRepository GymRepository;

    public GymService(GymRepository gymRepository) {
        GymRepository = gymRepository;
    }

    public void Print(Person person){

        System.out.println(person);
    }


    public Person BenchPress(String imie, String Nazwisko, int wiek, int waga, String data,float ciezar,float powtorzenia){

        float maksymalny_ciezar=Math.round(ciezar*(1+(powtorzenia/30)));
        int poziom_sily=Math.round((ciezar*3)/waga);
        if(poziom_sily>5){
            poziom_sily=5;
        }

        Person person = new Person(imie,Nazwisko,wiek,waga,data,ciezar,powtorzenia,"Bench Press",maksymalny_ciezar,poziom_sily);
        return GymRepository.save(person);
    }

    public Person Deadlift(String imie, String Nazwisko, int wiek, int waga, String data,float ciezar,float powtorzenia){

        float maksymalny_ciezar=Math.round(ciezar*(1+(powtorzenia/33)));
        int poziom_sily=Math.round(ciezar*2/waga)-1;
        if(poziom_sily>5){
            poziom_sily=5;
        }

        Person person = new Person(imie,Nazwisko,wiek,waga,data,ciezar,powtorzenia,"Deadlift",maksymalny_ciezar,poziom_sily);
        return GymRepository.save(person);
    }

    public Person Squat(String imie, String Nazwisko, int wiek, int waga, String data,float ciezar,float powtorzenia){

        float maksymalny_ciezar=Math.round(ciezar*(1+(powtorzenia/35)));
        int poziom_sily=Math.round(ciezar*3/waga);
        if(poziom_sily>5){
            poziom_sily=5;
        }

        Person person = new Person(imie,Nazwisko,wiek,waga,data,ciezar,powtorzenia,"Squat",maksymalny_ciezar,poziom_sily);
        return GymRepository.save(person);
    }

    public Person ShoulderPress(String imie, String Nazwisko, int wiek, int waga, String data,float ciezar,float powtorzenia){

        float maksymalny_ciezar=Math.round(ciezar*(1+(powtorzenia/32)));
        int poziom_sily=Math.round(ciezar*5/waga);
        if(poziom_sily>5){
            poziom_sily=5;
        }

        Person person = new Person(imie,Nazwisko,wiek,waga,data,ciezar,powtorzenia,"Shoulder Press",maksymalny_ciezar,poziom_sily);
        return GymRepository.save(person);
    }

    public String Imie(Person person,String imie){
        if(person.getImie()==null || person.getImie().isBlank()){
            person.setImie(imie);
        }
        return person.getImie();
    }


    public void Nazwisko(Person person){

        if(person.getNazwisko()==null || person.getNazwisko().isBlank()){
            String nazwisko="Kowalski";
            person.setNazwisko(nazwisko);
            person.getNazwisko();
        }
        else {
            person.getNazwisko();
        }

    }
    public void Wiek(Person person){
        if(person.getWiek()<18){
            person.setWiek(18);
        }
        person.getWiek();
    }
    public void Waga(Person person){
        if(person.getWaga()<50){
            int waga=person.getWaga()*2;
            person.setWaga(waga);
            person.getWaga();
        }
        else if (person.getWaga()==50){
            person.getWaga();
        }
        else {
            int waga=person.getWaga()-30;
            person.setWaga(waga);
            person.getWaga();
        }
    }
    public String Data(Person person){

        if(person.getData()==null || person.getData().isBlank()){
            person.setData("01-01-2022");
        }
        return person.getData();
    }
    public float Ciezar(Person person,float ciezar){
        if(person.getCiezar()<=0 ){
            person.setCiezar(ciezar);
        }

        return person.getCiezar();
    }
    public float Powtorzenia(Person person,float powtorzenia){
        if(person.getPowtorzenia()<0){
            person.setPowtorzenia(5);
        }
        else if(person.getPowtorzenia()==0){
            person.setPowtorzenia(1);
        }
        else{
            person.setPowtorzenia(powtorzenia);
        }
        return person.getPowtorzenia();
    }
    public String Cwiczenie(Person person, String cwiczenie){
        if(person.getCwiczenie()==null || person.getCwiczenie().isBlank()){
            person.setCwiczenie("Bench Press");
        }
        else {
            person.setCwiczenie(cwiczenie);
        }
        return person.getCwiczenie();
    }


    public List<Person> FindAllById(){

        return GymRepository.findAll();

    }

    public Long countById(Long id){

        return GymRepository.count();
    }
    public Person finBYId(Long id){
        Optional<Person> byId = GymRepository.findById(id);
        return  byId.orElse(null);
    }
    public boolean PersonExistsbyId(Long id){

        return GymRepository.existsById(id);

    }
    public void Delete(Person person){

        GymRepository.delete(person);

    }
    public void DeleteById(Long personId){

        GymRepository.deleteById(personId);

    }
   /* public Person Person(String imie, String Nazwisko, int wiek, int waga, String data,int ciezar,int powtorzenia,String cwiczenie,int
            maksymalny_ciezar,int  poziom_sily ){
        Person person = new Person(imie,Nazwisko,wiek,waga,data,ciezar,powtorzenia,cwiczenie,maksymalny_ciezar,poziom_sily);
        return GymRepository.save(person);
    }

     public Person BenchPress2(String imie, String Nazwisko,int wiek){


       Person person = new Person(imie,Nazwisko,wiek,2,"data",2,2,"Bench Press",2,1);
       return GymRepository.save(person);
   }
    */

}
