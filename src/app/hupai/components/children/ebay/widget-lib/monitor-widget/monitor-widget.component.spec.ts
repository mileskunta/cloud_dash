import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitorWidgetComponent } from './monitor-widget.component';

describe('MonitorWidgetComponent', () => {
  let component: MonitorWidgetComponent;
  let fixture: ComponentFixture<MonitorWidgetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonitorWidgetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonitorWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
