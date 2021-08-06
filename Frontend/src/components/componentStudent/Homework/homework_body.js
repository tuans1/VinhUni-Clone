import { React, useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import { useForm } from 'react-hook-form';
import './style.css';

export default function HomeWorkBody(props) {

    const [file, setFile] = useState();
    const [homeworkId, setHomeworkId] = useState();
    const [info, setInfo] = useState();
    const [show, setShow] = useState(false);
    const { reset } = useForm();
    
    const onSetFile = (e) => {
        setFile(e.target.files[0]);
    }
    const handleClose = () => {
        setShow(false);
    };
    const handleShow = (x => {
        reset();
        setInfo(x)
        setHomeworkId(x.id);
        setShow(true);
    })
    return (
        <>
            <div className="course-file">
                <div className="file">
                    <div className="file-heading" >
                        <button type="button" className="file-btn" style={{ backgroundColor: '#3c6ac9', color: 'white' }}>Thông Tin bài tập</button>
                    </div>
                    <div className="file-body">
                        <table className="file-table">
                            <thead>
                                <tr>
                                    <th >STT</th>
                                    <th style={{ width: '25%' }}>Nội dung</th>
                                    <th style={{ width: '' }}>Thời hạn</th>
                                    <th style={{ width: '25%' }}>Yêu cầu</th>
                                    <th style={{ width: '' }}>Thời gian nộp bài</th>
                                    <th style={{ width: '' }}>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                {props.homework && props.homework.map((x, i) => {
                                    return (
                                        <tr key={x.id}>
                                            <td >{i + 1}</td>
                                            <td >{x.homework}</td>
                                            <td >{x.deadLine}</td>
                                            <td >{x.required}</td>
                                            <td >{x.createDate}</td>
                                            <td><button type="button" id="file" className="btn btn-primary" onClick={() => handleShow(x)}>
                                                Nạp
                                            </button></td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            {/* MODAL */}
            <Modal show={show} onHide={handleClose} animation={false}>
                <Modal.Header >
                    <Modal.Title>Tải lên Bài tập</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <form>
                        <div className="d-flex">
                            <p style={{ width: '100px', textAlign: 'right' }}>Nội dung : </p><span style={{ fontWeight: 'bold', paddingLeft: '15px' }}>{info && info.homework}</span>
                        </div>
                        <div className="d-flex">
                            <p style={{ width: '100px', textAlign: 'right' }}>Thời hạn : </p><span style={{ fontWeight: 'bold', paddingLeft: '15px' }}>{info && info.deadLine}</span>
                        </div>
                        <div className="file-upload" style={{ marginTop: '20px' }}>
                            <input type="file" name="file-upload-input" onChange={(e)=>onSetFile(e)} id="file-upload-input" />
                        </div>
                    </form>
                </Modal.Body>
                <Modal.Footer style={{ display: 'flex', justifyContent: 'space-between' }}>
                    <div>
                        <span style={{ fontWeight: 'bold', color: 'green' }}>{info && info.path ? `Đã nộp bài ( ${info.createDate} )` : ""}</span>
                        <span style={{ display: 'block', fontWeight: 'bolder' }}>{info && info.path ? <a target="_blank" href={`http://localhost:6969/file/download/${info.path}`} >Xem lại bài</a> : ""}</span>
                    </div>
                    <button type="button" onClick={() => props.onSubmit(file, homeworkId)} className="btn btn-success">Nộp bài</button>
                </Modal.Footer>
            </Modal>
        </>
    )
}
