package com.max.service;

import com.max.pojo.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> getAllHero();

    void insertHero(Hero hero);

    Hero getOneHero(Integer id);

    void updateHero(Hero hero);

    void deleteHero(Integer id);
}
