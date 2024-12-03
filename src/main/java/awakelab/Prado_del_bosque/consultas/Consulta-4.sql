SELECT propietarios.nombre, propietarios.apellido, propietarios.rut, sum(movimientos.monto) as monto_total_pagado
FROM propietarios
JOIN saldos ON propietarios.saldos_idsaldos = saldos.idsaldos
JOIN  movimientos ON movimientos.saldos_idsaldos = saldos.idsaldos
GROUP BY propietarios.rut
ORDER BY propietarios.apellido DESC;