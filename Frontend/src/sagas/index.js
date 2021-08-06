
import { all } from 'redux-saga/effects'
import accountSaga from './accountSaga';
import adminSaga from './adminSaga';
import studentSaga from './studentSaga';
import lecturerSaga from './lecturerSaga';
import fileSaga from './fileSaga';
import transactionHistorySaga from './transactionHistorySaga';

export default function* rootSaga() {
    yield all([
        accountSaga(), studentSaga(), adminSaga(), fileSaga(), lecturerSaga(), transactionHistorySaga()
    ])
}