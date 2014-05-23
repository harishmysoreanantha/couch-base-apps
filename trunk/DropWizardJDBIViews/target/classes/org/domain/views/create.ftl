<html>
	<head>
		<title>Simple DropWizard App</title>
		<style type="text/css">
		
		body {
			font-family : Tahoma;
		}
		
		.inputClass {
			padding : 5px;
			background-color : yellow;
		
		}
		
		.btnClass {
			padding : 5px;
		
		}		
		
		
		</style>
		
		<script type="text/javascript" src="/webjars/jquery/1.9.0/jquery.min.js"></script>
		
		<script type="text/javascript">
		
			$(document).ready(function(){				
				$('#btnCreate').click(function(){
				
					$.ajax({
					
						type:'POST',
						url:'/employee/create',
						data:$('#employeeForm').serialize(),
						success : function(response){
							if(response == "1") {
								showView();
							}
						}
					
					
					});
				
				});
			
			   
			   
			});
			
			
			function showView() {
				window.location = '/employee/list';
			}
		 
		</script>
	</head>

    <body>
       
        <h1 align="center"><font color="green">Employee Data Entry (Create) </font></h1>
        <hr/>
        <br/>
        <br/>
        
        <form id="employeeForm">
        <table align="center"cellpadding="5" cellspacing="5">
        
        	<tr>
        		<td>Employee Id</td>
        		<td><input type="text" name="employeeId" id="employeeId" class="inputClass" value=""/></td>
        	
        	</tr>
        	
        	<tr>
        		<td>Name</td>
        		<td><input type="text" name="employeeName" id="employeeName" class="inputClass" value=""/></td>
        	
        	</tr>
        
        
        	<tr>
        		<td>Salary</td>
        		<td><input type="text" name="employeeSalary" id="employeeSalary" class="inputClass" value=""/></td>
        	
        	</tr>
        
        	<tr>
        		<td></td>
        		
        			<td><input type="button" id="btnCreate" value="Create Employee" class="btnClass"/></td>
        		
        		
        		        	
        	
        	</tr>
        
        
        </table>
        </form>
        <br/>
        <br/>
        
        <p align="center">| <a href="/home">Home</a> | | <a href="/employee/list" id="listLink">List Employees</a> |</p>
        
        
         
        
        
        
        
        
    </body>
</html>