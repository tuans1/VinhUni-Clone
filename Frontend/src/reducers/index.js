import { combineReducers } from 'redux';
import accountReducer from '../reducers/accountReducer';
import studentReducer from '../reducers/studentReducer';
import adminReducer from '../reducers/adminReducer';
import fileReducer from './fileReducer';
import lecturerReducer from './lecturerReducer';
import transactionHistoryReducer from './transactionHistoryReducer';

const rootReducer = combineReducers({
    accountReducer, studentReducer, adminReducer, fileReducer, lecturerReducer, transactionHistoryReducer
})

export default rootReducer;