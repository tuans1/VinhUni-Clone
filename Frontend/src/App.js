import { Route, Switch } from 'react-router-dom';
import './App.css';
import 'font-awesome/css/font-awesome.min.css';
import '../node_modules/font-awesome/css/font-awesome.min.css';



import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useSelector } from 'react-redux';
import { useEffect, useRef, useState } from 'react';
import MessengerCustomerChat from 'react-messenger-customer-chat';

function App() {
  const { accountLoading } = useSelector(state => state.accountReducer)
  const { isLogin, adminLoading } = useSelector(state => state.adminReducer)
  const [loading, setLoading] = useState(false)
  const isInitialMount = useRef(true);
  const [role, setRole] = useState("");


  return (
    <div>
      <ToastContainer />
      <div className="wrap">
        <div className="container">
          
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
