
<html>
	<head>
		<title>Simple DropWizard App</title>
		<style type="text/css">
		
		body {
			font-family : Tahoma;
		}
		
		#resDiv {
			position:relative;
			top:100px;
			left:500px;
			width:500px;
			height:auto;
			border:1px solid;
		
		}
		
		</style>
		
		<script type="text/javascript" src="/webjars/jquery/1.9.0/jquery.min.js"></script>
		
		<script type="text/javascript">
		
			$(document).ready(function(){				
				$('#resDiv').hide();
				
				// Ajax call for Listing All Employees
				
				$('#listLink').click(function(){
					$.ajax({					
						type:'GET',
						url: '/employee/list',
						success : function(response) {
						 alert(response);
						 // $('#resDiv').append('<h1 align='center'>>Employee List</h1>');
						  $('#resDiv').html(response);
						  $('#resDiv').show();					
						}				
				    });
			    });
			    
			   
			
			   
			   
			});
		 
		</script>
	</head>

    <body>
       
        <h1 align="center"><font color="green">Welcome, DropWizard !</font></h1>
        <hr/>
        
        
        <p align="center">| <a href="/create">Create Employee</a> | | <a href="/employee/list">List Employees</a> |</p>
        
       
        
        
        
        
        
        
    </body>
</html>