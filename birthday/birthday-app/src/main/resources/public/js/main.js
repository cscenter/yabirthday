$('document').ready(function() {
    $('#loghide').hide();
    $("#myModal").modal('show');
    $("input").keypress(function(event) {
        if (event.which == 13) {
            event.preventDefault();
            //$("form").submit();

			if ($('input').val() == 'Hello') {
                $("#myModal").modal('hide');
                $('#loghide').show();
            }
            else {
                alert('Wrong!');
            }
        }
    });
})

