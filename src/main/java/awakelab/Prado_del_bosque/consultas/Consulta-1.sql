SELECT propietarios.nombre, propietarios.apellido, saldos.rut, saldos.saldo FROM propietarios
JOIN  saldos ON propietarios.saldos_idsaldos = saldos.idsaldos;