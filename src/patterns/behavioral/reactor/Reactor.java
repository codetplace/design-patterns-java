/*
 * ************************************************************************
 *  Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ***********************************************************************
 */

package patterns.behavioral.reactor;

import patterns.behavioral.reactor.example.ConcreteEventHandler;
import patterns.behavioral.reactor.example.Event;
import patterns.behavioral.reactor.example.EventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reactor {

    private static List<EventHandler> registeredHandlers = new ArrayList<>();


    private static void registerHandler(EventHandler eventHandler) {
        registeredHandlers.add(eventHandler);
    }


    public static void main(String[] args) {
        // Handler registration
        EventHandler eventHandler = new ConcreteEventHandler();
        registerHandler(eventHandler);

        while (true) {
            // Simulate event
            if (new Random().nextInt(10000000) == 50) {
                Event event = new Event();

                for (EventHandler handler : registeredHandlers) {
                    handler.handle(event);
                }
            }
        }
    }
}