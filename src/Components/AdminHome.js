import React, { useState } from "react";
import Chart from "react-apexcharts";
import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import './Styles.css';
export default function Adminhome() {

const [state,setstate]=useState ({

  
    options: {
      chart: {
        id: "basic-bar"
      },
      xaxis: {
        categories: [1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999]
      }
    },
    series: [
      {
        name: "series-1",
        data: [30, 40, 45, 50, 49, 60, 70, 91,66]
      }
    ]
 

});
    return (
     
<div className="Align">
<Container>
      <Row>
        <Col><div className="Frame2" style={{width: 276, height: 119, position: 'relative', background: 'linear-gradient(270deg, #EC5844 0%, #F203F7 100%)', boxShadow: '0px 4px 4px rgba(0, 0, 0, 0.25)', borderRadius: 22, border: '1px rgba(0, 0, 0, 0.10) solid'}}><center><h3 style={{paddingTop:'10px',color:'whitesmoke'}}>Sold Quantity</h3></center></div></Col>
        <Col><div className="Frame2" style={{width: 276, height: 119, position: 'relative', background: 'linear-gradient(270deg, #EC5844 0%, #F203F7 100%)', boxShadow: '0px 4px 4px rgba(0, 0, 0, 0.25)', borderRadius: 22, border: '1px rgba(0, 0, 0, 0.10) solid'}}><center><h3 style={{paddingTop:'10px',color:'whitesmoke'}}>Available Quantity</h3></center></div></Col>
        <Col><div className="Frame2" style={{width: 276, height: 119, position: 'relative', background: 'linear-gradient(270deg, #EC5844 0%, #F203F7 100%)', boxShadow: '0px 4px 4px rgba(0, 0, 0, 0.25)', borderRadius: 22, border: '1px rgba(0, 0, 0, 0.10) solid'}}><center><h3 style={{paddingTop:'10px',color:'whitesmoke'}}>Today Balance</h3></center></div></Col>
      </Row>
    </Container>
    <br></br> <br></br> <br></br> <br></br>

    
            <Chart
              options={state.options}
              series={state.series}
              type="bar"
              width="500"
            />
          


</div>
    
    );
  }