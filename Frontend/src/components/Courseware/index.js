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
            'http://localhost:6969/student/1',
        );
        setCourseList(result.data.courses);
        setCourse([result.data.courses[0].course])   
        setLecturer(result.data.courses[0].course.lecturers)
    }, [])

    const onChangeCourse = async (courseId) => {
        console.log(courseId);
        const result = await axios(
            'http://localhost:6969/course/'+courseId,
        );
        setChoose(0)
        setCourse([result.data])
        setLecturer(result.data.lecturers)
    }

    const onChangeLecturer = (lecturerId) => {
        if (lecturerId === "0") {
            setLecturer(course[0].lecturers)
            setChoose(0)
            return;
        }
        course[0].lecturers.map(x => {
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