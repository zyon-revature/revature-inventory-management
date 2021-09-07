import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-new-stock',
  templateUrl: './new-stock.component.html',
  styleUrls: ['./new-stock.component.css']
})
export class NewStockComponent implements OnInit {

  public url = 'http://localhost:8080/productstocks/create';

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(stockForm:NgForm){

    const httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})}

    this.http.post(this.url, JSON.stringify({
      productid:stockForm.value.productid, 
      vendor:stockForm.value.vendor, 
      batchcode:stockForm.value.batchcode, 
      invoicenumber:stockForm.value.invoicenumber, 
      quantity:stockForm.value.quantity, 
      transactiontype:stockForm.value.transactiontype
    }), httpOptions
    ).subscribe({
      next: (data) => {
        console.log(data)
      }
    })

    this.router.navigate([""])
}


}
