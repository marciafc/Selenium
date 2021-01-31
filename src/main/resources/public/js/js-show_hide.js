
$(document).ready(function () {
    $("#permissao").hide();
    $("#nome").hide();
    $("#email").hide();
    $("#atencao").hide();
});

$("#idade").change(function(){
  if ($("#idade").val() == 13) {
      $("#permissao").show();
      $("#nome").show(2000);
      $("#email").show(4000);
  }
});
