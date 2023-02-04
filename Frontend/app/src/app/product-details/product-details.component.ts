import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  pname = "One Plus 9r";
  pcity = "Patna,Bihar";
  pdatepost = "";
  pcoin = 20000;
  description =
    " Operating System: OxygenOS based on Android 11 CPU: Qualcomm® Snapdragon™ 870.. GPU: Adreno 650. RAM: 8GB/12GB";
  pcategory = "";
  image:string="";
  pid = 2;
  public productdata: any;


  constructor(
    private _productdetailsService: ProductService,
    private domSanitizer: DomSanitizer,
    private productService: ProductService,
    private _route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.pid = this._route.snapshot.params['id'];

    this.productService.getProductById(this.pid).subscribe((data) => {
      this.productdata = data;
       console.log(data);
      
      this.pname = this.productdata.pname
      this.pcategory = this.productdata.pcategory
      this.pcity = this.productdata.pcity
      this.pdatepost = this.productdata.pdatepost
      this.pcoin = this.productdata.pcoin
      this.description = this.productdata.description
      this.image=this.productdata.image

      
      

    })
  }


}
