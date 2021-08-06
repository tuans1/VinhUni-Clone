import { Route, Switch } from 'react-router-dom';
import './App.css';
import 'font-awesome/css/font-awesome.min.css';
import '../node_modules/font-awesome/css/font-awesome.min.css';



import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useSelector } from 'react-redux';
import { useEffect, useRef, useState } from 'react';
import MessengerCustomerChat from 'react-messenger-customer-chat';
import StudentCourseware from './components/componentStudent/Courseware';

import LecturerCourseware from './components/componentLecturer/Courseware';
import HomeWorkStudent from './components/componentStudent/Homework';
import LecturerHomework from './components/componentLecturer/Homework';
import LecturerAttendance from './components/componentLecturer/Attendance/index';
import Header from './common/Header';
function App() {

  const [loading, setLoading] = useState(false)
  const isInitialMount = useRef(true);
  const [role, setRole] = useState("");


  return (
    <div>
      <ToastContainer />
      <div className="wrap" style={{ backgroundColor: '#ecf0f1 ' }}>
        <Switch>
          <Route path="/lecturer/attendance" component={LecturerAttendance} />
          <Route path="/lecturer/courseware" component={LecturerCourseware} />
          <Route path="/lecturer/homework" component={LecturerHomework} />
        </Switch>
        <Header />
        <div className="container">
          <Route path="/student/courseware" component={StudentCourseware} />
          <Route path="/student/homework" component={HomeWorkStudent} />
        </div>
      </div>
      {/* <MessengerCustomerChat
              pageId="110458054565244"
              appId="531255731225475"
              htmlRef="http://localhost:3000"/> */}

    </div>
  );
}

export default App;
