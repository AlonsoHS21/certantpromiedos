import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JackpotFormComponent } from './jackpot-form.component';

describe('JackpotFormComponent', () => {
  let component: JackpotFormComponent;
  let fixture: ComponentFixture<JackpotFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JackpotFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JackpotFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
