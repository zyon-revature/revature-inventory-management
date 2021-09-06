import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Data, Router } from '@angular/router';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  data: any=[];
  selectedData?: Data;
  
  selected(){
    console.log(this.selectedData)
  }
 
  public _url="http://localhost:8080/categories";

  constructor(
    private router: Router,
    private http: HttpClient
  ) { }


  fetchCategories(){
    this.http.get(this._url)
    .subscribe(data=>{
      this.data=data;
    },error=>console.error(error));
  }

  ngOnInit() {
    this.fetchCategories();
  }

  onSelect(data: Data): void{
    this.selectedData=data;
  }

}
