import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Data, Router } from '@angular/router';
import { Category } from '../category';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  title='Inventory Categories'
  data: any=[];//change this to category
  selectedData?: Data;
  
  categories: Category[]=[];
  category: Category={
    id: 0,
    title: '',
    manufacturer: '',
    minlimit: 0,
    category: ''
  }
  selectedCategory?: Category;
  

  public _url="http://localhost:8080/categories";//place url here to test
  constructor(
    private router: Router,
    private http: HttpClient
  ) { }

  fetchCategories(){
    this.http.get(this._url)
    .subscribe(data=>{
      console.log(data);//get rid of later
      this.data=data;
    },error=>console.error(error));
  }

  /*fetchCategory(){
    this.http.get(this._url)
    .subscribe(category=>{
      console.log(category);
      this.categories=category;
    },error=>console.error(error));
  }*/
  //updated fetch method to reflect imported interface
  

  ngOnInit(): void {
    this.fetchCategories();
    //this.fetchCategory();
  }

  onSelect(category: Category): void{
    this.selectedData=category;
  }

}
