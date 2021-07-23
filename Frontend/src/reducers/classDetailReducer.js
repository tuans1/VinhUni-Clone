export const FETCH_CLASS_DETAIL = "FETCH_CLASS_DETAIL";
export const FETCH_CLASS_DETAIL_SUCCESS = "FETCH_CLASS_DETAIL_SUCCESS";

export const FETCH_ATTENDANCE_STUDENT = "FETCH_ATTENDANCE_STUDENT";
export const FETCH_ATTENDANCE_STUDENT_SUCCESS = "FETCH_ATTENDANCE_STUDENT_SUCCESS";
export const FETCH_DELETE_PRICE = "FETCH_DELETE_PRICE";

const initialState = {
    student: []
};

const classDetailReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_CLASS_DETAIL_SUCCESS:
            return { ...state, student: action.data.classDetail }
        case FETCH_ATTENDANCE_STUDENT_SUCCESS:
            state.student.map(x => {
                if (action.payload.studentId === x.student.id) {
                    x.student.b = action.payload.attendanceVal
                }
            })
            return { ...state }
        default:
            return { ...state }
    }
}
export default classDetailReducer;


export const onFetchClassDetail = payload => ({
    type: FETCH_CLASS_DETAIL,
    payload
})

export const onFetchClassDetailSuccess = payload => ({
    type: FETCH_CLASS_DETAIL_SUCCESS,
    payload
})

export const onFetchAttendanceStudent = payload => ({
    type: FETCH_ATTENDANCE_STUDENT,
    payload
})
