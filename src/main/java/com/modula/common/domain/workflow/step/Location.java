package com.modula.common.domain.workflow.step;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Column(name = "location_x")
    private double x;

    @Column(name = "location_y")
    private double y;

    public Location withX(double newX) {
        return new Location(newX, this.y);
    }

    public Location withY(double newY) {
        return new Location(this.x, newY);
    }
}
