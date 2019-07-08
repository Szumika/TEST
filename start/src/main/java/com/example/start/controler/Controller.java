package com.example.start.controler;

import com.example.start.DTO.ActorDTO;
import com.example.start.DTO.CustomerDTO;
import com.example.start.DTO.FilmDTO;
import com.example.start.errors.NotFoundException;
import com.example.start.model.Actor;
import com.example.start.model.ActorsNamesOnly;
import com.example.start.model.Customer;
import com.example.start.model.Film;
import com.example.start.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class Controller {
    @Autowired
    private ActorRepository ar;
    @Autowired
    private  FilmRepository fr;
    @Autowired
    private CustomersRepository customrepo;
    @Autowired
    private AddressRepository addressrepo;

    @RequestMapping("/")
    public String start(){
        return "witam w mojej Apce wpisz na w pasku gdzie sie chcesz dostac";
    }


    @RequestMapping("/customer/{id}")
    public CustomerDTO hello(@PathVariable long id) {
Customer customer = customrepo.findById(id).orElseThrow(() -> new NotFoundException("no nie ma takiego"));
        return new CustomerDTO(customer); }

    @GetMapping("/filmDTO/{id}")
    public FilmDTO start(@PathVariable long id) {
        Film film = fr.findById(id).orElseThrow(() -> new NotFoundException("nie ma takiego filmu :( "));
        return new FilmDTO(film); }

    @RequestMapping("/projectionC/{name}")
    public Collection<ActorsNamesOnly> nameClass(@PathVariable String name){
        Collection<ActorsNamesOnly> actor = ar.findByLastName(ActorsNamesOnly.class, name);
        return actor;
    }

    @RequestMapping("/projectionR/{name}")
    public Collection<ActorsNameOnly> nameRepo(@PathVariable String name){
        Collection<ActorsNameOnly> actor = ar.findByLastName(ActorsNameOnly.class, name);
        return actor;
    }

    @RequestMapping( "/films/title")
    public ResponseEntity findAllTitle() {
        final Collection<FilmTitle> filmTitle =
                this.fr.findAllProjectedBy(FilmTitle.class);
        return ResponseEntity.ok(filmTitle);
    }

    @RequestMapping( "/films/desc")
    public ResponseEntity findAllDescription() {
        final Collection<FilmDesc> filmDescs =
                this.fr.findAllProjectedBy(FilmDesc.class);
        return ResponseEntity.ok(filmDescs); }

    @RequestMapping( "/films/title/{title}")
    public ResponseEntity findAllTitleWhere(@PathVariable String title) {
        final Collection<FilmTitle> filmTitle =
                this.fr.findAllTitleLike(title);
        return ResponseEntity.ok(filmTitle);
    }
    @RequestMapping( "/films/title1/{title}")
    public ResponseEntity findByTitleWhere(@PathVariable String title) {
        final Collection<FilmTitle> filmTitle =
                this.fr.findByTitleLike(title+"%" );
        return ResponseEntity.ok(filmTitle);
    }

    @RequestMapping("/actors/{lastname}")
    public ResponseEntity findByFirstLatter(@PathVariable String lastname){
        final Collection<ActorsNameOnly> actorsNamesOnly =
                this.ar.findAllActorLike(lastname);
    return ResponseEntity.ok(actorsNamesOnly);
    }

    @RequestMapping( "/film/all/{id}")
    public ResponseEntity findAllById(@PathVariable Long id) {
        final Collection<FilmAllById> filmAllByIds =
                this.fr.findByFilmId(id);
        return ResponseEntity.ok(filmAllByIds ); }

    @RequestMapping( "/film/{id}/actors")
    public ResponseEntity findActorsById(@PathVariable Long id) {
        final Collection<ActorsOnly> filmAllByIds =
                this.fr.findActorByfilmId(id);
        return ResponseEntity.ok(filmAllByIds ); }



    @RequestMapping("/actors/{lastname}/films")
    public ResponseEntity namesOnly(@PathVariable String lastname){

        final Collection<FilmTitle> actors = fr.findAllTitleByActors_lastName(lastname);
        return ResponseEntity.ok(actors);
    }

    @RequestMapping("/actors/{lastname}/title")
    public ResponseEntity TitlesfromActor(@PathVariable Long lastname){

        final Collection<FilmTitle> actors = fr.findAllTitleByActors_actorId(lastname);
        return ResponseEntity.ok(actors);
    }


    @RequestMapping("/actors/{lastname}/{title}/all")
    public Collection<FilmAndActor> AllfromActor(@PathVariable String lastname, @PathVariable String title){

        return fr.findByActors_lastName(lastname, title);
    }

    @RequestMapping(value="/film/{id}", method= RequestMethod.GET)
    public ResponseEntity<FilmDTO> get(@PathVariable("id") Long id) {
        Film film = fr.findById(id).orElseThrow(() -> new NotFoundException("nie ma takiego filmu :( "));
         FilmDTO filmDTO = new FilmDTO(film);
        return new ResponseEntity(filmDTO, new HttpHeaders(), HttpStatus.OK); }

    @PutMapping(value="/film/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody FilmDTO film, @PathVariable Long id) {
    Film fil = fr.findById(id).orElseThrow(() -> new NotFoundException("no nie ma takiego"));

        fil.setTitle(film.getFilmname());
        fil.setDescription(film.getDesc());
        fr.save(fil);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value="/film/{id}/actors")
    public ResponseEntity<Object> AddActors(@RequestBody ActorDTO actor, @PathVariable Long id) {
        Film fil = fr.findById(id).orElseThrow(() -> new NotFoundException("no nie ma takiego"));
        Actor actor1 = new Actor(actor.getFirstName(), actor.getLastName(),fil);
//        Actor actor2 = ar.findById(actor.getActorId()).orElseThrow(() -> new NotFoundException("a"));;
        fil.AddActor(actor1);
        actor1.addFilm(fil);
        ar.save(actor1);
        fr.save(fil);
        return ResponseEntity.noContent().build();
    }

}



//        Optional<Customer> customer = customrepo.findById(id);
//        if(customer.isPresent()){
//            Customer customer1 = customer.get();
//            CustomerDTO customerDTO = new CustomerDTO(customer1);
//            return ResponseEntity.ok(customerDTO);
//        }else {
//            return ResponseEntity.notFound().build();
//        }

//        Optional<Film> emptyOpt = fr.findById(id);
//        if (emptyOpt.isPresent()) {
//            Film film = emptyOpt.get();
//            FilmDTO filmDTO = new FilmDTO(film);
//            return ResponseEntity.ok(filmDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }