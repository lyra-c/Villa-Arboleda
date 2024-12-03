SELECT glosa, SUM(monto) as total_gastos 
FROM gastos_comunes 
WHERE glosa='GasValpo' OR glosa='ESVAL'
GROUP BY glosa;