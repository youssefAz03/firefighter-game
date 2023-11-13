package model;

import util.Position;

import java.util.List;

public interface Elements <T>{
    T getPositions();
    void setPositions(T positions);
    int getInitialCount();
}
