package com.example.gym;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    public Person(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String imie;
    private String Nazwisko;
    private int wiek;
    private int waga;
    private String data;
    private float ciezar;
    private float powtorzenia;
    private String cwiczenie;
    private float maksymalny_ciezar;
    private int poziom_sily ;


    Person(String imie, String Nazwisko, int wiek, int waga, String data,float ciezar,float powtorzenia,String cwiczenie,
           float maksymalny_ciezar,int poziom_sily  ){
        this.imie=imie;
        this.Nazwisko=Nazwisko;
        this.wiek=wiek;
        this.waga=waga;
        this.data=data;
        this.ciezar=ciezar;
        this.powtorzenia=powtorzenia;
        this.cwiczenie=cwiczenie;
        this.maksymalny_ciezar=maksymalny_ciezar;
        this.poziom_sily=poziom_sily;

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", wiek=" + wiek +
                ", waga=" + waga +
                ", data='" + data + '\'' +
                ", ciezar=" + ciezar +
                ", powtorzenia=" + powtorzenia +
                ", cwiczenie='" + cwiczenie + '\'' +
                ", maksymalny_ciezar=" + maksymalny_ciezar +
                ", poziom_sily=" + poziom_sily +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {return Nazwisko;}

    public void setNazwisko(String nazwisko) {Nazwisko = nazwisko;}

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getCiezar() {return ciezar;}

    public void setCiezar(float ciezar) {this.ciezar = ciezar;}

    public float getPowtorzenia() {return powtorzenia;}

    public void setPowtorzenia(float powtorzenia) {this.powtorzenia = powtorzenia;}

    public String getCwiczenie() {
        return cwiczenie;
    }

    public void setCwiczenie(String cwiczenie) {
        this.cwiczenie = cwiczenie;
    }

    public float getMaksymalny_ciezar() {
        return maksymalny_ciezar;
    }

    public void setMaksymalny_ciezar(float maksymalny_ciezar) {
        this.maksymalny_ciezar = maksymalny_ciezar;
    }

    public int getPoziom_sily() {
        return poziom_sily;
    }

    public void setPoziom_sily(int poziom_sily) {
        this.poziom_sily = poziom_sily;
    }
}
