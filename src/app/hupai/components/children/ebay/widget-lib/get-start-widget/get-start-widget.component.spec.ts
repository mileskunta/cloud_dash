import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetStartWidgetComponent } from './get-start-widget.component';

describe('GetStartWidgetComponent', () => {
  let component: GetStartWidgetComponent;
  let fixture: ComponentFixture<GetStartWidgetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetStartWidgetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetStartWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
