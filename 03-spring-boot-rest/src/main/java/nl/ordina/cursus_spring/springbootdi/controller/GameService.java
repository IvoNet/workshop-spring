/*
 * Copyright 2018 Ivo Woltring <WebMaster@ivonet.nl>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.ordina.cursus_spring.springbootdi.controller;

import nl.ordina.cursus_spring.springbootdi.entity.Waarden;
import nl.ordina.cursus_spring.springbootdi.model.Game;
import nl.ordina.cursus_spring.springbootdi.model.Person;
import nl.ordina.cursus_spring.springbootdi.resource.WaardenRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
import java.util.Random;

@Service
@RequestMapping("/rest")
public class GameService {

    private Person player1;
    private Person player2;
    private final WaardenRepository waardenRepository;
    private final Random random;

    public GameService(final WaardenRepository waardenRepository) {
        this.random = new Random();
        this.waardenRepository = waardenRepository;
    }

    @GetMapping(value = "/win")
    public ResponseEntity win() {
        if ((this.player1 == null) || (this.player2 == null)) {
            return ResponseEntity.ok("Game has not started. Please provide players...");
        }
        return ResponseEntity.ok(new Game(this.player1, this.player2).play());
    }

    @RequestMapping(value = "/player", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @PostMapping(value = "/player", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity player(@RequestBody final Person person) {
        if (this.player1 == null) {
            this.player1 = person;
        } else if (this.player2 == null) {
            this.player2 = person;
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{naam}")
    public ResponseEntity nameOnly(@PathVariable("naam") final String name) {
        final Optional<Waarden> byId = this.waardenRepository.findById(new Long(this.random.nextInt(100)));

        if (this.player1 == null) {
            byId.ifPresent(waarden -> this.player1 = new Person(name, waarden.getWaarde()));
        } else if (this.player2 == null) {
            byId.ifPresent(waarden -> this.player2 = new Person(name, waarden.getWaarde()));
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();



    }

    @GetMapping("/reset")
    public ResponseEntity reset() {
        this.player1 = null;
        this.player2 = null;
        return ResponseEntity.ok("Play again.");
    }

}
