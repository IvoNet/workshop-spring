
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

import nl.ordina.cursus_spring.springbootdi.model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {
    private GameController game;
    private Person player1;
    private Person player2;

    @Before
    public void setUp() {
        this.player1 = mock(Person.class);
        this.player2 = mock(Person.class);
        this.game = new GameController(this.player1, this.player2);
    }

    @Test
    public void player1() {
        when(this.player1.getValue()).thenReturn(1);
        when(this.player2.getValue()).thenReturn(0);
        when(this.player1.getName()).thenReturn("Player1");
        final String play = this.game.play();
        assertEquals("Player1 has won", play);
        verify(player1, times(1)).getValue();
    }
    @Test
    public void player2() {
        when(this.player1.getValue()).thenReturn(0);
        when(this.player2.getValue()).thenReturn(1);
        final String play = this.game.play();
        assertEquals("Player2 has won", play);
    }
}