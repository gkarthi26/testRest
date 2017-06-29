import React from 'react';
import FeedbackParent from './FeedbackParent.jsx';
import Score from './Score.jsx';
import Center from 'react-center';

class Home extends React.Component {

 constructor(props) {
      super(props);
		
      this.state = {
          TextStyle :{
        "fontSize":"250%",
        "fontFamily":"Verdana",
        "textAlign":"center",
        "color" : "#efc802",
         "marginBottom":"1%",
        "marginTop":"1%",
        
    },
     PageStyle :{
         "background":'#032542',
        //  "PaddingTop":'10%',
        //  "paddingLeft":'20%',
        //  "paddingRight":'20%',
        //  "border":"1px solid black",
         "height":"100%",
         
        },      
      }    
   };


   render() {
      return (
        <div style={this.state.PageStyle}>
            <Center>
             <label style={this.state.TextStyle}>
                     Communication Center
                    </label>
             </Center>
              <div>           
                    <FeedbackParent></FeedbackParent>
             </div>
         </div>
      );
   }
}



export default Home;
