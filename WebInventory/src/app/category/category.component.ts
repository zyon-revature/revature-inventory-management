import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Data, Router } from '@angular/router';
import { Category } from '../category';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  title='Inventory Categories'
  data: any=[];//change this to category
  selectedData?: Data;
  
  categories: Category[]=[];//could use this in place of the websiteList
  category: Category={
    id: 0,
    title: '',
    manufacturer: '',
    minlimit: 0,
    category: ''
  }
  selectedCategory?: Category;
  //test//
  categoryList: any=['Electronics','Appliances','Home Decor'];

  form = new FormGroup({
    website: new FormControl('',[Validators.required])
  });

  get f(){
    return this.form.controls;
  }

  submit(){
    console.log(this.form.value);
  }
  //end test//

  public _url="http://localhost:8080/categories";//place url here to test
  //above url should be "http://localhost:8080/categories/{category}",where the value is set to {category} and those are returned
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
