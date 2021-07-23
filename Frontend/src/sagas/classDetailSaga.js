
import { call, put, takeLatest } from 'redux-saga/effects';
import * as constants from '../reducers/classDetailReducer';
import Api from '../request';
import { Success, Error, Warn } from '../common/toastify';

// get list account in Account + Admin PAGE
function* fetchClassDetailSaga({ payload }) {
    try {
        const data = yield call(Api, `/classes?classesId=${payload.classesId}&lesson=${payload.lesson}`, 'get')
        data.classDetail.sort((a, b) => a.student.name !== b.student.name ? a.student.name > b.student.name ? -1 : 1 : 0);
        data.classDetail.map(x => {
            switch (data.lesson) {
                case "b1": x.student.b = x.attendance.b1
                    break;
                case "b2": x.student.b = x.attendance.b2
                    break;
                case "b3": x.student.b = x.attendance.b3
                    break;
                case "b4": x.student.b = x.attendance.b4
                    break;
                default: x.student.b = x.attendance.b5
                    break;
            }
        })
        yield put({ type: constants.FETCH_CLASS_DETAIL_SUCCESS, data })
    } catch (err) {
        console.log(err)
    }
}


function* fetchAttendanceStudent({ payload }) {
    try {
        const data = yield call(Api, `/attendance?attendanceId=${payload.attendanceId}&attendanceVal=${payload.attendanceVal}&lesson=${payload.lesson}`, 'post')
        if (data) {
            yield put({ type: constants.FETCH_ATTENDANCE_STUDENT_SUCCESS, payload })
        }
    } catch (err) {
        console.log(err)
    }
}


// function* fetchDeleteClassDetailSaga({ payload }) {
//     try {
//         yield call(Api, '/price/delete', 'delete', JSON.stringify({ id: payload }));
//         yield call(Success, { message: "Xóa Giờ thuê thành công !" })
//         yield fetchClassDetailSaga();
//     } catch (err) {
//         console.log(err)
//     }
// }


export default function* classDetailSaga() {
    yield takeLatest(constants.FETCH_CLASS_DETAIL, fetchClassDetailSaga);
    yield takeLatest(constants.FETCH_ATTENDANCE_STUDENT, fetchAttendanceStudent);
    // yield takeLatest(constants.FETCH_DELETE_PRICE, fetchDeleteClassDetailSaga);
}