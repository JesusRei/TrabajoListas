package com.jdrg.trabajolistas.models

class Parameters {

    companion object {
        @JvmStatic
        var personas: ArrayList<Persona> = ArrayList<Persona>()
        fun setPersonasList(personElement: Persona) {
            personas.add(personElement)
        }

        @JvmStatic
        fun getPersonasList(): ArrayList<Persona> {
            return personas
        }

        @JvmStatic
        var pokemons: ArrayList<Pokemon> = ArrayList<Pokemon>()
        fun setPokemonsList(pokemonElement: Pokemon) {
            pokemons.add(pokemonElement)
        }

        @JvmStatic
        fun getPokemonsList(): ArrayList<Pokemon> {
            return pokemons
        }

        @JvmStatic
        var cars: ArrayList<Car> = ArrayList<Car>()
        fun setCarsList(carElement: Car) {
            cars.add(carElement)
        }

        @JvmStatic
        fun getCarsList(): ArrayList<Car> {
            return cars
        }

    }
}