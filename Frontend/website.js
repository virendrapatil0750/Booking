$(document).ready(function () {
    $('#sliderToggle').change(function(){
        if(this.checked){
            $('#registerationForm').removeClass('hidden');
            console.log("Working properly");
        }
        else{
            $('#registerationForm').addClass('hidden');
        }
    })
});