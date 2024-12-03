// Inicializador de poppover
const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))/**
 * 
 */

 // Filtrar propietarios para el listado
 function filtrarPropietarios() {
			const nombreInput = document.getElementById('propietarioNombre').value.toLowerCase();
			const estadoSelect = document.getElementById('estadoPropietario').value;

			const rows = document.querySelectorAll('.propietario-row');
			rows.forEach(row => {
				const nombre = row.cells[1].textContent.toLowerCase();
				const estadoTexto = row.querySelector('.estado span').textContent.toLowerCase();

				const estadoCoincide = 
					(estadoSelect === '0' && estadoTexto.includes('vigente')) ||
					(estadoSelect === '1' && estadoTexto.includes('moroso')) ||
					estadoSelect === '';

				const nombreCoincide = nombre.includes(nombreInput);

				if (nombreCoincide && estadoCoincide) {
					row.style.display = '';
				} else {
					row.style.display = 'none';
				}
			});
		}