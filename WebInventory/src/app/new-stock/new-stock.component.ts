import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-stock',
  templateUrl: './new-stock.component.html',
  styleUrls: ['./new-stock.component.css']
})
export class NewStockComponent implements OnInit {

  stocks: Stocks[] = [];
  stock: Stock = {
    id: 0,
    title: "",
    category: "",
    manufacturer: "",
    minlimit: 0
  }

  constructor() { }

  ngOnInit(): void {
  }

}
