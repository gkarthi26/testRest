import React from 'react';

class Feedback extends React.Component {

 constructor(props) {
      super(props);
		
      this.state = {
         
    TextAreaStyle :{
        "fontSize":"80%",
        "fontFamily":"Verdana",
        "height":"100px","width":"100%",
         "color" : "#032542",
        },
      }
      
   };
 clear() {
    this.input.value = '';
  }

   render() {
      return (                  
                    <textarea  style={this.state.TextAreaStyle} ref={input => this.input = input} 
                   onChange={this.props.updateFeedbackTextProp} placeholder="post here...."/>
      );
   }
}



export default Feedback;
