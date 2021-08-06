import { React } from 'react';
import './style.css';

export default function CourseFile(props) {


    return (
        <>
            <div className="course-file">
                <div className="file">
                    <div className="file-heading" >
                        <button type="button" className="file-btn" style={{ backgroundColor: '#3c6ac9', color: 'white' }}>Bài giảng</button>
                        <button type="button" className="file-btn">Bài tập</button>
                        <button type="button" className="file-btn">Tài liệu tham khảo</button>
                    </div>
                    <div className="file-body">
                        <table className="file-table">
                            <thead>
                                <tr>
                                    <th style={{ width: '5%' }}>STT</th>
                                    <th style={{ width: '52%' }}>Nội dung</th>
                                    <th style={{ width: '16%' }}>Người đăng</th>
                                    <th style={{ width: '14%' }}>Thời gian</th>
                                    <th style={{ width: '8%' }}>Lượt tải</th>
                                    <th style={{ width: '5%' }}></th>
                                </tr>
                            </thead>
                            <tbody>
                                {props.course[0] && props.lecturer && props.course[0].files.map((x,i) => {
                                    if (x.id === props.lecturer[0].id && props.choose === 1) {
                                        return (
                                            <tr key={x.id}>
                                                <td >1</td>
                                                <td style={{ textAlign: 'left' }}>{x.content}</td>
                                                <td >{props.lecturer[0].name}</td>
                                                <td >15:45 12/03/2021</td>
                                                <td >123</td>
                                                <td>.</td>
                                            </tr>
                                        )
                                    }
                                    if (props.choose === 0) {
                                        return (
                                            <tr key={x.id}>
                                                <td >1</td>
                                                <td style={{ textAlign: 'left' }}>{x.content}</td>
                                                {props.lecturer.map(y => {
                                                    if (y.id === x.lecturerId) {
                                                        return (
                                                            <td key={i}>{y.name}</td>
                                                        )
                                                    }
                                                })}
                                                <td >15:45 12/03/2021</td>
                                                <td >123</td>
                                                <td><a target="_blank"  href={`http://localhost:6969/file/download/${x.path}`}>TẢI </a></td>
                                            </tr>
                                        )
                                    }
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    )
}