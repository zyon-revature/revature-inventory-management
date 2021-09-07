import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NewProductComponent } from './new-product/new-product.component';
import {CheckThresholdComponent} from "./check-threshold/check-threshold.component";
import { NewStockComponent } from './new-stock/new-stock.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePageComponent},
  {path: 'newproduct', component: NewProductComponent},
  {path: 'threshold', component: CheckThresholdComponent},
  {path: 'newstock', component: NewStockComponent},
  {path: 'updatestock', component: NewStockComponent},
  {path: 'category', component: CategoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
