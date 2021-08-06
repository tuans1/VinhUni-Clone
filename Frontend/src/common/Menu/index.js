import { React, useState } from 'react';
import './style.css'
import {  NavLink } from 'react-router-dom';

export default function Menu() {

    const [open, setOpen] = useState(true);

    return (
        <div id="mySidebar" style={open ? { width: '250px' } : { width: 0 }} className="sidebar">
            <a href="#" className="closebtn" onClick={e => setOpen(false)}>&times;</a>
            <NavLink className="" activeClassName="" to="">About</NavLink>
            <NavLink exact to="/lecturer/homework" activeClassName="nav-active" className="nav" >Bài Tập</NavLink>
            <NavLink exact to="/lecturer/courseware" activeClassName="nav-active" className="nav" >Bài Giảng</NavLink>
            <NavLink  exact to="/lecturer/attendance" activeClassName="nav-active" className="nav">Điểm Danh</NavLink>
        </div>
    )
}
