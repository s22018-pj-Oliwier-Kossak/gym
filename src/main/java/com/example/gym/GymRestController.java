package com.example.gym;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")

public class GymRestController {
    private final GymService GymService;

    public GymRestController(GymService gymService) {
        GymService = gymService;
    }

    @GetMapping
    public ResponseEntity<String> Hello(){

        return ResponseEntity.ok("hello World");
    }


    @GetMapping("/BenchPress/{imie}/{Nazwisko}/{wiek}/{waga}/{data}/{ciezar}/{powtorzenia}")
    public ResponseEntity<Person> BenchPress(@PathVariable String imie,@PathVariable
            String Nazwisko,@PathVariable int wiek,@PathVariable int waga,@PathVariable String data
            ,@PathVariable int ciezar,@PathVariable int powtorzenia){

        return ResponseEntity.ok(GymService.BenchPress(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia)) ;
    }


    @GetMapping("/BenchPress")
    public ResponseEntity<Person> BenchPress2(@RequestParam String imie,@RequestParam
            String Nazwisko,@RequestParam int wiek,@RequestParam int waga,@RequestParam String data
            ,@RequestParam int ciezar,@RequestParam int powtorzenia){

        return ResponseEntity.ok(GymService.BenchPress(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }


    @GetMapping("/Deadlift/{imie}/{Nazwisko}/{wiek}/{waga}/{data}/{ciezar}/{powtorzenia}")
    public ResponseEntity<Person> Deadlift(@PathVariable String imie,@PathVariable
            String Nazwisko,@PathVariable int wiek,@PathVariable int waga,@PathVariable String data
            ,@PathVariable int ciezar,@PathVariable int powtorzenia){

        return ResponseEntity.ok(GymService.Deadlift(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }

    @GetMapping("/Deadlift")
    public ResponseEntity<Person> Deadlift2(@RequestParam String imie,@RequestParam
            String Nazwisko,@RequestParam int wiek,@RequestParam int waga,@RequestParam String data
            ,@RequestParam int ciezar,@RequestParam int powtorzenia){

        return ResponseEntity.ok(GymService.Deadlift(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }

    @GetMapping("/Squat/{imie}/{Nazwisko}/{wiek}/{waga}/{data}/{ciezar}/{powtorzenia}")
    public ResponseEntity<Person> Squat(@PathVariable String imie,@PathVariable
            String Nazwisko,@PathVariable int wiek,@PathVariable int waga,@PathVariable String data
            ,@PathVariable int ciezar,@PathVariable int powtorzenia){

        return ResponseEntity.ok(GymService.Squat(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }

    @GetMapping("/Squat")
    public ResponseEntity<Person> Squat2(@RequestParam String imie,@RequestParam
            String Nazwisko,@RequestParam int wiek,@RequestParam int waga,@RequestParam String data
            ,@RequestParam int ciezar,@RequestParam int powtorzenia){

        return ResponseEntity.ok(GymService.Squat(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }

    @GetMapping("/ShoulderPress/{imie}/{Nazwisko}/{wiek}/{waga}/{data}/{ciezar}/{powtorzenia}")
    public ResponseEntity<Person> ShoulderPress(@PathVariable String imie,@PathVariable
            String Nazwisko,@PathVariable int wiek,@PathVariable int waga,@PathVariable String data
            ,@PathVariable int ciezar,@PathVariable int powtorzenia){

        return ResponseEntity.ok(GymService.ShoulderPress(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }

    @GetMapping("/ShoulderPress")
    public ResponseEntity<Person> ShoulderPress2(@RequestParam String imie,@RequestParam
            String Nazwisko,@RequestParam int wiek,@RequestParam int waga,@RequestParam String data
            ,@RequestParam int ciezar,@RequestParam int powtorzenia){

        return ResponseEntity.ok(GymService.ShoulderPress(imie, Nazwisko, wiek, waga, data,ciezar,powtorzenia));
    }





}
