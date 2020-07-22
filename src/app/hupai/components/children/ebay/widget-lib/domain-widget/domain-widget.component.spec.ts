import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DomainWidgetComponent } from './domain-widget.component';

describe('DomainWidgetComponent', () => {
  let component: DomainWidgetComponent;
  let fixture: ComponentFixture<DomainWidgetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DomainWidgetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DomainWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
