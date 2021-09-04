import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Threshold} from '../threshold';
import { Location } from '@angular/common';
import {Observable} from "rxjs";
import {ThresholdService} from "../threshold.service";

@Component({
  selector: 'app-check-threshold',
  templateUrl: './check-threshold.component.html',
  styleUrls: ['./check-threshold.component.css']
})
export class CheckThresholdComponent implements OnInit {
  thresholds: Threshold[] =[];

  constructor(private thresholdService: ThresholdService, private location: Location) {}

  getThreshold(): void{
    // let resp = this.http.get("http://localhost:8080/productstocks/threshold");
    // resp.subscribe({ next: (data:any) => {
    //     this.thresholds = data;
    //   }
    // });
    this.thresholdService.getThresholds()
      .subscribe(thresholds => {
        this.thresholds = thresholds;

      })
  }

  ngOnInit(): void{
    this.getThreshold();
  }
  goBack(): void{
    this.location.back();
   }

}
