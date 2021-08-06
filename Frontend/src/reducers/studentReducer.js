export const FETCH_STUDENT_HOMEWORK = "FETCH_STUDENT_HOMEWORK";
export const FETCH_STUDENT_HOMEWORK_SUCCESS = "FETCH_STUDENT_HOMEWORK_SUCCESS";

export const FETCH_CREATE_GAME = "FETCH_CREATE_GAME";
export const FETCH_DELETE_GAME = "FETCH_DELETE_GAME";
export const FETCH_STUDENT_UPLOAD_HOMEWORK = "FETCH_STUDENT_UPLOAD_HOMEWORK";



export const ACTIVE_NOTIFY = "ACTIVE_NOTIFY";
const initialState = {
    homework: []
};

const studentReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_STUDENT_HOMEWORK_SUCCESS:
            return { ...state, homework: action.data }
        default:
            return { ...state }
    }
}
export default studentReducer;


export const onFetchStudentHomework = () => ({
    type: FETCH_STUDENT_HOMEWORK,
})

export const onFetchStudentHomeworkSuccess = payload => ({
    type: FETCH_STUDENT_HOMEWORK_SUCCESS,
    payload
})

export const onFetchCreateGame = payload => ({
    type: FETCH_CREATE_GAME,
    payload
})

export const onFetchDeleteGame = payload => ({
    type: FETCH_DELETE_GAME,
    payload
})

export const onFetchStudentUploadHomework = payload => ({
    type: FETCH_STUDENT_UPLOAD_HOMEWORK,
    payload
})
