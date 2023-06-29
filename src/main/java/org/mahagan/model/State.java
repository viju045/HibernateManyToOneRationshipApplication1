package org.mahagan.model;

import jakarta.persistence.*;

@Entity
@Table(name="state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stateId;
    private String stateName;
    private String statePopulation;
    @ManyToOne(cascade = CascadeType.ALL)
    private  Country country;

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(String statePopulation) {
        this.statePopulation = statePopulation;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
