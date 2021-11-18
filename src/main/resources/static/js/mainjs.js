
	    
		$(document).ready(function() {
			$(' .table .eBtn').on('click', function(event) {
				event.preventDefault();
				var href = $(this).attr('href');
				var text = $(this).text();
				
				
			  			    
				$.get(href, function(p, status) {
				$('.FormMy #id').val(p.idAliments);
				});
				$('.FormMy #quantite').val('');
				$('.FormMy #nome').val('');
				$('.FormMy #prenome').val('');
				$('.FormMy #ville').val('');
				$('.FormMy #adresse').val('');
				$('.FormMy #telefone').val('');
				$('.FormMy #example').modal();				
			});
		});
		
		/*$(document).ready(function demoDisplay() {
			$('.ala').on('click', function(event)
					{
					document.getElementById("myP1").style.display = "none";
					console.log("salam");
					});
			}); */
		
		function demoDisplay() 
		{
		    document.getElementById("myP1").style.display = "none";
		}
				
		
		
		
		$(document).ready(function() {
			$(' .table .nBtn').on('click', function(event) {
				event.preventDefault();
				var href = $(this).attr('href');
				var text = $(this).text();
				$.get(href, function(l, status) {
					$('.Forme #idAliments').val(l.idAliments);
					$('.Forme #quantite').val(1);
					
					});	
				    $('.Forme #example').modal();
			  });
		});
		
		
		
	
	
