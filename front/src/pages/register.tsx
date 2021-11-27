import { useState, FC } from 'react';
import * as Yup from "yup";
import { Formik, Field, Form, ErrorMessage } from "formik";

import logo from './../damdaticon.png';
import AuthService from "../services/auth.service";

interface IUserForm {
  username: string;
  password: string;
}

const Register: FC = () => {
  const [successful, setSuccessful] = useState(false);
  const [message, setMessage] = useState("");

  const initialValuse: IUserForm = {
    username: "",
    password: "",
  };
  
  const validationSchema = Yup.object().shape({
    username: Yup.string()
    .test("len", "ID는 4자리에서 15자리 사이입니다.", (val: any) => val && val.toString().length >= 4 && val.toString().length <= 15)
    .required("ID를 입력해주세요."),
    password: Yup.string()
    .test("len", "비밀번호는 10자리에서 20자리 사이입니다.", (val: any) => val && val.toString().length >= 4 && val.toString().length <= 20)
    .required("비밀번호를 입력해주세요."),
  });
  
  const HandleRegister = (formValue: { username: string, password: string }) => {
    const { username, password } = formValue;
    setSuccessful(false);

    AuthService.register(username, password)
    .then(
        response => {
            setMessage(response.data);
            setSuccessful(true);
        },
        error => {
            const resMessage = (error.response && error.response.data && error.response.data.message) || error.messeage || error.toString();
            
            setMessage(resMessage);
            setSuccessful(false);
        })
    }

  return (
    <div className="col-mid-12">
      <div className="card card-container">
        <img src={logo} alt="logo" />
        <Formik initialValues={initialValuse} validationSchema={validationSchema} onSubmit={HandleRegister}>
        <Form>
              {!successful && (
                <div>
                  <div className="form-group">
                    <label htmlFor="username"> Username </label>
                    <Field name="username" type="text" className="form-control" />
                    <ErrorMessage
                      name="username"
                      component="div"
                      className="alert alert-danger"
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="password"> Password </label>
                    <Field
                      name="password"
                      type="password"
                      className="form-control"
                    />
                    <ErrorMessage
                      name="password"
                      component="div"
                      className="alert alert-danger"
                    />
                  </div>

                  <div className="form-group">
                    <button type="submit" className="btn btn-primary btn-block">Sign Up</button>
                  </div>
                </div>
              )}

              {message && (
                <div className="form-group">
                  <div
                    className={
                      successful ? "alert alert-success" : "alert alert-danger"
                    }
                    role="alert"
                  >
                    {message}
                  </div>
                </div>
              )}
            </Form>
        </Formik>
      </div>
    </div>
  )
}

export default Register;