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
	Administracion de Productos
</H2>
</div>

<div id="content">
	
  <fieldset>
  	<legend>Crear Producto</legend>

    <div class="container">
  <h2>Horizontal form</h2>
  <form class="form-horizontal" name="car" action="add" method="post" >
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>


  <form class="form-horizontal" name="car" action="add" method="post">
  	<div class="form-group">
    Nombre : <input type="text" name="make" class="form-control" />	<br/>
  	</div>
    <div class="form-group" >
    Descripcion: <input type="text" name="model" class="form-control" id="pwd" placeholder="Ingrese descripcion"/>	<br/>
  	</div>
    <input type="submit" value="Crear Producto" />
  </form>
  </fieldset>

  <br/>
  <div class="table-responsive">
  
    <table class="table">
  	 <tr>
  		  <th>Nombre</th>  <th>Descipcion</th>
  	   </tr>
      <#list model["productolts"] as producto>
	  	  <tr>
	  		 <td class="col-xs-4" >${producto.nombre}</td> 
         <td class="col-xs-4" >${producto.id}</td>
         <td>
         <input class="btn btn-info" class="col-xs-4" type="submit" value="Crear Producto" />
         <input class="btn btn-info" class="col-xs-4" type="submit" value="Eliminar Producto" />
         </td>
	  	  </tr>
      </#list>
    </table>
  </div>
</div>  
</body>
</html>  