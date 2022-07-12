import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table'
import { MatSnackBarModule } from '@angular/material/snack-bar';

@NgModule({
  declarations: [],
  imports: [CommonModule, MatInputModule, MatButtonModule, MatSidenavModule, MatIconModule, MatTableModule, MatSnackBarModule],
  exports: [MatInputModule, MatButtonModule, MatSidenavModule, MatIconModule, MatTableModule, MatSnackBarModule],
})
export class MaterialModule {}
