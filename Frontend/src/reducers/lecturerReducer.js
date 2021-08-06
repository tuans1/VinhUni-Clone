export const FETCH_CLASS_DETAIL = "FETCH_CLASS_DETAIL";
export const FETCH_CLASS_DETAIL_SUCCESS = "FETCH_CLASS_DETAIL_SUCCESS";

export const FETCH_ATTENDANCE_STUDENT = "FETCH_ATTENDANCE_STUDENT";
export const FETCH_ATTENDANCE_STUDENT_SUCCESS = "FETCH_ATTENDANCE_STUDENT_SUCCESS";

export const FETCH_HOMEWORK = "FETCH_HOMEWORK";
export const FETCH_HOMEWORK_SUCCESS = "FETCH_HOMEWORK_SUCCESS";
export const FETCH_HOMEWORK_DELETE = "FETCH_HOMEWORK_DELETE";
const initialState = {
    student: [],
    homework:[]
};

const lecturerReducer = (state = initialState, action) => {
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
        case FETCH_HOMEWORK_SUCCESS :
            return {...state,homework : action.data.homework}
        default:
            return { ...state }
    }
}
export default lecturerReducer;


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

export const onFetchHomework = payload => ({
    type: FETCH_HOMEWORK,
    payload
})
export const onFetchHomeworkSuccess = payload => ({
    type: FETCH_HOMEWORK_SUCCESS,
    payload
})
export const onFetchHomeworkDelete = payload => ({
    type: FETCH_HOMEWORK_DELETE,
    payload
})