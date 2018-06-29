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

import nl.ordina.cursus_spring.springbootdi.model.Game;
import nl.ordina.cursus_spring.springbootdi.model.Person;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/rest")
public class GameService {

    private Person player1;
    private Person player2;

    @GetMapping(value = "/win", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity win() {
        if ((this.player1 == null) || (this.player2 == null)) {
            return ResponseEntity.ok("Game has not started. Please provide players...");
        }
        return ResponseEntity.ok(new Game(this.player1, this.player2).play());
    }

}
