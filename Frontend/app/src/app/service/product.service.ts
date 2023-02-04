import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = "http://localhost:8080"

  constructor(private httpClient: HttpClient) { }

  public addProduct1(productObject: any) {
    return this.httpClient.post<Product>(this.baseUrl + "/add", productObject);
  }
  
  public getProductById(pid:any){
    return this.httpClient.get<Product>(this.baseUrl + "/get/by/pid/"+ pid)
  }

  public getAllProduct(){
    return this.httpClient.get<Product[]>(this.baseUrl + "/all")
  }
}
