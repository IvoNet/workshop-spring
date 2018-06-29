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

package nl.ordina.cursus_spring.springbootdi.config;

import nl.ordina.cursus_spring.springbootdi.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author Ivo Woltring
 */
//@Configuration
public class PersonConfigurator {

    @Bean
    public Person player1(@Value("${player1.name}") final String name,
                          @Value("${player1.value}") final int value) {
        return new Person(name, value);
    }

    @Bean
    public Person player2(@Value("${player2.name:winner}") final String name,
                          @Value("${player2.value:10000}") final int value) {
        return new Person(name, value);
    }

}
