SELECT propietarios.nombre, propietarios.apellido, propietarios.rut, propiedades.codigo 
FROM propietarios
JOIN propietarios_propiedades ON propietarios.rut = propietarios_propiedades.propietarios_rut
JOIN  propiedades ON propietarios_propiedades.propiedades_codigo = propiedades.codigo;