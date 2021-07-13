import { React, useEffect, useState } from 'react';
import CourseInfo from './course_info';
import CourseFile from './course_file/index';
import './style.css';
import axios from 'axios';
import { useDispatch } from 'react-redux';
export default function Courseware() {
    const [courseList, setCourseList] = useState([]);
    const [course, setCourse] = useState([])
    const [lecturer, setLecturer] = useState("")
    const [choose, setChoose] = useState(0);
    const dispatch = useDispatch();
    useEffect(async () => {
        const result = await axios(
            'http://localhost:6969/student',
        );
        setCourseList(result.data.coursesDto);
        setCourse([result.data.coursesDto[0]])
        setLecturer(result.data.coursesDto[0].lecturerDTO)
    }, [])

    const onChangeCourse = async (courseId) => {
        const result = await axios(
            'http://localhost:6969/course/'+courseId,
        );
        
        setCourse([result.data])
    }

    const onChangeLecturer = (lecturerId) => {
        if (lecturerId === "0") {
            setLecturer(course[0].lecturerDTO)
            setChoose(0)
            return;
        }
        course[0].lecturerDTO.map(x => {
            if (x.id === lecturerId) {
                setLecturer([x]);
                setChoose(1)
                return;
            }
        })
    }
    return (
        <>
            <div className="course_wrap">
                <CourseInfo courseList={courseList} onChangeLecturer={onChangeLecturer} course={course} onChangeCourse={onChangeCourse} />
                <CourseFile courseList={courseList} lecturer={lecturer} course={course} choose={choose} />
            </div>
        </>
    )
}