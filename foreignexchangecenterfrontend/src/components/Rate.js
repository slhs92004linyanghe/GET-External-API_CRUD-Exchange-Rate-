import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';
import PutButton from './PutButton'
export default function Rate() {
  const paperStyle = { padding: "50px 20px", width: 600, margin: "20px auto" }
  // const classes = useStyle();
  const [id, setId] = React.useState('')
  const [date, setDate] = React.useState('')
  const [usdToNtd, setUsdToNtd] = React.useState('')
  const [rmbToNtd, setRmbToNtd] = React.useState('')
  const [usdToRmb, setUsdToRmb] = React.useState('')
  const [rate, setRate] = React.useState([])

  // add rate
  const handleClick = (e) => {
    e.preventDefault()
    const rate = { id, date, usdToNtd, rmbToNtd, usdToRmb }
    console.log(rate)
    fetch("http://localhost:8888/api/rates", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(rate)
    }
    ).then(() =>
      console.log("New Rate Added")

    )
    window.location.reload()
  }

  // read rate
  const handleRead = (e) => {

    e.preventDefault()
    const rate = { id, date, usdToNtd, rmbToNtd, usdToRmb }
    fetch("http://localhost:8888/api/rates/" + id, {
      method: "get",
      headers: { "Content-Type": "application/json" },
    }
    ).then((res) =>{
      if (res.status === 404) {
        throw new Error("请求的资源未找到")
   
        // console.log(res.json),
          
      // console.log("Read Rate Complete"),
      }
           return res.json()
    }
    
    
    ).then((data) => {
      console.log(data.date)
      setDate(data.date)
      setUsdToNtd(data.usdToNtd)
      setRmbToNtd(data.rmbToNtd)
      setUsdToRmb(data.usdToRmb)
    })
      .catch((e) => {
        console.log(e);
        setDate("找不到")
      setUsdToNtd("找不到")
      setRmbToNtd("找不到")
      setUsdToRmb("找不到")
      });
  }



  // const [showTextField, setShowTextField] = React.useState(false);
  // put rate
  const handlePut = (e) => {
    e.preventDefault()
    const rate = { id, date, usdToNtd, rmbToNtd, usdToRmb }
    console.log(rate)
    fetch("http://localhost:8888/api/rates", {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(rate)
    }
    ).then(() =>
      console.log("New Rate Added")

    )
  }

  // delete rate
  const handleDelete = (e) => {
    e.preventDefault()
    console.log(e.target.id)
    // const rate = { id, date, usdToNtd, rmbToNtd, usdToRmb }
    // console.log(rate)
    fetch("http://localhost:8888/api/rates/" + e.target.id, {
      method: "DELETE"
    }).then((response) => {
      if (!response.ok) {
        throw new Error('Something went wrong')
      }
    })
      .catch((e) => {
        console.log(e);
      });
    window.location.reload()
  }

  // getAllRates
  React.useEffect(() => {
    fetch("http://localhost:8888/api/rates")
      .then(res => res.json())
      .then((result) => {
        setRate(result);
      }
      )
  }, [])

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{ color: "blue" }}><u> Rate Center</u></h1>
        <Box
          component="form"
          sx={{
            '& > :not(style)': { m: 1 },
          }}
          noValidate
          autoComplete="off"
        >
          {/* ID	Date	USD To NTD	RMB To NTD	USD To RMB	Action */}

          <TextField id="outlined-basic" label="Rate Id" variant="outlined"
            fullWidth value={id}
            onChange={(e) => setId(e.target.value)}
          />
          {/* 查詢的按鈕 */}
          <Button variant="contained" color="error" onClick={handleRead}>
            read
          </Button>

          <TextField id="outlined-basic" label="Rate Date " variant="outlined"
            fullWidth value={date}
            onChange={(e) => setDate(e.target.value)}
          />
          <TextField id="outlined-basic" label="USD To NTD" variant="outlined"
            fullWidth value={usdToNtd}
            onChange={(e) => setUsdToNtd(e.target.value)}
          />
          <TextField id="outlined-basic" label="RMB To NTD" variant="outlined"
            fullWidth value={rmbToNtd}
            onChange={(e) => setRmbToNtd(e.target.value)}
          />
          <TextField id="outlined-basic" label="USD To RMB" variant="outlined"
            fullWidth value={usdToRmb}
            onChange={(e) => setUsdToRmb(e.target.value)}
          />

        </Box>
        {/* 新增的按鈕 */}
        <Button variant="contained" color="success" onClick={handleClick}>
          add
        </Button>
        &nbsp;

      </Paper>
      <Paper elevation={3} style={paperStyle}>

        {rate.map(rate => (
          <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={rate.id}>
            Id:{rate.id}<br />
            Date:{rate.date}
            {/* {showTextField &&<TextField id="outlined-basic" label="Rate Date " variant="outlined" }
             value={date}
            onChange={(e) => setDate(e.target.value)}
          />} */}

            <br />
            USD To NTD:{rate.usdToNtd}<br />
            RMB To NTD:{rate.rmbToNtd}<br />
            USD To RMB:{rate.usdToRmb}<br />
            <div style={{ display: 'flex' }}>
              <PutButton inputValue={rate.id} />
            </div>
            <Button id={rate.id} variant="contained" color="error" onClick={handleDelete} style={{ margin: "5px" }}>
              Delete
            </Button>

            <div>

            </div>
          </Paper>
        ))}
      </Paper>
    </Container>
  );
}
