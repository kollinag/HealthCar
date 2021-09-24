 $(document).ready(()=>{
         $("#specCodeError").hide();
         $("#specNameError").hide();
         $("#specNoteError").hide();
              
         var specCodeError=false;
         var specNameError=false;
         var specNoteError=false;

         $("#specCode").keyup(()=>{
	      // $(this).val($(this).val().toUpperCase());
          validate_specCode();
         })

         $("#specName").keyup(()=>{
          validate_specName();
         })

         $("#specNote").keyup(()=>{
          validate_specNote();
         })

        function validate_specCode(){
            var val=$("#specCode").val();
            var exp=/^[A-Za-z]{4,10}$/;
            if(val==''){
              $("#specCodeError").show();
              $("#specCodeError").html("* Specification not Empty");
              $("#specCodeError").css('color','red');
              specCodeError=false;
            }else if(!exp.test(val)){
              $("#specCodeError").show();
              $("#specCodeError").html("* Specification Code must contains [A-Za-z] and length should be 4 to 10 ");
              $("#specCodeError").css('color','red');
              specCodeError=false;
            }else{
              $("#specCodeError").hide();
              specCodeError=true;;
            }
        }

       function validate_specName(){
        var val=$("#specName").val();
            var exp=/^[A-Za-z\.\,\']{4,100}$/;
            if(val==''){
              $("#specNameError").show();
              $("#specNameError").html("* Specification Name  not Empty");
              $("#specNameError").css('color','red');
              specCodeError=false;
            }else if(!exp.test(val)){
              $("#specNameError").show();
              $("#specNameError").html("* Specification Name must contains [A-Za-z] and length should be 4 to 10 ");
              $("#specNameError").css('color','red');
              specCodeError=false;
            }else{
              $("#specNameError").hide();
              specCodeError=true;;
            }
       }

       function validate_specNote(){
        var val=$("#specNote").val();
            var exp=/^[A-Za-z\.\,\'\S]{10,100}$/;
            if(val==''){
              $("#specNoteError").show();
              $("#specNoteError").html("* Specification Note  not Empty");
              $("#specNoteError").css('color','red');
              specCodeError=false;
            }else if(!exp.test(val)){
              $("#specNoteError").show();
              $("#specNoteError").html("* Specification Note must contains [A-Za-z] and length should be 4 to 10 ");
              $("#specNoteError").css('color','red');
              specCodeError=false;
            }else{
              $("#specNoteError").hide();
              specCodeError=true;;
            }
       }

       $("#specReg").submit(()=>{
          validate_specCode();
          validate_specName();
          validate_specNote();

          if(specCodeError && specCodeName &&specCodeNote){
            return true;

          }else{
            return false;
          }
       })


        })