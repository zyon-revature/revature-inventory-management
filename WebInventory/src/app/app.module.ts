import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewProductComponent } from './new-product/new-product.component';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { CheckThresholdComponent } from './check-threshold/check-threshold.component';
import { UpdateStockComponent } from './update-stock/update-stock.component';
import { NewStockComponent } from './new-stock/new-stock.component';

const routes: Routes = [
  {path: '', component:NewProductComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NewProductComponent,
    HomePageComponent,
    CheckThresholdComponent,
    UpdateStockComponent,
    NewStockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
