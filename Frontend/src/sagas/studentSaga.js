
import { call, put, takeLatest } from 'redux-saga/effects';
import * as constants from '../reducers/studentReducer';
import Api from '../request';
import { Success, Error, Warn } from '../common/toastify';


function* fetchStudentHomeworkSaga() {
    try {
        const data = yield call(Api, `/classes/student-homework?classesId=${localStorage.getItem("classesId")}&studentId=${localStorage.getItem("studentId")}`, 'get')
        yield put({ type: constants.FETCH_STUDENT_HOMEWORK_SUCCESS, data })
    } catch (err) {
        console.log(err)
    }
}

// create account then render new list
function* fetchStudentUploadHomeworkSaga({ payload }) {
    try {
        yield fetch('http://localhost:6969/file/student-homework', {
            method: 'post',
            body: payload,
        }).then(res => {
            if (res.ok) {
                alert("File uploaded successfully.")
            }
        });
        yield fetchStudentHomeworkSaga();
    } catch (err) {
        console.log(err)
    }
}



export default function* studentSaga() {
    yield takeLatest(constants.FETCH_STUDENT_HOMEWORK, fetchStudentHomeworkSaga);
    yield takeLatest(constants.FETCH_STUDENT_UPLOAD_HOMEWORK, fetchStudentUploadHomeworkSaga);
}