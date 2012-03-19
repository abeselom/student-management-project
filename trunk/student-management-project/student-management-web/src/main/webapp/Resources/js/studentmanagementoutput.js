/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



//************************************************************************************
//***Method Name	: Ham khoi tao
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: khoi tao dac doi tuong duoc su dung trong form
//***Params             

//************************************************************************************
var TABV = "\u2192";
var ENTERV = "\u2193";
$(document).ready(function () 
{
    init_event_row_in_table();
   //khai bao from sort

     humane.timeout = 800;
     humane.waitForMove = true;
     //khai bao su kien mouse hover
     $(".ui-button-text-only").hover(function() {$(this).css("color", "#b81900");$(this).addClass('ui-state-hover');}, function() {$(this).css("color", "#417394");$(this).removeClass('ui-state-hover');});
     //khai bao su kien khi click vao cac button
     $("#btn_ShowAll").click(function(){show_all();});
     $("#btn_ShowSelected").click(function(){show_selected();});
     $("#btn_Search").click(function(){
         show_dialog_search();
     });
     $("#btn_Sort_v").click(function(){show_dialog_sort();});
     $("#btn_Print").click(function(){nhaphang_print();});
     $("#btn_ExportToFile").click(function(){nhaphang_export_excel();});
     $("#btn_thoat").click(function(){
         window.location="thongkenhaphang.htm";
     });
     
     //khoi tao cho form search
     init_column_search_sort(); 
     if($.client.browser=="Explorer"){
        $("#wrapper").css("width",$("#nhaphang").css("width"));
        $(".samewidth").css("width",$("#nhaphang").css("width"));
    }else
        $("#nhaphang").css("width",$(".samewidth").css("width"));
     var height_tr = $("#nhaphang tr").css("height");
     var num_row = ((document.body.offsetHeight-250)/parseInt(height_tr)).toFixed(0);
     if($("#result_break_page").html()!="")
         num_row=$("#result_break_page").html-1;
     
     var heightTable = num_row*parseInt(height_tr);
     $("#wrapper").css("height",heightTable);

});


function start_waiting(){
    $("#waiting_result").show();
}
        

function stop_waiting(){
    $("#waiting_result").hide();
}


function init_column_search_sort(){
    var str_column_sort = $("#column_sort").html();
    var arrResult_name = new Array();
    var arrResult_index = new Array();
    
    if(str_column_sort.length>0){
        var rows = str_column_sort.split(ENTERV);
        if(rows.length>0){
            var i = 0;
            for(var j=0;j<rows.length;j++){
                var items = rows[j].toString().split(TABV);
                if(items.length==2){
                    arrResult_name[i] = items[0];
                    arrResult_index[i]=items[1];
                    i++;
                }
            }
        }
    }
    init_field_sort(arrResult_name,arrResult_index,nhaphang_sort_list_object);
    init_dialog_search(arrResult_name,arrResult_index,nhaphang_search);
   
}
function init_event_row_in_table(){
   var $table = $("#nhaphang>tbody");
   $table.children("tr").hover(function(){
       if($(this).attr("title")!="selected")
           $(this).css("background-color", "#dddddd");
   }, function(){
       if($(this).attr("title")!="selected")
           $(this).css("background-color", "white");
   });
   
   $table.children("tr").children("td:nth-child(2)").hover(function(){
       $(this).css("cursor", "pointer");
   }, function(){
       $(this).css("cursor", "");
   });
   
   
   
   $table.children("tr").children("td:nth-child(2)").click(function(){
       if($(this).parent("tr").attr("title")=="selected"){
           $(this).parent("tr").css("background-color", "white");
           $(this).parent("tr").removeAttr("title");
       }else{
           $(this).parent("tr").attr("title", "selected");
           $(this).parent("tr").css("background-color", "navajowhite");
       }
   });
}
//************************************************************************************
//***Method Name	: nhaphang_sort_list_object
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: sort du lieu
//***Params             


//************************************************************************************
function nhaphang_sort_list_object(){
    var strPage = $("#page").html();
    var $result = $("#result").html();
    var $condition_sort=get_string_condition_sort();
    var $option = $("#option").html();
    var $listID= $("#listID").html();
//    humane($listID);
    start_waiting();
    $.ajax({				
        url: 'thongkenhaphang/send_forward_ajax.htm',
        type:"POST",
             data:({
                page 	: strPage,
                result : $result,
                condition_sort:$condition_sort,
                option : $option,
                listID : $listID
             }),
             success: function(data) {
                 if(data!=""){
                     var result =data.toString().split("<@@@@>");
                     if(result.length==5){
             
                        $("#scroller").toggle("highlight", {}, 600,function(){
                            $("#scroller").html(result[0]);
                            $("#show_result_total").html(result[1]);
                            $("#result_break_page").html(result[2]);
                            $("#total_current_record").html(result[3]);
                            $("#listID").html(result[4]);
                            init_event_row_in_table();
                            if($.client.browser!="Explorer"){setTimeout(function () {myScroll.refresh();$("#nhaphang").css("width",$(".samewidth").css("width"));}, 0);}
                            $("#scroller").toggle("highlight", {}, 10,function(){stop_waiting();$("#nhaphang").css("width",$(".samewidth").css("width"));});
                            
                        });
                     }else{
                         window.location="index.htm";
                     }
                     
                 }        
             }
        });
     
}


//************************************************************************************
//***Method Name	: nhaphang_break_page
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: phuong thuc khai bao input de hien thi listObject
//***Params             
//***   Input		:
//      page            : chi dinh page can den
//************************************************************************************
function nhaphang_break_page(page){
    var $result = $("#result").html();
    var $current_page = $("#page").html();
    var $option = $("#option").html();
    var $listID= $("#listID").html();
    if($current_page==page)
        return;  
    start_waiting();
    $.ajax({				
        url: 'thongkenhaphang/send_forward_ajax.htm',
        type:"POST",
             data:({
                page 	: page,
                result : $result,
                option : $option,
                listID : $listID
             }),
             success: function(data) {
                 if(data!=""){
                     var result =data.toString().split("<@@@@>");
                     if(result.length==5){
                        $("#page").html(page);
//                        $("#show_result").toggle("highlight", {}, 600,function(){
                            $("#scroller").html(result[0]);
                            $("#show_result_total").html(result[1]);
                            $("#result_break_page").html(result[2]);
                            $("#total_current_record").html(result[3]);
                            $("#listID").html(result[4]);
                            init_event_row_in_table();
                            if($.client.browser!="Explorer"){setTimeout(function () {myScroll.refresh();$("#nhaphang").css("width",$(".samewidth").css("width"));}, 0);}
                            $("#nhaphang").css("width",$(".samewidth").css("width"));
                     }else{
                         window.location="index.htm";
                     }
                     stop_waiting();
                     
                 }        
             }
        });
}


//************************************************************************************
//***Method Name	: show_all
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: hien thi lai toan bo du lieu tren man hinh
//***Params             

//************************************************************************************
function show_all(){
 
    var $result = $("#result").html();
    var $option = $("#option").html();

    start_waiting();
    $.ajax({				
        url: 'thongkenhaphang/send_forward_ajax.htm',
        type:"POST",
             data:({
                page 	: "1",
                result : $result,
                option : $option
             }),
             success: function(data) {
//                 alert('data:'+data);
                 if(data!=""){
                     var result =data.toString().split("<@@@@>");
                     if(result.length==5){
                        $("#page").html("1");
                        $("#scroller").toggle("highlight", {}, 600,function(){
                            $("#scroller").html(result[0]);
                            $("#show_result_total").html(result[1]);
                            $("#result_break_page").html(result[2]);
                            $("#total_current_record").html(result[3]);
                            $("#listID").html(result[4]);
                            init_event_row_in_table();
                            if($.client.browser!="Explorer"){setTimeout(function () {myScroll.refresh();$("#nhaphang").css("width",$(".samewidth").css("width"));}, 0);}
                            $("#scroller").toggle("highlight", {}, 10,function(){stop_waiting();$("#nhaphang").css("width",$(".samewidth").css("width"));});
                            
                        });
                        
                     }else{
                         window.location="index.htm";
                     }
                     
                 }        
             }
        });
}

//************************************************************************************
//***Method Name	: nhaphang_print
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: print du lieu
//***Params             

//************************************************************************************
function nhaphang_print(){
 
    var $result = $("#result").html();
    var $option = $("#option").html();
    var $listID= $("#listID").html();
    start_waiting();
    $params = {
                result : $result,
                option : $option,
                listID : $listID};
    navigate_to_url("thongkenhaphang_print.htm", $params);
    stop_waiting();
           
}

//************************************************************************************
//***Method Name	: nhaphang_export_excel
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: export du lieu ra file excel
//***Params             

//************************************************************************************
function nhaphang_export_excel(){
 
    var $result = $("#result").html();
    var $option = $("#option").html();
    var $listID= $("#listID").html();
    start_waiting();
    $params = {
                result : $result,
                option : $option,
                listID : $listID};
    navigate_to_url("thongkenhaphang/export_excel.htm", $params);
    stop_waiting();
           
}
//************************************************************************************
//***Method Name	: show_selected
//***Created By		: manh
//***Created Date	: 2011/08/10
//***Desc		: hien thi nhung record ma nguoi dung chon
//***Params             

//************************************************************************************
function show_selected(){
        start_waiting();
        var $td_show = $("#nhaphang tbody>tr[title='selected']");
        if($td_show.length==0)
        {
                humane("not choose row");
                stop_waiting();
                return;
        }
        var str_list_id="";
        $td_show.each(function(){
            str_list_id +=$(this).children("td").html()+",";
         
        });
        str_list_id = str_list_id.length==0 ? "":str_list_id.substr(0, str_list_id.length-1);
        
        
        var $result = $("#result").html();
    var $option = $("#option").html();

    start_waiting();
    $.ajax({				
        url: 'thongkenhaphang/send_forward_ajax.htm',
        type:"POST",
             data:({
                page 	: "1",
                result : $result,
                option : $option,
                listID : str_list_id
             }),
             success: function(data) {
                 if(data!=""){
                     var result =data.toString().split("<@@@@>");
                     if(result.length==5){
                        $("#page").html("1");
                        $("#scroller").toggle("highlight", {}, 600,function(){
                            $("#scroller").html(result[0]);
                            $("#show_result_total").html(result[1]);
                            $("#result_break_page").html(result[2]);
                            $("#total_current_record").html(result[3]);
                            $("#listID").html(result[4]);
                            init_event_row_in_table();
                            if($.client.browser!="Explorer"){setTimeout(function () {myScroll.refresh();$("#nhaphang").css("width",$(".samewidth").css("width"));}, 0);}
                            $("#scroller").toggle("highlight", {}, 10,function(){stop_waiting();$("#nhaphang").css("width",$(".samewidth").css("width"));});
                            
                        });
                        
                     }else{
                         window.location="index.htm";
                     }
                     
                 }        
             }
        });
//        var $result = $("#result").html();
//        var $option = $("#option").html();
//        $.ajax({				
//        url: 'thongkenhaphang/get_html_totalRecord_ajax.htm',
//        type:"POST",
//             data:({
//                result : $result,
//                option : $option,
//                listID : str_list_id
//             }),
//             success: function(data) {
//                 if(data!=""){
//                    $("#total_current_record").html($td_show.length);
//                    $("#listID").html(str_list_id);
//                    $("#result_break_page").html("");
//                    $("#show_result_total").html(data);
//                    
//                    $td_show=   $("#nhaphang tbody>tr[title!='selected']").css("display","none");
//                    $("#nhaphang tbody>tr[title='selected']").css("background-color", "white");
//                    $("#nhaphang tbody>tr[title='selected']").removeAttr("title");
//                    if($.client.browser!="Explorer"){setTimeout(function () {myScroll.refresh();}, 0);}
//                    stop_waiting();
//                 }        
//             }
//        });

        
}


function nhaphang_search(){
    var $result = $("#result").html();
    var strSearch = get_string_search_result();
    var $condition_search =strSearch;
    var $option = $("#option").html();
//    humane(strSearch);
    $.ajax({				
        url: 'thongkenhaphang/send_forward_ajax.htm',
        type:"POST",
             data:({
                page 	: 1,
                result : $result,
                condition_search: $condition_search,
                option : $option
             }),
             success: function(data) {
                 if(data!=""){
                     var result =data.toString().split("<@@@@>");
                     if(result.length==5){
                        $("#page").html(1);
                        $("#scroller").toggle("highlight", {}, 600,function(){
                            $("#scroller").html(result[0]);
                            $("#show_result_total").html(result[1]);
                            $("#result_break_page").html(result[2]);
                            $("#total_current_record").html(result[3]);
                            $("#listID").html(result[4]);
                            init_event_row_in_table();
                            if($.client.browser!="Explorer"){setTimeout(function () {myScroll.refresh();}, 0);}
                            $("#scroller").toggle("highlight", {}, 10,function(){stop_waiting();$("#nhaphang").css("width",$(".samewidth").css("width"));});
                           
                        });
                     }else{
                         window.location="index.htm";
                     }
                     
                     stop_waiting();
                 }        
             }
        });
}