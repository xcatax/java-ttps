import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GastosPorGruposComponent } from './gastos-por-grupos.component';

describe('GastosPorGruposComponent', () => {
  let component: GastosPorGruposComponent;
  let fixture: ComponentFixture<GastosPorGruposComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GastosPorGruposComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GastosPorGruposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
