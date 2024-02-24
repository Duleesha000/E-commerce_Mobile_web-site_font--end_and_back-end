import {
  MDBCol,
  MDBContainer,
  MDBInput,
  MDBRow
} from 'mdb-react-ui-kit';
import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import zxcvbn from 'zxcvbn';
import './Styles.css';



export default function Register() {



  const [formData, setFormData] = useState({
    email: '',
    password: '',
    username: '',
  });

  const [errors, setErrors] = useState({
    email: '',
    password: '',
    username: '',
  });


  const handlePasswordChange = (e) => {
    const { name, value } = e.target;
    const strength = zxcvbn(formData.password);
    const score = strength.score;
    if (score >= 3) {
      // Password is strong enough, no errors
      setErrors({ ...errors, password: '' });
    } else {
      // Password is weak, show error
      setErrors({
        ...errors,
        password: 'Password is too weak. Add more flare!',
      });
    }

    setFormData({ ...formData, [name]: value });

  }


  const handleInputChange = (e) => {
    const { name, value } = e.target;
    
    setFormData({ ...formData, [name]: value });
  };

  const push = async (username, password, email) => {
    try {
      const validationErrors = {};

      const response = await fetch("http://localhost:8082/users/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: `{
          "username": "${username}",
          "email": "${email}",
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
        validationErrors.user = 'Sorry! user with the same name or email already exists';
        setErrors(validationErrors);
      }
    }
    catch (err) {
      console.log(err);
    }
  }

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate email and password fields
    const validationErrors = {};

    if (!formData.username) {
      validationErrors.user = 'username is required';
    }

    if (formData.username < 3) {
      validationErrors.user = 'username must be at least 3 characters long'
    }


    if (!formData.email) {
      validationErrors.email = 'Email is required';
    }

    if (!formData.password) {
      validationErrors.password = 'Password is required';
    }

    const strength = zxcvbn(formData.password);
    const score = strength.score;
    if (score < 3) {
      // Password is weak, show error
      validationErrors.password = 'Password is too weak. Add more flare!'; 
    }
    else {
      validationErrors.password = '';
    }


    // Set validation errors if any
    setErrors(validationErrors);

    // If no validation errors, you can proceed with form submission logic
    if (Object.keys(validationErrors).length === 0) {
      // Add your logic here, e.g., send the form data to a server
      push(formData.username, formData.password, formData.email);



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
              {errors.user && <div className="text-danger">{errors.user}</div>}
              <MDBInput
                wrapperClass='mb-4'
                label='username'
                id='formControlLg'
                type='name'
                size="lg"
                name="username"
                value={formData.username}
                onChange={handleInputChange}
              />

              {errors.email && <div className="text-danger">{errors.email}</div>}
              <MDBInput
                wrapperClass='mb-4'
                label='Email address'
                id='formControlLg'
                type='email'
                size="lg"
                name="email"
                value={formData.email}
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
                value={formData.password}
                onChange={handlePasswordChange}
              />





              <Button
                variant="primary"
                size="lg"
                type="submit"

                style={{
                  marginRight: '10px',
                  background:
                    'linear-gradient(to right, rgba(101, 126, 234, 0.9), rgba(118, 75, 162, 0.9))',
                }}

                className="custom-button2"
              // Add type="submit" to the button
              >
                Register
              </Button>

              <br />
              <br />
              <a href='/login'><Button
                variant="primary"
                size="md"

                style={{

                  background:
                    'linear-gradient(to right, rgba(118, 75, 162, 0.7, rgba(101, 126, 234, 0.7)',
                }}

                className="custom-button2"
              // Add type="submit" to the button
              >
                Login instead
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

