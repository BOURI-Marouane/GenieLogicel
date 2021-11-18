$(document).ready(function() {

			$('.nBtn , .table .eBtn').on('click', function(event) {
	 	
				event.preventDefault();
				var href = $(this).attr('href');
				var text = $(this).text();
				if(text=='Modifier') {
				$.get(href, function(p, status) {
					$('.myForm #id').val(p.id);
					$('.myForm #designation').val(p.designation);
					$('.myForm #prix').val(p.prix);
					$('.myForm #quantite').val(p.quantite);
					$('.myForm #pecture').val(p.image);
				}); 
				$('.myForm #exampleModal').modal();
				} else 
					{
					$('.myForm #id').val('');
					$('.myForm #designation').val('');
					$('.myForm #prix').val('');
					$('.myForm #quantite').val('');
					$('.myForm #pecture').val('');
					$('.myForm #exampleModal').modal();
					}
			});

		});