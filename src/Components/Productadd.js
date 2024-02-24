
import Box from '@mui/material/Box';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Paper from '@mui/material/Paper';
import Select from '@mui/material/Select';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import TextField from '@mui/material/TextField';
import React from "react";
import './Styles.css';

const columns = [
  { id: 'name', label: 'Name', minWidth: 170 },
  { id: 'code', label: 'ISO\u00a0Code', minWidth: 100 },
  {
    id: 'population',
    label: 'Population',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  {
    id: 'size',
    label: 'Size\u00a0(km\u00b2)',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  {
    id: 'density',
    label: 'Density',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toFixed(2),
  },
];

function createData(name, code, population, size) {
  const density = population / size;
  return { name, code, population, size, density };
}

const rows = [
  createData('India', 'IN', 1324171354, 3287263),
  createData('China', 'CN', 1403500365, 9596961),
  createData('Italy', 'IT', 60483973, 301340),
  createData('United States', 'US', 327167434, 9833520),
  createData('Canada', 'CA', 37602103, 9984670),
  createData('Australia', 'AU', 25475400, 7692024),
  createData('Germany', 'DE', 83019200, 357578),
  createData('Ireland', 'IE', 4857000, 70273),
  createData('Mexico', 'MX', 126577691, 1972550),
  createData('Japan', 'JP', 126317000, 377973),
  createData('France', 'FR', 67022000, 640679),
  createData('United Kingdom', 'GB', 67545757, 242495),
  createData('Russia', 'RU', 146793744, 17098246),
  createData('Nigeria', 'NG', 200962417, 923768),
  createData('Brazil', 'BR', 210147125, 8515767),
];
const ProductAddPage = () => {
  const [categorey, setcategorey] = React.useState('');
  const [Brand, setbrand] = React.useState('');
  const [currency, setcurrency] = React.useState('');
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  const handleChangePage3 = (event, newPage) => {
    setPage(newPage);
  }

  const handleChangeRowsPerPage3 = (event) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  }

 

  const handleChange = (event) => {
    setcategorey(event.target.value)
    
  }
  const handleChanges = (event) => {
  
    setbrand(event.target.value)
  }
  const handleChanges2 = (event) => {
  
    setcurrency(event.target.value)
  };
  
  return (
    <div className="Align">
   <cenetr> <form>
 
   <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="productName" variant="outlined" />
      <TextField id="outlined-basic" label="stock_Quantity" variant="outlined" />
      <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">categorey</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={categorey}
          label="category"
          onChange={handleChange}
        >
          <MenuItem value={10}>phone</MenuItem>
          <MenuItem value={20}>Tab</MenuItem>
          <MenuItem value={30}>Pc</MenuItem>
        </Select>
      </FormControl>
      <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">Brand</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={Brand}
          label="brand"
          onChange={handleChanges}
        >
          <MenuItem value={10}>phone</MenuItem>
          <MenuItem value={20}>Tab</MenuItem>
          <MenuItem value={30}>Pc</MenuItem>
        </Select>
      </FormControl>
      <TextField id="outlined-basic" label="price" variant="outlined" />
      <TextField id="outlined-basic" label="weight" variant="outlined" />
      <TextField id="outlined-basic" label="imgUrl" variant="outlined" />
      
      <TextField id="outlined-basic" label="dimensions" variant="outlined" />
      <TextField
          id="outlined-multiline-static"
          label="Description"
          multiline
          rows={4}
          defaultValue=""
        />
        <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">currency</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={currency}
          label="brand"
          onChange={handleChanges2}
        >
          <MenuItem value={10}>phone</MenuItem>
          <MenuItem value={20}>Tab</MenuItem>
          <MenuItem value={30}>Pc</MenuItem>
        </Select>
      </FormControl>
      
      
    </Box><br></br>
  
  

  
  <button type="submit" className='custom-button8' >Add Recorde</button>
</form></cenetr><br></br>
<Paper sx={{ width: '90%' }} >
      <TableContainer sx={{ maxHeight: 440 }} >
        <Table stickyHeader aria-label="sticky table">
          <TableHead >
            <TableRow >
              <TableCell align="center" colSpan={2} style={{backgroundColor:'lightBlue'}}>
                Country
              </TableCell>
              <TableCell align="center" colSpan={3} style={{backgroundColor:'lightBlue'}}>
                Details
              </TableCell>
            </TableRow>
            <TableRow>
              {columns.map((column) => (
                <TableCell
                  key={column.id}
                  align={column.align}
                  style={{ top: 57, minWidth: column.minWidth }}
                >
                  {column.label}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rows
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((row) => {
                return (
                  <TableRow hover role="checkbox" tabIndex={-1} key={row.code}>
                    {columns.map((column) => {
                      const value = row[column.id];
                      return (
                        <TableCell key={column.id} align={column.align}>
                          {column.format && typeof value === 'number'
                            ? column.format(value)
                            : value}
                        </TableCell>
                      );
                    })}
                  </TableRow>
                );
              })}
          </TableBody>
        </Table>
      </TableContainer>
      <TablePagination
        rowsPerPageOptions={[10, 25, 100]}
        component="div"
        count={rows.length}
        rowsPerPage={rowsPerPage}
        page={page}
        onPageChange={handleChangePage3}
        onRowsPerPageChange={handleChangeRowsPerPage3}
      />
    </Paper><br></br><br></br>
    </div>
  );
};

export default ProductAddPage;
