import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Data, Router } from '@angular/router';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  title='Inventory Categories'
  data:any=[];//might change this to category or something to reflect that
  selectedData?: Data;

  public _url="http://localhost:8080/categories";//place url here to test
  constructor(
    private router: Router,
    private http: HttpClient
  ) { }

  fetchCategories(){
    this.http.get(this._url)
    .subscribe(data=>{
      console.log(data);
      this.data=data;
    },error=>console.error(error));
  }

  ngOnInit(): void {
    this.fetchCategories();
  }

  onSelect(data: Data): void{
    this.selectedData=data;
  }

}
