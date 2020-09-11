/**
 * Auto.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {
  tableName: 'autos',
  attributes: {
   
    tipo_auto:{
      type: 'string',
      minLength: 3,
      required: true, // Por defecto es false
    },
    isDisponible:{
      type: 'boolean',
      defaultsTo: true, // Por defecto es false
    },
    costo_auto:{
      type: 'number',
      required: true,
      
    },

    marca: {//Many to One (nombreFK) - mismo nombre que la relación
      model: 'marca',
      required: true //(Es opcional 1 muchos 0 muchos)
  
     }



  },

};

