import React, { useState, useEffect } from "react";
import './Datagrid.css'
import axios from "axios";
import { DataGrid } from "@material-ui/data-grid";

const column = [
  { field: "sl_no", headerName: "sl no" , width:110 },
  { field: "businessCode", headerName: "business code" , width:170  },
  { field: "custNumber", headerName: "cust number" , width:180  },
  { field: "clear_date", headerName: "clear date" , width:150  },
  { field: "buisness_year", headerName: "buisness year" , width:150  },
  { field: "doc_id", headerName: "doc id" , width:150  },
  { field: "posting_date", headerName: "posting date" , width:150  },
  { field: "document_create_date", headerName: "document create date" , width:150  },
  { field: "document_create_date1", headerName: "document create date1" , width:150 },
  { field: "due_in_date", headerName: "due in date" , width:150 },
  { field: "invoice_currency", headerName: "invoice currency" , width:150  },
  { field: "document_type", headerName: "document type" , width:150  },
  { field: "posting_id", headerName: "posting id" , width:150  },
  { field: "area_business", headerName: "area_business" , width:150  },
  { field: "total_open_amount", headerName: "total open amount" , width:200  },
  { field: "baseline_create_date", headerName: "baseline create date" , width:150  },
  { field: "cust_payment_terms", headerName: "cust payment terms" , width:150  },
  { field: "invoice_id", headerName: "invoice id" , width:150  }
];

export const Datagrid = () => {
  const [tableData, setTableData] = useState([]);

  useEffect(() => {
    var apiurl = "http://localhost:8080/highradwebapp/ViewInvoice";
    axios
      .get(apiurl)
      .then((response) => response.data)
      .then((data) => {
        console.log(data);
        setTableData(data);
      });
  }, []);
  

  return (
    <div style={{ height: 400, width: "100%"}}>
      <DataGrid
        getRowId ={(row) => row.sl_no}
        rows={tableData}
        columns={column}
        pageSize={5}
        rowsPerPageOptions={[5,10]}
       
        checkboxSelection
      />
    </div>
  );
};
