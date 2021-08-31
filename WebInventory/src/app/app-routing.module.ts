import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewProductComponent } from './new-product/new-product.component';

const routes: Routes = [
  {path: 'newproduct', component: NewProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
