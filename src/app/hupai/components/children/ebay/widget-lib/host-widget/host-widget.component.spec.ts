import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HostWidgetComponent } from './host-widget.component';

describe('HostWidgetComponent', () => {
  let component: HostWidgetComponent;
  let fixture: ComponentFixture<HostWidgetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HostWidgetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HostWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
