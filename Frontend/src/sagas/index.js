
import { all } from 'redux-saga/effects'
import accountSaga from './accountSaga';
import adminSaga from './adminSaga';
import courseSaga from './courseSaga';
import classDetailSaga from './classDetailSaga';
import rentHistorySaga from './rentHistorySaga';
import transactionHistorySaga from './transactionHistorySaga';

export default function* rootSaga() {
    yield all([
        accountSaga(), courseSaga(), adminSaga(), rentHistorySaga(), classDetailSaga(), transactionHistorySaga()
    ])
}