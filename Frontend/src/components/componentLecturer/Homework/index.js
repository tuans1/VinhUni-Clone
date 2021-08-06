import axios from 'axios';
import { React, useEffect, useState, useRef } from 'react';
import './style.css'
import { useDispatch, useSelector } from 'react-redux';
import Modal from 'react-bootstrap/Modal';
import { useForm } from "react-hook-form";
import * as action from '../../../reducers/lecturerReducer';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Menu from '../../../common/Menu';
export default function LecturerHomework() {

    const [classList, setClassList] = useState([]);
    const [classesId, setClassesId] = useState("");
    const isInitialMount = useRef(true);
    const dispatch = useDispatch();
    const [show, setShow] = useState(false);
    const [homeworkId, setHomeworkId] = useState("");
    const { register, formState: { errors }, handleSubmit, watch, setValue, reset } = useForm();
    const { student, homework } = useSelector(state => state.lecturerReducer)
    const [startDate, setStartDate] = useState(new Date());
    const [studentList, setStudentList] = useState([]);
    const lecturerId = 1;
    useEffect(async () => {
        if (isInitialMount.current) {
            const classes = await axios(
                'http://localhost:6969/lecturer/classes/1',
            );
            setClassList(classes.data.classes)
            isInitialMount.current = false;
        } else {
            dispatch(action.onFetchHomework(classesId))
        }
    }, [classesId])

    useEffect(async () => {
        if (isInitialMount.current) {
            isInitialMount.current = false;
        } else {
            const studentList = await axios(
                'http://localhost:6969/homework/' + homeworkId,
            );
            setStudentList(studentList.data)
        }
    }, [homeworkId])
    const handleClose = () => {
        setShow(false);
    };
    const handleShow = () => {
        reset();
        setShow(true);

    };
    const chooseClass = (id) => {
        setClassesId(id)
        localStorage.setItem("classesId", id);
    }
    const onSubmit = () => {

    }
    const getHomeworkDetail = id => {
        setHomeworkId(id)
    }
    const onDeleteHomework = id => {
        dispatch(action.onFetchHomeworkDelete(id))
    }
    return (
        <>
            <Menu />
            <div id="main" style={{ marginLeft: '250px' }}>
                <div style={{ width: '250px' }} className="d-flex">
                    <select className="form-select" defaultValue="0" onChange={e => chooseClass(e.target.value)}>
                        <option value="0" disabled>Chọn Môn học</option>
                        {classList && classList.map((x, y) => {
                            return (
                                <option value={x.id} key={y + 1}>{x.className}</option>
                            )
                        })}
                    </select>
                </div>

                {classesId &&
                    <button type="button" className="btn btn-primary" onClick={handleShow}>
                        Tạo bài tập
                    </button>}
                {/* MODAL */}

                <Modal show={show} onHide={handleClose} animation={false}>
                    <Modal.Header >
                        {/* <Modal.Title>{game._id ? "Xoá GAME" : "Thêm GAME"}</Modal.Title> */}
                    </Modal.Header>
                    <Modal.Body>
                        {/* {game._id ? `Bạn có chắc chắn xóa Game: ${game.name}` */}
                        <form>
                            <div className="mb-3 d-flex">
                                <label htmlFor="recipient-name" className="col-form-label">Nội dung :</label>
                                <input className="form-control" {...register("content", { required: true })} />
                                <span style={{ color: 'red' }}>{errors.content?.type === 'required' && "content is required !"}</span>
                            </div>
                            <div className="mb-3 d-flex">
                                <DatePicker
                                    showTimeSelect
                                    selected={startDate}
                                    onChange={(date) => setStartDate(date)}
                                    dateFormat="dd/MM/yyyy h:mm"
                                />
                            </div>
                        </form>
                        {/* } */}
                    </Modal.Body>
                    <Modal.Footer>
                        <button type="button" className="btn btn-success" onClick={onSubmit}>
                            Đồng Ý
                        </button>
                        {/* {game._id ? <Button variant="warning" onClick={onDeleteGame}>Xóa</Button> */}
                        <button type="button" className="btn btn-secondary" onClick={handleClose}>
                            Hủy
                        </button>
                        {/* } */}
                    </Modal.Footer>
                </Modal>
                <div style={{ width: '100%', marginTop: '50px' }}>
                    <div className="col-lg-5" style={{ float: 'left' }}>
                        {homework.map(x => {
                            return (
                                <div key={x.id} className="card" style={{ width: '80%' }}>
                                    <div className="card-body d-flex" style={{ justifyContent: 'space-between' }}>
                                        <div>
                                            <h5 className="card-title" onClick={() => getHomeworkDetail(x.id)}>{x.name}</h5>
                                            <p className="card-text">{x.required}</p>
                                        </div>
                                        <div>
                                            <a href="#" className="card-link">Sửa</a>
                                            <a href="#" onClick={() => onDeleteHomework(x.id)} className="card-link">Xóa</a>
                                        </div>
                                    </div>
                                </div>
                            )
                        }
                        )}

                    </div>
                    <div className="col-lg-7" style={{ backgroundColor: 'white', float: 'right' }}>
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th >STT</th>
                                    <th >Họ Tên</th>
                                    <th >Thời gian nạp</th>
                                    <th >File</th>
                                </tr>
                            </thead>
                            <tbody>
                                {studentList.map((x, y) => {
                                    return (
                                        <tr key={y + 1}>
                                            <td>{y + 1}</td>
                                            <td>{x.name}</td>
                                            <td>{x.createDate}</td>
                                            <td>
                                                {x.path ? <a target="_blank" href={`http://localhost:6969/file/download/${x.path}`} >Tải</a> : ""}
                                            </td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    )
}