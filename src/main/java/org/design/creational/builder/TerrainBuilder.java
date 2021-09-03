package org.design.creational.builder;

public interface TerrainBuilder {
    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();
}

