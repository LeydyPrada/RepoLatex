var ok = 0;
var itemsrCorreo = null;
var itemsciudad = null;
var nombre = null;
var direccion = null;
var telefono = null;
var id = null;
var existe = null;
var mensajeExiste = '<p class="text-danger"><i class="fa fa-close fa-fw fa-lg text-danger"></i> El cliente no existe</p>';


function onChangeValue(ish) {
    var i = 0;
    for (i = 1; i <= parseInt(document.getElementById("cantidadItems").value) ; i++) {
        document.getElementById("valorT" + i).value = parseInt(document.getElementById("valorU" + i).value) * parseInt(document.getElementById("c" + i).value);

    }

    var j = 0;
    document.getElementById("subT").value = 0;
    for (j = 1; j <= parseInt(document.getElementById("cantidadItems").value) ; j++) {
        document.getElementById("subT").value = parseInt(document.getElementById("subT").value) + parseInt(document.getElementById("valorT" + j).value);

    }

    document.getElementById("iva").value = (parseInt((document.getElementById("subT").value) * 19) / 100);
    document.getElementById("total").value = parseInt(document.getElementById("subT").value) + parseInt(document.getElementById("iva").value);
    document.getElementById("saldo").value = parseInt(document.getElementById("total").value) - parseInt(document.getElementById("abono").value)
    i = 0;
    j = 0;
};


/*Obtiene dats del Controller ListarConceptos sin recagar pagina*/
function addItems() {
    

        var items = '<select id="cc' + document.getElementById("cantidadItems").value + '" name="cc' + document.getElementById("cantidadItems").value + '" class="form-control">';
        
            items += "<option value='prueba'</option>";
        
        items += "</select>";
        $('#rData' + document.getElementById("cantidadItems").value).html(items);
    
};



/*Obtiene dats del Controller ObtenerDatosCliente sin recagar pagina*/
function updateInput() {
    $.getJSON('/Factura/ObtenerDatosCliente/', { identificacion: document.getElementById("identificacion").value }, function (data) {
        procesando();
        existe = null;
        
        $.each(data, function (i, cliente) {
                existe = cliente.IdCliente;
                itemsrCorreo = '<input type="email" class="form-control" id="correo" disabled value="' + cliente.CorreoElectronico + '">';
                itemsciudad = '<input type="text" class="form-control" id="ciudad" disabled value="' + cliente.Ciudad + '">';
                nombre = '<input type="text" class="form-control" id="nombre" disabled value="' + cliente.Nombre + ' ' + cliente.Apellido + '">';
                direccion = '<input type="text" class="form-control" id="direccion" disabled value="' + cliente.Direccion + '">';
                telefono = '<input type="number" class="form-control" id="telefono" disabled value="' + cliente.Telefono + '">';
                id = '<input type="hidden" id="idCLiente" name="idCLiente" class="form-control" value="' + cliente.IdCliente + '">';
                mensajeExiste = '<p class="text-success"><i class="fa fa-check fa-fw fa-lg text-success"></i> El cliente si existe</p>';
            
            
            
        });
        if (existe == null)
        {
            itemsrCorreo = null;
            itemsciudad = null;
            nombre = null;
            direccion = null;
            telefono = null;
            id = null
            mensajeExiste = '<p class="text-danger"><i class="fa fa-close fa-fw fa-lg text-danger"></i> El cliente no existe</p>';
        }

        setTimeout("eliminarProcesando()", 3000);
        setTimeout("asignarValoresFacCliente()", 3000);
    });
};

/*Actualiza campos de la pagina sin recargar*/
function asignarValoresFacCliente() {
    $('#rLblMensajeExiste').html(mensajeExiste);
    $('#rCorreo').html(itemsrCorreo);
    $('#rNombre').html(nombre);
    $('#rDireccion').html(direccion);
    $('#rTelefono').html(telefono);
    $('#rId').html(id);
};




