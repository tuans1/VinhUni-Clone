import { React, useEffect, useState } from 'react';
import './style.css';

export default function CourseInfo(props) {


    return (
        <>
            <div className="course-info" style={{ marginBottom: '20px' }}>
                <div className="panel">
                    <div className="panel-heading" >
                        <span className="heading-text">Học phần: </span>
                        <select onChange={e => props.onChangeCourse(e.target.value)} style={{ width: '400px' }}>
                            {props.courseList && props.courseList.map(x => {
                                return (
                                    <option key={x.course.id} value={x.course.id}>{x.course.name}</option>
                                )
                            })}
                        </select>

                        <span className="heading-text">Giảng viên: </span>
                        <select onChange={e => props.onChangeLecturer(e.target.value)} style={{ width: '226px' }}>
                            <option value="0">-- TẤT CẢ --</option>

                            {props.course[0] && props.course[0].lecturers.map((x, i) => {
                                return (<option key={x.id} value={x.id}>{x.name}</option>)
                            })}

                        </select>

                    </div>
                    <div className="panel-body">
                        <div className="panel-body-image" >
                            <img src="https://image.shutterstock.com/image-photo/image-sky-on-day-time-260nw-317566805.jpg" className="panel-img" />
                        </div>
                        <div className="panel-body-text" >
                            <p>Mã học phần : </p>
                            <p>Tên học phần : </p>
                            <p style={{ height: '70px' }}>Mô tả : </p>
                            <p style={{ textAlign: 'right', color: '#215bbf' }}><i className="fa fa-arrow-right" style={{ paddingRight: 5 }}></i>Đề cương tổng quát</p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}