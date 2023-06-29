package org.mahagan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CountryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Country}
     *   <li>{@link Country#setCountryId(int)}
     *   <li>{@link Country#setCountryName(String)}
     *   <li>{@link Country#setPopulation(String)}
     *   <li>{@link Country#setState(State)}
     *   <li>{@link Country#getCountryId()}
     *   <li>{@link Country#getState()}
     *   <li>{@link Country#getCountryName()}
     *   <li>{@link Country#getPopulation()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Country actualCountry = new Country();
        actualCountry.setCountryId(1);
        actualCountry.setCountryName("GB");
        actualCountry.setPopulation("Population");
        Country country = new Country();
        country.setCountryId(1);
        country.setCountryName("GB");
        country.setPopulation("Population");
        State state = new State();
        country.setState(state);
        State state2 = new State();
        state2.setCountry(country);
        state2.setStateId(1);
        state2.setStateName("MD");
        state2.setStatePopulation("MD");
        Country country2 = new Country();
        country2.setCountryId(1);
        country2.setCountryName("GB");
        country2.setPopulation("Population");
        country2.setState(state2);
        State state3 = new State();
        state3.setCountry(country2);
        state3.setStateId(1);
        state3.setStateName("MD");
        state3.setStatePopulation("MD");
        actualCountry.setState(state3);
        assertEquals(1, actualCountry.getCountryId());
        State state4 = actualCountry.getState();
        Country country3 = state4.getCountry();
        assertEquals(1, country3.getCountryId());
        State state5 = country3.getState();
        Country country4 = state5.getCountry();
        assertEquals(1, country4.getCountryId());
        assertEquals("GB", actualCountry.getCountryName());
        assertEquals("GB", country3.getCountryName());
        assertEquals("GB", country4.getCountryName());
        assertEquals("Population", actualCountry.getPopulation());
        assertEquals("Population", country3.getPopulation());
        assertEquals("Population", country4.getPopulation());
        assertSame(state3, state4);
        assertSame(state2, state5);
        assertSame(state, country4.getState());
    }
}

