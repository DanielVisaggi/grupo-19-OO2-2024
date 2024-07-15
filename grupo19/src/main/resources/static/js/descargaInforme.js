/**GENERAR REPORTE DE COMPRAS EN PDF ***/
	const crearPDF = () => {
		$.ajax({
			url: "/informe/generarPDF",
			success: function(res) {
				console.log(res);
			}
		});
		swal("Reporte generado con exito!!!", {
			icon: "success"
		});
	}
	