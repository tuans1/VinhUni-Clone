
import { call, put, takeLatest } from 'redux-saga/effects';
import * as constants from '../reducers/fileReducer';
import Api from '../request';

function* fetchFileSaga() {
    try {
        const data = yield call(Api, `/file/?courseId=${localStorage.getItem("classesId")}&lecturerId=${localStorage.getItem("lecturerId")}`, 'get');
        console.log(data)
        yield put({ type: constants.FETCH_FILE_SUCCESS, data })
    } catch (err) {
        console.log(err)
    }
}

function* fetchUploadFileSaga({ payload }) {
    try {
        yield fetch('http://localhost:6969/file/upload', {
            method: 'post',
            body: payload,

        }).then(res => {
            if (res.ok) {
                alert("File uploaded successfully.")
            }
        });
        yield fetchFileSaga()
    } catch (err) {
        console.log(err)
    }
}

function* fetchUploadStudentHomeworkSaga({ payload }) {
    try {
        fetch('http://localhost:6969/file/student-homework', {
            method: 'post',
            body: payload,

        }).then(res => {
            if (res.ok) {
                alert("File uploaded successfully.")
            }
        });
        
    } catch (err) {
        console.log(err)
    }
}

function* fetchDeleteFileSaga({ payload }) {
    try {
        yield call(Api, `/file/`+payload, 'delete');
        yield fetchFileSaga()
    } catch (err) {
        console.log(err)
    }
}


export default function* fileSaga() {
    yield takeLatest(constants.FETCH_FILE, fetchFileSaga);
    yield takeLatest(constants.FETCH_FILE_UPLOAD, fetchUploadFileSaga);
    yield takeLatest(constants.FETCH_FILE_DELETE, fetchDeleteFileSaga);
    yield takeLatest(constants.FETCH_STUDENT_HOMEWORK_UPLOAD, fetchUploadStudentHomeworkSaga);
}