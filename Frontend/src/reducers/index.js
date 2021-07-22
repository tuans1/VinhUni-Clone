import { combineReducers } from 'redux';
import accountReducer from '../reducers/accountReducer';
import courseReducer from '../reducers/courseReducer';
import adminReducer from '../reducers/adminReducer';
import rentHistoryReducer from './rentHistoryReducer';
import classDetailReducer from './classDetailReducer';
import transactionHistoryReducer from './transactionHistoryReducer';

const rootReducer = combineReducers({
    accountReducer, courseReducer, adminReducer, rentHistoryReducer, classDetailReducer, transactionHistoryReducer
})

export default rootReducer;