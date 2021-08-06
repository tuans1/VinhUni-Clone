import { React } from 'react';

export default function HomeWorkHeader(props) {


    return (

        <>
            <div className="course-info" style={{ marginBottom: '20px' }}>
                <div className="panel">
                    <div className="panel-heading" >
                        <span className="heading-text">QUẢN LÝ BÀI TẬP</span>
                    </div>
                    <div className="panel-body">
                        <p>Lớp học phần</p>
                        <select defaultValue="0" style={{ width: '400px' }} onChange={e => props.onChangeClasses(e.target.value)}>
                            <option value="0" disabled>Chọn Lớp học</option>
                            {  props.courses.map(x => {
                                return (
                                    <option key={x.classes.id} value={x.classes.id}>{x.classes.className}</option>
                                )
                            })}
                        </select>
                    </div>
                </div>
            </div>
        </>
    )
}
