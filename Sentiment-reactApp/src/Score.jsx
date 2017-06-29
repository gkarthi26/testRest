import React from 'react';
import { browserHistory } from 'react-router';
import store from '../main.js';
import {$} from "jquery";

class Score extends React.Component {
    constructor(props) {
        console.log("inside constructor");
      super(props);
		
      this.state ={
       
         TextStyle :{
         "fontSize":"100%",
       "fontWeight":"600",
        "fontFamily":"Verdana",
         "color" : "#032542",
        
         },
          FeedbackButtonStyle :{
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
         ScoreBlockStyle :{
         "background":'#f2f5f9',
        "borderStyle":"groove",
        "borderRadius":"0px",
        "borderWidth":"2px",
         "marginBottom":"0.25%",
         "paddingLeft":'0.5%',
         "paddingRight":'0.5%',
        //  "paddingBottom":"0.5%", 
         "paddingTop":"0.5%",
        "height":"100%",
         "marginLeft":"10%",
         "marginRight":"10%",
          "height":"100%",
          
        },
          ScoreTableStyle :{
    
         "paddingTop":"0.25%",
       
        },
      } 
      this.handleGiveFeedback = this.handleGiveFeedback.bind(this)

   };
   handleGiveFeedback() {
       //Route to Feedback
     browserHistory.push('/')
   }


    componentWillUnmount() {
      console.log('Component WILL UNMOUNT!');
       store.dispatch({type:'setSentimentScores', payload:this.state.sentimentscores});
   }
   render() {
      return (
          <div style={this.state.ScoreBlockStyle}>
                <label style={this.state.TextStyle}>Conversations:</label>
                {(this.props.sentimentscores.length!=0)?
                <div style={this.state.ScoreTableStyle}>
                
                    {this.props.sentimentscores.map((sentimentscore, i) => <DisplayScore 
                        key = {i} sentimentscoreProp = {sentimentscore}/>)}
                <br/>
                </div>:
                <div>
                    {(this.props.loadingDataInd=='true')?
                    <p style={this.state.TextStyle}>Loading....</p>
                    :<p style={this.state.TextStyle}>There are no records to show</p>}
                
                <br/>
                </div>}
            </div>
         
      );
   }
}
class DisplayScore extends React.Component {
   render() {
      return (
          <div>
                <table style={this.props.tableStyle}>
                    <tbody>
                        <tr style={this.props.trStyle}>
                             <td style={this.props.tdLStyle}>
                                {this.props.sentimentscoreProp.postText}
                            </td>
                            <td style={this.props.tdRStyle}>
                                {this.props.sentimentscoreProp.associatedTone}
                            </td>
                        </tr>
                    </tbody>
                </table>
         </div>
      );
   }
}

DisplayScore.defaultProps = {
    tdLStyle :{
        "bgcolor":"#e4e8e1",
        "borderStyle":"groove",
        "borderWidth":"0.5px",
         "fontSize":"90%",
         "fontFamily":"Verdana",
         "width":"85%",
          "paddingLeft":'0.5%',
          "color" : "#032542",
          "borderColor":"#355470",
         
    },
    tdRStyle :{
        "bgcolor":"#e4e8e1",
        "borderStyle":"groove",
        "borderWidth":"0.5px",
         "fontSize":"90%",
         "fontFamily":"Verdana",
         "width":"15%",
        "height":"50px",
        "textAlign":"center",
        "color" : "#032542",
        "borderColor":"#355470",      
       
    },
    trStyle:
    {
         "width":"100%",
        "height":"100%",    
        
    },
    tableStyle :{
        "width":"100%",
        "height":"100%" ,
         "paddingLeft":'2%',
         "paddingRight":'2%',   
          "marginTop":"0.25%",
          "marginBottom":"0.25%",
    }
}


export default Score;