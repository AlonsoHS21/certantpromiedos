import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MaterialModule } from './material/material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { 
	IgxCarouselModule,
	IgxSliderModule
 } from "igniteui-angular";
import { FeaturesModule } from './features/features.module';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './features/components/login-form/login-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FeaturesModule,
    MaterialModule,
    ReactiveFormsModule,
    IgxCarouselModule,
    IgxSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
