import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';
import { Product } from '../product';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  products: Product[] = [];
  product: Product = {
    id: 0,
    title: "",
    category: "",
    manufacturer: "",
    minlimit: 0
  }

  constructor(private router:Router, private productService: ProductService,
              private http:HttpClient) { }

              public _url = "http://localhost:8080/newproduct"

  ngOnInit(): void {
  }
  
  onSubmit(form:NgForm){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    console.log(form.value.title)
    console.log(form.value.category)
    console.log(form.value.manufacturer)
    console.log(form.value.minlimit)
      this.http.post(this._url, 
        JSON.stringify({
          title: form.value.title, 
          category: form.value.category,
          manufacturer: form.value.manufacturer,
          minlimit: form.value.minlimit
          }),httpOptions
          )
            .subscribe({
              next: (data:any)=>{
              if(data.status === 'success'){
                this.router.navigate(['newproduct'])
        }
      }})
}

}
