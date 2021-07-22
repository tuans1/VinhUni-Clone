export const FETCH_CLASS_DETAIL = "FETCH_CLASS_DETAIL";
export const FETCH_CLASS_DETAIL_SUCCESS = "FETCH_CLASS_DETAIL_SUCCESS";
export const FETCH_CREATE_PRICE = "FETCH_CREATE_PRICE";
export const FETCH_DELETE_PRICE = "FETCH_DELETE_PRICE";

const initialState = {
    student: []
};

const classDetailReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_CLASS_DETAIL_SUCCESS:
            return { ...state, student: action.data.classDetail }
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

