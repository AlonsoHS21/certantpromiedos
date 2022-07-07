import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [],
  imports: [CommonModule, MatInputModule, MatButtonModule, MatSidenavModule, MatIconModule],
  exports: [MatInputModule, MatButtonModule, MatSidenavModule, MatIconModule],
})
export class MaterialModule {}
