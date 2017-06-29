import React from 'react';
import Score from './Score.jsx';
import {connect} from 'react-redux';
import store from '../main.js';
import Feedback from './Feedback.jsx';
import { browserHistory } from 'react-router'
import Center from 'react-center';



class FeedbackParent extends React.Component {
 constructor(props) {
      super(props);

      this.state ={
        sentimentscores:[],
        loadingDataInd :'true',
        feedback:this.props.feedback,
        feedbackText:'',
        noFeedbackInd:'false',



       TextStyle :{
       "fontSize":"100%",
       "fontWeight":"600",
        "fontFamily":"Verdana",
         "color" : "#032542",

    },
        ErrorStyle :{
        "fontSize":"100%",
        "fontFamily":"Verdana",
        "color" : "red",

        },
         SubmitButtonStyle :{
            "backgroundColor":"#547c07",
            "border":"none",
            "color":"white",
            "padding":"5px 20px","textAlign":"center",
            "textDecoration":"none",
            "display":"inline-block",
            "fontSize":"16px",
            "margin":"4px 0px",
            "cursor":"pointer",
            "borderRadius":"8px"
        },
        ViewscoresButtonStyle :{
            "backgroundColor":"#FF4500",
            "border":"none",
            "color":"white",
            "padding":"5px 12px","textAlign":"center",
            "textDecoration":"none",
            "display":"inline-block",
            "fontSize":"16px",
            "margin":"4px 2px",
            "cursor":"pointer",
            "borderRadius":"8px"
        },
         FeedbackBlockStyle :{
         "background":'#f2f5f9',
        "borderStyle":"groove",
        "borderRadius":"35px",
        "borderWidth":"2px",
         "marginBottom":"1.5%",
         "marginLeft":"20%",
         "marginRight":"20%",
         "paddingLeft":'3%',
         "paddingRight":'3%',
         "paddingBottom":"0.5%",
         "paddingTop":"0.5%",
        "height":"100%",
    },
    FeedbackStyle :{

         "paddingTop":"0.5%",

        },

      }

      this.handleSubmit = this.handleSubmit.bind(this)
      this.updateFeedbackText = this.updateFeedbackText.bind(this)
      this.handleViewScores = this.handleViewScores.bind(this)
   };

componentWillMount() {
      //make Ajax call to get the data;
      var $ = require("jquery");
           $.ajax({
          url: "http://localhost:8080/sentiment/webapi/posts",
          dataType: 'json',
          cache: false,
          success: function(data) {
            console.log(data);
              this.setState({sentimentscores: data});
              this.setState({loadingDataInd: 'false'});
          }.bind(this),
          error: function(xhr, status, err) {
            console.error(this.props.url, status, err.toString());
            this.setState({loadingDataInd: 'false'});
            alert("Web Service call failed... Please check the connection")

          }.bind(this)
            });

   }
   handleSubmit() {
       if(this.state.feedbackText.trim()!='')
       {
           console.log('inside if:'+this.state.feedbackText);
           this.state.noFeedbackInd='false';
//           this.state.feedback.feedbackText=this.state.feedbackText.trim();

            var postRequest = { "postText":this.state.feedbackText.trim()};
            console.log('before json convert'+postRequest);
            console.log('after json convert'+JSON.stringify(postRequest));
           this.state.feedback.feedbackText=JSON.stringify(postRequest);
           this.state.feedback.feedbackSubmittedInd='true';
           this.state.feedbackText='';
 //          console.log('before store.dispatch:'+this.state.feedback);
           store.dispatch({type:'storefeedback', payload:this.state.feedback});
           // clear the input textarea after submitting
             this.input.clear();

                   //make Ajax call to get the data;
      var $ = require("jquery");
           $.ajax({
          url: "http://localhost:8080/sentiment/webapi/posts",
          dataType: 'json',
          cache: false,
          success: function(data) {
            console.log(data);
              this.setState({sentimentscores: data});
              this.setState({loadingDataInd: 'false'});
          }.bind(this),
          error: function(xhr, status, err) {
            console.error(this.props.url, status, err.toString());
            this.setState({loadingDataInd: 'false'});
            alert("Web Service call failed. Please check the connection")

          }.bind(this)
            });
           this.forceUpdate();
           console.log("before return");
           return;
       }
       if(this.state.feedbackText.trim()=='')
       {
           this.state.noFeedbackInd='true';
           this.forceUpdate();
           return;
       }
   }


    updateFeedbackText(e) {
     this.state.feedbackText = e.target.value;
   }
   handleViewScores() {
        //Route to Sentiment Scores
     browserHistory.push('/scores')
   }
   render() {
      return (
         <div>
              <div style={this.state.FeedbackBlockStyle}>
                   <label style={this.state.TextStyle}>
                    Post New Conversation:
                    </label>
             <div style={this.state.FeedbackStyle}>
                <Feedback  ref={input => this.input = input} updateFeedbackTextProp={this.updateFeedbackText}/>
                <br/>
            </div>
                <Center>
                    <button style={this.state.SubmitButtonStyle} onClick={this.handleSubmit}>Submit</button>
                </Center>


                 {(this.state.noFeedbackInd=='true')?
                <div>
                    <p style={this.state.ErrorStyle}>Please enter your post before submitting</p>
                </div>:''
                }
                </div>
         <Score sentimentscores={this.state.sentimentscores} loadingDataInd={this.state.loadingDataInd}></Score>
         </div>
      );
   }
}

function mapStateToProps(state){
    return {
        feedback : state.feedback
    };
}

export default connect(mapStateToProps) (FeedbackParent);
