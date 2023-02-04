import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  abc: any;
  public getproduct: any[] = [];

  constructor(
    private httpClient: HttpClient,
    private productService: ProductService,
    private router: Router,
    
  ) { }

  ngOnInit(): void {
    this.productService.getAllProduct().subscribe((data:any)=>{
      console.log(data)
      this.getproduct=data;
    })
  }

  goToProduct(pid:any){
    this.router.navigate(["detail/" + pid]);
  }

}
