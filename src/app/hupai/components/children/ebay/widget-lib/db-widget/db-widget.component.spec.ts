import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DbWidgetComponent } from './db-widget.component';

describe('DbWidgetComponent', () => {
  let component: DbWidgetComponent;
  let fixture: ComponentFixture<DbWidgetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbWidgetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DbWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
