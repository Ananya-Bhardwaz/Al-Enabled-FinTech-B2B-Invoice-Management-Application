import React, { Component } from "react";
import { Button, ButtonGroup, Grid, TextField } from "@material-ui/core";
import RefreshIcon from "@mui/icons-material/Refresh";
import "./ToolBar.css";

export default class ToolBar extends Component {
  render() {
    return (
      <div className="ToolBar">
        <Grid container spacing={10}>
          <Grid item xs={5}>
            <ButtonGroup
              className="buttontext"
              color="primary"
              variant="outlined"
              aria-label="outlined button group"
            >
              <Button
                variant="contained"
                style={{
                  backgroundColor: "blue",
                  minWidth : "150px",
                  
                }}
              >
                PREDICT
              </Button>
              <Button style={{minWidth : "150px", color : "white"}}>ANALYTICS VIEW</Button>
              <Button style={{minWidth : "150px" , color : "white"}}>ADVANCE SEARCH</Button>
            </ButtonGroup>
            <Button onClick={() => window.location.reload(false)}>
              <RefreshIcon style= {{ color : "white"}}></RefreshIcon>
            </Button>
          </Grid>

          <Grid item xs={2}>
            <TextField
              className="inputRounded"
              fullWidth
              id="fullWidth"
              hiddenLabel
              placeholder="Search Customer Id"
              inputProps={{
                style: { backgroundColor: "white", borderRadius: 5 },
              }}
              variant="filled"
              size="small"
            />
          </Grid>

          <Grid item xs={2}>
            <ButtonGroup
              fullwidth
              className="buttontext"
              color="primary"
              variant="outlined"
              aria-label="outlined button group"
            >
              <Button variant="outlined" style={{minWidth : "150px" ,color : "white"}}>ADD</Button>
              <Button variant="outlined"  style={{minWidth : "150px",color : "white"}}>EDIT</Button>
              <Button variant="outlined"  style={{minWidth : "150px",color : "white"}}>DELETE</Button>
            </ButtonGroup>
          </Grid>
        </Grid>
      </div>
    );
  }
}
