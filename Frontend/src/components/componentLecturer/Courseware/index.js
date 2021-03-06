import axios from 'axios';
import { React, useEffect, useState, useRef } from 'react';
import './classes.css'
import { useDispatch, useSelector } from 'react-redux';
import Modal from 'react-bootstrap/Modal';
import { useForm } from "react-hook-form";
import * as action from '../../../reducers/fileReducer';
import Menu from '../../../common/Menu';

export default function LecturerCourseware() {

    const [courseList, setCourseList] = useState([]);
    const [classesId, setClassesId] = useState("");
    const [file, setFile] = useState({})
    const [selectedFile, setSelectedFile] = useState();
    const [isFilePicked, setIsFilePicked] = useState(false);
    const isInitialMount = useRef(true);
    const dispatch = useDispatch();
    const [show, setShow] = useState(false);
    const { register, formState: { errors }, handleSubmit, watch, setValue, reset } = useForm();
    const { files } = useSelector(state => state.fileReducer)
    useEffect(async () => {
        if (isInitialMount.current) {
            const course = await axios(
                'http://localhost:6969/lecturer/course/1',
            );
            setCourseList(course.data.course)
            isInitialMount.current = false;
        } else {
            dispatch(action.onFetchFile())
        }
    }, [classesId])
    const handleClose = () => {
        // setGame({
        //     ...DEFAULT_STATE
        // })
        setShow(false);
    };
    const handleShow = (file) => {
        reset();
        setShow(true);
        setValue('content', file.content)
        setFile(file)

    };
    const chooseCourse = (id) => {
        setClassesId(id)
        localStorage.setItem("classesId", id);
    }
    const changeHandler = (event) => {
        setSelectedFile(event.target.files[0]);
        setIsFilePicked(true)
    };
    const onSubmit = () => {
        const formData = new FormData();
        const fileDetail = {
            content: watch("content"),
            lecturerId: localStorage.getItem("lecturerId"),
            courseId: classesId,
        }
        formData.append('file', selectedFile);
        formData.append('fileDetail', JSON.stringify(fileDetail))
        dispatch(action.onFetchFileUpload(formData));
    }
    const onDeleteFile = (id) => {
        dispatch(action.onFetchFileDelete(id))
    }
    return (
        <>
            <Menu />
            <div id="main" style={{ marginLeft: '250px' }}>
                <div style={{ width: '250px' }} className="d-flex">
                    <select className="form-select" defaultValue="0" onChange={e => chooseCourse(e.target.value)}>
                        <option value="0" disabled>Ch???n M??n h???c</option>
                        {courseList && courseList.map((x, y) => {
                            return (
                                <option value={x.id} key={y + 1}>{x.name}</option>
                            )
                        })}
                    </select>
                </div>

                {classesId &&
                    <button type="button" className="btn btn-primary" onClick={handleShow}>
                        ????ng B??i gi???ng
                    </button>}
                {/* MODAL */}

                <Modal show={show} onHide={handleClose} animation={false}>
                    <Modal.Header >
                        {/* <Modal.Title>{game._id ? "Xo?? GAME" : "Th??m GAME"}</Modal.Title> */}
                    </Modal.Header>
                    <Modal.Body>
                        {/* {game._id ? `B???n c?? ch???c ch???n x??a Game: ${game.name}` */}
                        <form>
                            <div className="mb-3 d-flex">
                                <label htmlFor="recipient-name" className="col-form-label">N???i dung :</label>
                                <input className="form-control" {...register("content", { required: true })} />
                                <span style={{ color: 'red' }}>{errors.content?.type === 'required' && "content is required !"}</span>
                            </div>
                            <input type="file" name="file" onChange={changeHandler} />
                        </form>
                        {/* } */}
                    </Modal.Body>
                    <Modal.Footer>
                        <button type="button" className="btn btn-success" onClick={onSubmit}>
                            ?????ng ??
                        </button>
                        {/* {game._id ? <Button variant="warning" onClick={onDeleteGame}>X??a</Button> */}
                        <button type="button" className="btn btn-secondary" onClick={handleClose}>
                            H???y
                        </button>
                        {/* } */}
                    </Modal.Footer>
                </Modal>
                <div style={{ backgroundColor: 'white', marginTop: '50px', width: '1500px' }}>
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th >STT</th>
                                <th style={{ width: 700 }}>N???i dung</th>
                                <th >Th???i gian</th>
                                <th >File</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {files && files.map((x, y) => {
                                return (
                                    <tr key={x.id}>
                                        <td>{y + 1}</td>
                                        <td>{x.content}</td>
                                        <td>{x.createDate}</td>
                                        <td>{x.path}</td>
                                        <td>
                                            <button type="button" className="btn btn-warning" onClick={() => onDeleteFile(x.id)}>X??a</button>
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