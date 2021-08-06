import axios from 'axios';
import { React, useEffect, useState } from 'react';
import './style.css'
import { useDispatch, useSelector } from 'react-redux';
import * as action from '../../../reducers/lecturerReducer';
import Menu from '../../../common/Menu';
export default function LecturerAttendance() {

    const [courseList, setCourseList] = useState([]);
    const [classesId, setClassesId] = useState("")
    const [lesson, setLesson] = useState("")
    const { student } = useSelector(state => state.lecturerReducer);

    const dispatch = useDispatch();

    useEffect(async () => {
        const course = await axios(
            'http://localhost:6969/lecturer/1',
        );
        setCourseList(course.data.classes)
    }, [])

    useEffect(async () => {
        if (lesson !== "" && classesId !== "") {
            dispatch(action.onFetchClassDetail({ classesId, lesson }))
        } else {
            return;
        }
    }, [lesson, classesId])
    const chooseCourse = (e) => {
        setClassesId(e)
    }
    const chooseLesson = (e) => {
        setLesson(e)
    }
    const onAttendance = (e) => {
        dispatch(action.onFetchAttendanceStudent({ attendanceId: e.id, attendanceVal: e.val, lesson, studentId: e.studentId }))
    }
    return (
        <>
            <Menu />
            <div id="main" style={{ marginLeft: '250px' }}>
                {/* <button className="openbtn" onClick={e => setOpen(true)}>&#9776; Open Sidebar</button> */}
                <div style={{ width: '500px' }} className="d-flex">
                    <select className="form-select" defaultValue="0" onChange={e => chooseCourse(e.target.value)}>
                        <option value="0" disabled>Chọn Lớp học</option>
                        {courseList && courseList.map((x, y) => {
                            return (
                                <option value={x.id} key={y + 1}>{x.className}</option>
                            )
                        })}
                    </select>
                    <select className="form-select" defaultValue="0" onChange={e => chooseLesson(e.target.value)}>
                        <option value="0" disabled>Chọn buổi học</option>
                        <option value="b1">Buổi 1</option>
                        <option value="b2">Buổi 2</option>
                        <option value="b3">Buổi 3</option>
                        <option value="b4">Buổi 4</option>
                        <option value="b5">Buổi 5</option>
                    </select>
                </div>
                <div style={{ backgroundColor: 'white', marginTop: '50px', width: '1000px' }}>
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th >STT</th>
                                <th style={{ width: 400 }}>Họ Và Tên</th>
                                <th >Ngày Sinh</th>
                            </tr>
                        </thead>
                        <tbody>

                            {student.map((x, y) => {
                                return (<tr key={y + 1}>
                                    <td>{y + 1}</td>
                                    <td >{x.student.name}</td>
                                    <td >{x.student.dob}</td>
                                    <td>
                                        <div className="form-check">
                                            <label className="check-label">
                                                Có
                                                <input className="check-radio" type="radio" checked={x.student.b === 1 ? true : false} name={x.student.name} onChange={() => onAttendance({ id: x.id, val: 1, studentId: x.student.id })} />
                                                <span className="check-mark"></span>
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div className="form-check">
                                            <label className="check-label check-label-danger">
                                                Vắng
                                                <input className="check-radio-danger" type="radio" checked={x.student.b === 0 ? true : false} name={x.student.name} onChange={() => onAttendance({ id: x.id, val: 0, studentId: x.student.id })} />
                                                <span className="check-mark-danger"></span>
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div className="form-check">
                                            <label className="check-label check-label-warn">
                                                Muộn
                                                <input className="check-radio-warn" type="radio" checked={x.student.b === -1 ? true : false} name={x.student.name} onChange={() => onAttendance({ id: x.id, val: - 1, studentId: x.student.id })} />
                                                <span className="check-mark-warn"></span>
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                )
                            })}

                        </tbody>
                    </table>
                </div>
            </div>
        </>
    )
}