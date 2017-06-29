import { combineReducers } from 'redux'
import feedbackreducer from './feedback-reducer.js'
import sentimentscorereducer from './sentiment-score-reducer.js'

const reducer = combineReducers({
  feedback : feedbackreducer,
  sentimentscores : sentimentscorereducer,
})

export default reducer;