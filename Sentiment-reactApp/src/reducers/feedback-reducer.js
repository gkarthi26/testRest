import {$} from "jquery";

let initialState = {
    feedbackText:'null',
    feedbackSubmittedInd:'false',
    satisifactionScore:'50'
};
export default function(state =initialState,action)
{
    switch(action.type)
    {
        case "storefeedback":
        {
            console.log("hello");
            console.log("feedback:"+action.payload.feedbackText);
            var newState =Object.assign({},action.payload);
            var $ = require("jquery");
            $.ajax({
            url: "http://localhost:8080/sentiment/webapi/posts",
            type: 'post',
            contentType: 'application/json',
            data: newState.feedbackText ,
            processData: false,
            success: function( data, textStatus, jQxhr ){
                // $('#response pre').html( JSON.stringify( data ) );
                alert("Your Post has been successfully saved !!");
                 return newState;
            },
            error: function( jqXhr, textStatus, errorThrown ){
                console.log( errorThrown);
                alert("Post hasn't been saved\nWebservice call has been failed!! Please check the connection.");
            }
          });
            // We need to make webservice post call here using Ajax

        }
        default:
        {
            return state;
        }
    }


}
