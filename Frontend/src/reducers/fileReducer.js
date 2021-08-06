
export const FETCH_FILE = "FETCH_FILE";
export const FETCH_FILE_SUCCESS = "FETCH_FILE_SUCCESS";

export const FETCH_FILE_UPLOAD = "FETCH_FILE_UPLOAD";
export const FETCH_FILE_UPLOAD_SUCCESS = "FETCH_FILE_UPLOAD_SUCCESS";
export const FETCH_STUDENT_HOMEWORK_UPLOAD = "FETCH_STUDENT_HOMEWORK_UPLOAD";
export const FETCH_STUDENT_HOMEWORK_UPLOAD_SUCCESS = "FETCH_STUDENT_HOMEWORK_UPLOAD_SUCCESS";

export const FETCH_FILE_DELETE = "FETCH_FILE_DELETE";
const initialState = {
    files: []

};

const fileReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_FILE_UPLOAD_SUCCESS:
            console.log(action)
            return { ...state}
        case FETCH_FILE_SUCCESS:
            return{...state,files:action.data}
        default:
            return { ...state }
    }
}
export default fileReducer;


export const onFetchFileUpload = payload => ({
    type: FETCH_FILE_UPLOAD,
    payload

})

export const onFetchFileUploadSuccess = (payload) => ({
    type: FETCH_FILE_UPLOAD_SUCCESS,
    payload
})

export const onFetchFile = () => ({
    type: FETCH_FILE,

})

export const onFetchFileSuccess = (payload) => ({
    type: FETCH_FILE_SUCCESS,
    payload
})
export const onFetchFileDelete = (payload) => ({
    type: FETCH_FILE_DELETE,
    payload
})

export const onFetchStudentHomeworkUpload = payload => ({
    type: FETCH_STUDENT_HOMEWORK_UPLOAD,
    payload
})