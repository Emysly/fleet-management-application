
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(country, status){
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});					
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
    		event.preventDefault();
    		var href= $(this).attr('href');
    		$.get(href, function(vehicleType, status){
    			$('#idDetails').val(vehicleType.id);
    			$('#descriptionDetails').val(vehicleType.description);
    			$('#detailsDetails').val(vehicleType.details);
    			$('#createdByDetails').val(vehicleType.createdBy);
    			$('#createdDateDetails').val(vehicleType.createdDate);
    			$('#lastModifiedByDetails').val(vehicleType.lastModifiedBy);
    			$('#lastModifiedDateDetails').val(vehicleType.lastModifiedDate.substr(0,19).replace("T", " "));
    		});
    		$('#detailsModal').modal();
    	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();

		var href= $(this).attr('href');

		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal();
	});
		
});