import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';
function PutButton(props) {

    const [id, setId] = React.useState('')
    const [date, setDate] = React.useState('')
    const [usdToNtd, setUsdToNtd] = React.useState('')
    const [rmbToNtd, setRmbToNtd] = React.useState('')
    const [usdToRmb, setUsdToRmb] = React.useState('')

    const [showTextField, setShowTextField] = React.useState(false);

    const handlePutExtend = () => {
        setShowTextField(!showTextField);
    
    };

    const handleClick = (e) => {
        e.preventDefault()
        console.log("e.target.id: "+e.target.id)
        const id =props.inputValue
        console.log("id:"+id)
        const rate = { date, usdToNtd, rmbToNtd, usdToRmb }
        console.log(rate)
        fetch("http://localhost:8888/api/rates/" + id, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(rate)
        }
        ).then(() =>
            console.log("Rate updated")
        )
        window.location.reload()
    }
    return (
        <div>
            <Button onClick={handlePutExtend} variant="contained" color="success" style={{ margin: "5px" }}>
                Edit
            </Button><br />
            <div >
                {showTextField && <TextField id="outlined-basic" label="Rate Date " variant="outlined"
                    value={date}
                    onChange={(e) => setDate(e.target.value)}
                />}
                {showTextField && <TextField id="outlined-basic" label="USD To NTD" variant="outlined"
                    value={usdToNtd}
                    onChange={(e) => setUsdToNtd(e.target.value)}
                />}
                {showTextField && <TextField id="outlined-basic" label="RMB To NTD" variant="outlined"
                    value={rmbToNtd}
                    onChange={(e) => setRmbToNtd(e.target.value)}
                />}
                {showTextField && <TextField id="outlined-basic" label="USD To RMB" variant="outlined"
                    value={usdToRmb}
                    onChange={(e) => setUsdToRmb(e.target.value)}
                />}
                {showTextField && <Button variant="contained" color="success" onClick={handleClick}>
                    Submit
                </Button>}
            </div>
        </div>
    );
}

export default PutButton;