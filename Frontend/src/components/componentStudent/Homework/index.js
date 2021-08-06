import { React, useEffect, useState } from 'react';
import HomeWorkHeader from './homework_header';
import HomeWorkBody from './homework_body';
import axios from 'axios';
import * as action from '../../../reducers/studentReducer';
import { useDispatch, useSelector } from 'react-redux';

export default function HomeWorkStudent() {

    const [courses, setCourse] = useState([]);
    const { homework } = useSelector(state => state.studentReducer)
    const dispatch = useDispatch();
    useEffect(async () => {
        const result = await axios(
            'http://localhost:6969/student/classes/231e',
        );
        setCourse(result.data.courses)
    }, [])
    const onChangeClasses = (id) => {
        localStorage.setItem("classesId", id);
        dispatch(action.onFetchStudentHomework());
    }

    const onSubmit = (file, id) => {
        const formData = new FormData();
        const studentHomework = {
            studentId: '231e',
            homeworkId: id,
        }
        formData.append('file', file);
        formData.append('student', JSON.stringify(studentHomework));
        dispatch(action.onFetchStudentUploadHomework(formData));
    }
    return (

        <>
            <HomeWorkHeader courses={courses} onChangeClasses={onChangeClasses} />
            <HomeWorkBody homework={homework} onSubmit={onSubmit} />

        </>
    )
}

