package org.mahagan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class StateTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link State}
     *   <li>{@link State#setCountry(Country)}
     *   <li>{@link State#setStateId(int)}
     *   <li>{@link State#setStateName(String)}
     *   <li>{@link State#setStatePopulation(String)}
     *   <li>{@link State#getCountry()}
     *   <li>{@link State#getStateId()}
     *   <li>{@link State#getStateName()}
     *   <li>{@link State#getStatePopulation()}
     * </ul>
     */
    @Test
    void testConstructor() {
        State actualState = new State();
        State state = new State();
        Country country = new Country();
        state.setCountry(country);
        state.setStateId(1);
        state.setStateName("MD");
        state.setStatePopulation("MD");
        Country country2 = new Country();
        country2.setCountryId(1);
        country2.setCountryName("GB");
        country2.setPopulation("Population");
        country2.setState(state);
        State state2 = new State();
        state2.setCountry(country2);
        state2.setStateId(1);
        state2.setStateName("MD");
        state2.setStatePopulation("MD");
        Country country3 = new Country();
        country3.setCountryId(1);
        country3.setCountryName("GB");
        country3.setPopulation("Population");
        country3.setState(state2);
        actualState.setCountry(country3);
        actualState.setStateId(1);
        actualState.setStateName("MD");
        actualState.setStatePopulation("MD");
        Country country4 = actualState.getCountry();
        assertSame(country3, country4);
        State state3 = country4.getState();
        Country country5 = state3.getCountry();
        assertSame(country2, country5);
        State state4 = country5.getState();
        assertSame(country, state4.getCountry());
        assertEquals(1, actualState.getStateId());
        assertEquals(1, state3.getStateId());
        assertEquals(1, state4.getStateId());
        assertEquals("MD", actualState.getStateName());
        assertEquals("MD", state3.getStateName());
        assertEquals("MD", state4.getStateName());
        assertEquals("MD", actualState.getStatePopulation());
        assertEquals("MD", state3.getStatePopulation());
        assertEquals("MD", state4.getStatePopulation());
    }
}

