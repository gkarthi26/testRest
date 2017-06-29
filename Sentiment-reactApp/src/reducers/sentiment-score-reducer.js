
let initialState =[]
export default function(state =initialState,action)
{
    switch(action.type)
    {
        case "setSentimentScores":
        {
             console.log(action.payload);
            var newState =Object.assign({},action.payload);
            console.log(newState);
            return newState;
        }
        default:
        {
            return state;
        }
    }

}