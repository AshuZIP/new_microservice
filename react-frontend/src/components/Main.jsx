import React from 'react'
import { Button, TextField } from '@mui/material'
import axios from 'axios'

const Main = () => {
    const empUrl = "http://localhost:9191/api/employee/"
    const depUrl = "http://localhost:9191/api/departments/"
    const orgUrl = "http://localhost:9191/api/organization/"

    const [idText, setIdText] = React.useState("")
    const [idClick, setIdClick] = React.useState("");

    const handleClick = async (event) => {
        console.log(event)
        const idd = event.target.id
        console.log(idd)
        if(idd=="EGA"){
            console.log("hit")
            const res = await axios.get(empUrl+"getAll")
            console.log(res.data)

        }
        else if(idd=="EGI"){
            console.log("hit", idText)
            const res = await axios.get(empUrl+"get/"+idText)
            console.log(res.data)

        }
        else if(idd=="DGA"){
            const res = await axios.get(depUrl+"/getAll")
            console.log(res.data)
        }
        else if(idd=="DGI"){
            const res = await axios.get(depUrl+"/get/"+idText)
            console.log(res.data)
        }
        else if(idd=="DGC"){
            const res = await axios.get(depUrl+"/get/ByCode/"+idText)
            console.log(res)
        }
        else if(idd=="OGA"){
            const res = await axios.get(orgUrl+"/get")
            console.log(res)
        }
        else if(idd=="OGI"){
            const res = await axios.get(orgUrl+"/get/"+idText)
            console.log(res)
        }
        else if(idd=="OGC"){
            const res = await axios.get(orgUrl+"/get/byCode/"+idText)
            console.log(res)
        }
        setIdText("")
        setIdClick("")
    }
    const handleText = (event) => {
        const text = event.target.value
        setIdText(text);
     }
     const handleTextClick = (event) => {
        const idd = event.target.id
        setIdClick(idd)
     }
  return (
    <div>
        <div style={{display:"flex", justifyContent:"space-between", alignContent:"center", alignItems:"center"}}>
            <h3>Emp Service</h3>
            <Button onClick={handleClick} id='EGA' variant='contained' size="small">Get All</Button>
            <TextField onClick={handleTextClick} value={idClick=="EGIB"?idText:""} id='EGIB' size='small' style={{width:"50px"}} onChange={handleText}></TextField>
            <Button onClick={handleClick} id='EGI' variant='contained' size="small">Get By Id</Button>
            <TextField disabled size='small' style={{width:"120px"}}></TextField>
            <Button variant='contained' size="small">Get By Code</Button>
        </div>
        <div style={{display:"flex", justifyContent:"space-between", alignContent:"center", alignItems:"center"}}>
            <h3>Dep Service</h3>
            <Button onClick={handleClick} id='DGA' variant='contained' size="small">Get All</Button>
            <TextField onClick={handleTextClick} value={idClick=="DGIB"?idText:""} id='DGIB' size='small' style={{width:"50px"}} onChange={handleText}></TextField>
            <Button onClick={handleClick} id='DGI' variant='contained' size="small">Get By Id</Button>
            <TextField onClick={handleTextClick} value={idClick=="DGCB"?idText:""} id='DGCB' size='small' style={{width:"120px"}} onChange={handleText}></TextField>
            <Button onClick={handleClick} id='DGC'variant='contained' size="small">Get By Code</Button>
        </div>
        <div style={{display:"flex", justifyContent:"space-between", alignContent:"center", alignItems:"center"}}>
            <h3>Org Service</h3>
            <Button onClick={handleClick} variant='contained' id='OGA' size="small">Get All</Button>
            <TextField onClick={handleTextClick} value={idClick=="OGIB"?idText:""} id='OGIB'  size='small' style={{width:"50px"}} onChange={handleText}></TextField>
            <Button onClick={handleClick} variant='contained' id='OGI' size="small">Get By Id</Button>
            <TextField onClick={handleTextClick} value={idClick=="OGCB"?idText:""} id='OGCB'  size='small' style={{width:"120px"}} onChange={handleText}></TextField>
            <Button onClick={handleClick} variant='contained' id='OGC' size="small">Get By Code</Button>
        </div>
    </div>
  )
}

export default Main