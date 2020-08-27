/**
 * Batalla.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  table_name: 'batalla_pokemon', 
  attributes: {

    nombre: {

      type: 'string'
    },

    pokemons:{//One to many (Plural)

      collection: 'pokemon', //Referencia al modelo
      via: 'batalla' //Nombre Foreing Key en 'Pokemon'


    }

    

  },

};

