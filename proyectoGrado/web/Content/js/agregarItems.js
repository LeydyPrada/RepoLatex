var indice = 1;
jQuery.fn.generaNuevosCampos = function(etiqueta, nombreCampo){
   $(this).each(function(){
      elem = $(this);
      elem.data("etiqueta",etiqueta);
      elem.data("nombreCampo",nombreCampo);
      
      elem.click(function(e){
         e.preventDefault();
         elem = $(this);
         etiqueta = elem.data("etiqueta");
         nombreCampo = elem.data("nombreCampo");
        
         texto_insertar = '<tr><td><input type="number" id="c' + indice + '" name="c' + indice + '" value="0" onchange="onChangeValue(this)" class="form-control"></td>'
                 + '<td>'
                  + '<p id="rData'+ indice +'">'
                  +'</td>'
                    + '<td><textarea form="formCrearFactura" class="form-control" id="d' + indice + '" name="d' + indice + '"></textarea></td>'
                    + '<td><input type="text" id="valorU' + indice + '" name="valorU' + indice + '" value="0" onchange="onChangeValue(this)" class="form-control"></td>'
                    + '<td><input type="text" id="valorT' + indice + '" name="valorT' + indice + '"  value="0" onchange="onChangeValue(this)" readonly class="form-control"></td>'
                    
                  +'</tr>';
        
         document.getElementById("cantidadItems").value = indice;
         indice ++;
		 elem.data("indice",indice);
         nuevo_campo = $(texto_insertar);
         $("#tblDetalle > tbody").append(nuevo_campo);
      });
   });
   return this;
};


$(document).ready(function(){
    $("#mascamposItems").generaNuevosCampos("Pregunta", "Pregunta");
});
