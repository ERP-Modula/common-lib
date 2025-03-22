package com.modula.common.domain.step;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private double x;
    private double y;

    public Location withX(double newX) {
        return new Location(newX, this.y);
    }

    public Location withY(double newY) {
        return new Location(this.x, newY);
    }
}
