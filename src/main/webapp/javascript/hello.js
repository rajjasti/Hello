$(document).ready(function(){
    $(':submit').on('click', function() {

        var name = $("#nameInput").val();
        if(name != ""){
            $.post('/api/hello', { name: name},
                function(data){
                    if(data != undefined && data.name != undefined){
                        $('#message').text("Hello " + data.name);
                    }
                });
        }else{
            $('#message').text("Please Enter value in the text box.");
        }

        return false;
    });
});
