import { combineReducers } from 'redux';
import accountReducer from '../reducers/accountReducer';
import courseReducer from '../reducers/courseReducer';
import adminReducer from '../reducers/adminReducer';
import rentHistoryReducer from './rentHistoryReducer';
import priceReducer from './priceReducer';
import transactionHistoryReducer from './transactionHistoryReducer';

const rootReducer = combineReducers({
    accountReducer, courseReducer, adminReducer, rentHistoryReducer, priceReducer, transactionHistoryReducer
})

export default rootReducer;