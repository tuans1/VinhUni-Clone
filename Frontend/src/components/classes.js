import axios from 'axios';
import { React, useEffect, useState } from 'react';
import './classes.css'
import { useDispatch, useSelector } from 'react-redux';
import * as action from '../reducers/classDetailReducer';
export default function Classes() {

    const [courseList, setCourseList] = useState([]);
    const [open, setOpen] = useState(true);
    const [classesId, setClassesId] = useState("")
    const [homeWork, setHomeWork] = useState([])

    const dispatch = useDispatch();

    useEffect(async () => {
        const course = await axios(
            'http://localhost:6969/lecturer/1',
        );
        console.log(course.data.classes)
        setCourseList(course.data.classes)
    }, [])

    useEffect( () => {
        courseList.map(x=>{
            if(x.id === classesId){
                setHomeWork(x.homeWork)
            }
        })
    }, [classesId])
    const chooseCourse = (e) => {
        setClassesId(e)
    }
    
    console.log(courseList)
    return (
        <>
            <div className="" >
                <div id="mySidebar" style={open ? { width: '250px' } : { width: 0 }} className="sidebar">
                    <a href="#" className="closebtn" onClick={e => setOpen(false)}>&times;</a>
                    <a href="#">About</a>
                    <a href="#">Services</a>
                    <a href="#">Clients</a>
                    <a href="#">Contact</a>
                </div>
                <div id="main" style={open ? { marginLeft: '250px' } : { marginLeft: 0 }}>
                    <div style={{ width: '250px' }} className="d-flex">
                        <select className="form-select" defaultValue="0" onChange={e => chooseCourse(e.target.value)}>
                            <option value="0" disabled>Chọn Môn học</option>
                            {courseList && courseList.map((x, y) => {
                                return (
                                    <option value={x.id} key={y + 1}>{x.className}</option>
                                )
                            })}
                        </select>
                    </div>
                    
                </div>
            </div>
        </>
    )
}