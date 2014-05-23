<#-- @ftlvariable name="" type="org.domain.views.ListView" -->
<html>
	<head>
		<title>Simple DropWizard App</title>
		<style type="text/css">
		
		body {
			font-family : Tahoma;
		}
		
		
		</style>
		
		<script type="text/javascript" src="/webjars/jquery/1.9.0/jquery.min.js"></script>
		
		<script type="text/javascript">
		
			$(document).ready(function(){				
				
			
			   
			   
			});
		 
		</script>
	</head>

    <body>
       
        <h1 align="center"><font color="green">Welcome, DropWizard !</font></h1>
        <hr/>
        <br/>
        <br/>
       
       	<table align="center" border="1" cellpadding="5" cellspacing="5">
       	
       		<tr>
       		
       			<th>Employee Id</th>
       			<th>Employee Name</th>
       			<th>Employee Salary</th>
       			<th colspan="2">Action</th>
       		
       		</tr>
       		
       		
       		<#list list as employee>
       		<tr>
       			<td><a href="/employee/find/${employee.id}">${employee.id}<a/></td>
       			<td>${employee.name}</td>
       			<td>${employee.salary}</td>
       			<td><a href="/employee/delete/${employee.id}">Delete</a></td>
       			
       		
       		</tr>
       		
       		</#list>
       	
       	
       	</table>
       
        
        <p align="center">| <a href="/create">Create Employee</a> | | <a href="/home">Home</a> |</p>
        
        
       
        
        
        
        
        
        
    </body>
</html>