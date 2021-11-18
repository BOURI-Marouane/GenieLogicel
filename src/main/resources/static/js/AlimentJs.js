	
$(document).ready(function() {
			$(' .nBtn').on('click', function(event) {
				event.preventDefault();
				var href = $(this).attr('href');
				var text = $(this).text();
				$.get(href, function(p, status) {			
					$('.MyForme #idProduit').val(p.idAliments);					
					});	
				    $('.MyForme #example').modal();
			  });
		});
		

$(document).ready(function() {
	$(' .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
	
		$.get(href, function(p, status) {
		$('.FormMy #id').val(p.id);
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