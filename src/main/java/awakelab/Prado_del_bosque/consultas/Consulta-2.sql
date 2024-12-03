SELECT propietarios.nombre, propietarios.apellido, propietarios.rut, movimientos.fecha, movimientos.monto, movimientos.glosa 
FROM propietarios
JOIN saldos ON propietarios.saldos_idsaldos = saldos.idsaldos
JOIN  movimientos ON saldos.idsaldos = movimientos.saldos_idsaldos;