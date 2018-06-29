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

package nl.ordina.springcourse;

import nl.ordina.springcourse.model.Person;

/**
 * @author Ivo Woltring
 */
public class Game {
    private final Person player1;
    private final Person player2;

    public Game(final Person player1, final Person player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String play(){
        if (this.player1.getValue() > this.player2.getValue()) {
            return "Player1 has won";
        } else if (this.player1.getValue() < this.player2.getValue()) {
            return "Player2 has won";
        } else {
            return "Its a tie!";
        }
    }

    public static void main(String[] args) {
        Person player1 = new Person("player1", 1);
        Person player2 = new Person("player2", 0);
        Game game = new Game(player1, player2);
        final String play = game.play();
        System.out.println("play = " + play);
    }

}
