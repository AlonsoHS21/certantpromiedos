import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JackpotBetComponent } from './jackpot-bet.component';

describe('JackpotBetComponent', () => {
  let component: JackpotBetComponent;
  let fixture: ComponentFixture<JackpotBetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JackpotBetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JackpotBetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
