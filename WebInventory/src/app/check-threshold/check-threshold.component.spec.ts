import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckThresholdComponent } from './check-threshold.component';

describe('CheckThresholdComponent', () => {
  let component: CheckThresholdComponent;
  let fixture: ComponentFixture<CheckThresholdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckThresholdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckThresholdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
