export const FETCH_COURSE_DETAIL = "FETCH_COURSE_DETAIL";
export const FETCH_GAME_SUCCESS = "FETCH_GAME_SUCCESS";

export const FETCH_CREATE_GAME = "FETCH_CREATE_GAME";
export const FETCH_DELETE_GAME = "FETCH_DELETE_GAME";
export const FETCH_UPLOAD_IMAGE = "FETCH_UPLOAD_IMAGE";



export const ACTIVE_NOTIFY = "ACTIVE_NOTIFY";
const initialState = {
    game: []
};

const courseReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_GAME_SUCCESS:
            return { ...state, game: action.payload }
        default:
            return { ...state }
    }
}
export default courseReducer;


export const onFetchCourseDetail = payload => ({
    type: FETCH_COURSE_DETAIL,
})

export const onFetchGameSuccess = payload => ({
    type: FETCH_GAME_SUCCESS,
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

export const onFetchUploadImage = payload => ({
    type: FETCH_UPLOAD_IMAGE,
    payload
})
