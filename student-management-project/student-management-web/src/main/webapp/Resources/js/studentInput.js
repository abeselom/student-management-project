/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function() {       
   
});
    
    
 function keypress(e){
//HÃ m dÃ¹ng Ä‘á»ƒ ngÄƒn ngÆ°á»�i dÃ¹ng nháº­p cÃ¡c kÃ½ tá»± khÃ¡c kÃ½ tá»± sá»‘ vÃ o TextBox
var keypressed = null;

    if (window.event)
    {
    keypressed = window.event.keyCode; //IE
    }
    else
    {
    keypressed = e.which; //NON-IE, Standard
    }

    if (keypressed < 48 || keypressed > 57)
    { //CharCode cá»§a 0 lÃ  48 (Theo báº£ng mÃ£ ASCII)
    //CharCode cá»§a 9 lÃ  57 (Theo báº£ng mÃ£ ASCII)

        if (keypressed == 8 || keypressed == 127)
        {//PhÃ­m Delete vÃ  PhÃ­m Back
        return;
        }

    return false;
    }

}
 
 function SaveStudent(){
	 alert("Save objec in here");
 }

   
 
