import { useState, FC } from 'react';
import { useNavigate } from 'react-router-dom';
import * as Yup from "yup";
import { Formik, Field, Form, ErrorMessage } from "formik";

import logo from './../damdaticon.png';
import AuthService from "../services/auth.service";

interface IUserForm {
  username: string;
  password: string;
}

const Login: FC = () => {
  const [status, setStatus] = useState(false);
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  const initialValuse: IUserForm = {
    username: "",
    password: "",
  };
  
  const validationSchema = Yup.object().shape({
    username: Yup.string().required("Id를 입력해주세요."),
    password: Yup.string().required("비밀번호를 입력해주세요."),
  });
  
  const HandleLogin = (formValue: { username: string, password: string }) => {
    const { username, password } = formValue;
    setStatus(true);

    AuthService.login(username, password).then(() => {
      navigate("/");
    },
    error => {
      const resMessage = (error.response && error.response.data && error.response.data.message) || error.messeage || error.toString();

      setMessage(resMessage);
      setStatus(false);
    })
  }

  return (
    <div className="col-mid-12">
      <div className="card card-container">
        <img src={logo} alt="logo" />
        <Formik initialValues={initialValuse} validationSchema={validationSchema} onSubmit={HandleLogin}>
          <Form>
            <div className="form-group">
              <label htmlFor="usernmae">Username</label>
              <Field name="username" type="text" className="form-control" />
              <ErrorMessage name="username" component="div" className="alert alert-danger" />
            </div>

            <div className="form-group">
              <label htmlFor="password">Password</label>
              <Field name="password" type="password" className="form-control" />
              <ErrorMessage name="password" component="div" className="alert alert-danger" />
            </div>

            <div className="form-group">
              <button type="submit" className="btn btn-primary btn-block" disabled={status}>
                {status && (<span className="spinner-border spinner-border-sm"></span>)}
                <span>Login</span>
              </button>
            </div>

            {message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert"> {message} </div>
              </div>
            )}
          </Form>
        </Formik>
      </div>
    </div>
  )
}

export default Login;