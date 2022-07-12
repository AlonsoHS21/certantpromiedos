import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class AlertsService {
  constructor(private _snackBar: MatSnackBar) {}
  
  confirmAlert(message:string) {
    this._snackBar.open(message, undefined, {
      duration: 3500,
      panelClass: ['snackbar-confirm']
    });
  }

  warnAlert(message:string) {
    this._snackBar.open(message, undefined, {
      duration: 3500,
      panelClass: ['snackbar-warn']
    });
  }

  errorAlert(message:string) {
    this._snackBar.open(message, undefined, {
      duration: 3500,
      panelClass: ['snackbar-error']
    });
  }
}
