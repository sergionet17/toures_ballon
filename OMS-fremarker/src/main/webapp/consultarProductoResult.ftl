<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <title>OMS</title>

<style>
body, input {
	font-family: Calibri, Arial;
	margin: 0px;
	padding: 0px;
}
#header h2 {
	color: white;
	background-color: #3275A8;
	height: 50px;
	padding: 5px 0 0 5px;
	font-size: 20px;
}
	
.datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
.datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
.datatable tr {border:1px solid #888}
.datatable tr.odd {background-color:#eee}
.datatable td {padding:2px;border:1px solid #888}
#content { padding 5px; margin: 5px; text-align: center}

fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
legend { font-weight: bold; }
</style>

<body>
<div id="header">
<H2>
	Lista  de Productos
</H2>
</div>

<div id="content">
  <br/>
  <div class="table-responsive">
  
    <table class="table">
  	 <tr>
  		  <th>Ciudad</th>
        <th>Cantidad</th>  <th>Codigo Producto</th>
        <th>Descripcion</th>  <th>Fecha Fin</th>
        <th>Fecha Inicio </th>  <th>Precio</th>
        <th>Proveedor hoteleria</th>  <th>Proveedor transporte</th>        
  	   </tr>
      <#list model["productoList"] as producto>
	  	  <tr>
         <td class="col-xs-1" >${producto.codigo}</td>
         <td class="col-xs-1" >${producto.cantidad}</td>
         <td class="col-xs-1" >${producto.codigoProducto}</td>
         <td class="col-xs-2" >${producto.descripcion}</td>
         <td class="col-xs-1" >${producto.fechaFin}</td>
         <td class="col-xs-1" >${producto.fechaIni}</td>
         <td class="col-xs-1" >${producto.precio}</td>
         <td class="col-xs-1" >${producto.proveedorHotele}</td>
         <td class="col-xs-1" >${producto.proveedorTrans}</td>
         <!--
         <td>         
         <input class="btn btn-info" class="col-xs-4" type="submit" value="Crear Producto" />
         <input class="btn btn-info" class="col-xs-4" type="submit" value="Eliminar Producto" />
         </td>
         -->
	  	  </tr>
      </#list>
    </table>
  </div>
</div>  
</body>
</html>  