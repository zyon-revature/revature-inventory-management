import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-stock',
  templateUrl: './update-stock.component.html',
  styleUrls: ['./update-stock.component.css']
})
export class UpdateStockComponent implements OnInit {

  public url='http://localhost:8080/productstocks/update';

  invoices:any = [];

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch();
  }

  updateStock(){
    this.router.navigate(['updatestock']);
  }

  fetch(){
    const httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json'})}

    this.http.get(this.url, httpOptions).subscribe(data=>{
      this.invoices= data;
      console.log(data)
    })


  }

}
