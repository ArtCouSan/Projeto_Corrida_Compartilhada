$(document).ready(function() {
	$('.dtNascimento').mask('00/00/0000', {
		placeholder : "__/__/____"
	});
	$('.CPF').mask('000.000.000-00', {
		placeholder : "___.___.___-__"
	});
	$('.valor').mask('000.000.000.000.000,00', {
		placeholder : "R$ 000.00"
	});
});