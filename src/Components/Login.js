import {
  MDBCol,
  MDBContainer,
  MDBInput,
  MDBRow
} from 'mdb-react-ui-kit';
import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';

import './Styles.css';


export default function Login() {




  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    password: '',
  });




  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate email and password fields
    const validationErrors = {};

    if (!formData.username) {
      validationErrors.username = 'Username is required';
    }

    if (!formData.password) {
      validationErrors.password = 'Password is required';
    }


    // Set validation errors if any
    setErrors(validationErrors);

    // If no validation errors, you can proceed with form submission logic
    if (Object.keys(validationErrors).length === 0) {
      // Add your logic here, e.g., send the form data to a server
      alert(formData.username + " " + formData.password)
      checkdetails(formData.username, formData.password);
    }
  };

  const checkdetails = async (username, password) => {
    try {
      const validationErrors = {};

      const response = await fetch("http://localhost:8082/users/login",
        {
          method: "POST",
          headers: {
            'Accept': 'application/json',
            "Content-Type": "application/json;"
          },
          body: `{
            "username": "${username}",
            "password": "${password}"
          }`

        });
      const reply = await response.text();
      if (reply === "success") {
        localStorage.setItem("user", username);
        window.location.href = "/home";
      }
      else {
        console.log(reply)
        validationErrors.username = 'Username or password is incorrect';
        setErrors(validationErrors);
      }
    }
    catch (err) {
      console.log(err);
    }
  };



  return (


    <div>
      <MDBContainer fluid className="p-3 my-5">

        <MDBRow>

          <MDBCol col='10' md='6'>
            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg" class="img-fluid"
              alt="Phone imagefd" />
          </MDBCol>

          <MDBCol col='4' md='6'>


            <form onSubmit={handleSubmit}>
              
            {errors.username && <div className="text-danger">{errors.username}</div>}
              <MDBInput
                wrapperClass='mb-4'
                label='Username'
                id='formControlLg'
                type='name'
                size="lg"
                name="username"
                required={true}
                value={formData.username}
                onChange={handleInputChange}
              />
              
              {errors.password && <div className="text-danger">{errors.password}</div>}
              <MDBInput
                wrapperClass='mb-4'
                label='Password'
                id='formControlLg'
                type='password'
                size="lg"
                name="password"
                required={true}
                value={formData.password}
                onChange={handleInputChange}
              />


              <Button
                variant="primary"
                size="lg"

                style={{
                  marginRight: '10px',
                  background:
                    'linear-gradient(to right, rgba(101, 126, 234, 0.9), rgba(118, 75, 162, 0.9))',
                }}

                className="custom-button2"
                type="submit" // Add type="submit" to the button
              >
                Login
              </Button>


              <br></br>
              <br></br>
              <br></br>
              <p>Don't have an account yet?</p>
              <a href='/register'><Button
                variant="primary"
                size="md"

                style={{
                  background:
                    'linear-gradient(to right, rgba(101, 126, 234, 0.9), rgba(118, 75, 162, 0.9))',
                }}

                className="custom-button2"
              >
                Create an account
              </Button></a>
            </form>



            {/* <div className="d-flex justify-content-between mx-4 mb-4">
            <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Remember me' />
            <a href="!#">Forgot password?</a>
          </div> */}


          </MDBCol>

        </MDBRow>
        {/* <Routes>
     
      <Route exact path='/Dashboard' element={<Dashboard/>}></Route>
     
     
      </Routes> */}
      </MDBContainer></div>
  );
}

