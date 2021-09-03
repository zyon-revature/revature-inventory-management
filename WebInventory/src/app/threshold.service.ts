import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Threshold} from "./threshold";

@Injectable({
  providedIn: 'root'
})
export class ThresholdService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  private baseUrl = "http://localhost:8080/productstocks/threshold";

  constructor(private http: HttpClient) { }

  getThresholds():Observable<Threshold[]>{
    return this.http.get<Threshold[]>(`${this.baseUrl}`);
  }
}
