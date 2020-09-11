/**
 * Marca.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  tableName: 'marcas',
  attributes: {
   
    marcas:{
      type: 'string',
      minLength: 3,
      required: true,
    },

    autos:{//One to many (Plural)

      collection: 'auto', //Referencia al modelo
      via: 'marca' //Nombre Foreing Key en 'Pokemon'


    }


  },

};

