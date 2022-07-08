import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MaterialModule } from './material/material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { 
	IgxCarouselModule,
	IgxSliderModule
 } from "igniteui-angular";

import { AppComponent } from './app.component';
import { LoginFormComponent } from './features/components/login-form/login-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarouselComponent } from './features/components/carousel/carousel.component';
import { NavBarComponent } from './features/components/nav-bar/nav-bar.component';
import { TeamCardComponent } from './features/components/team-card/team-card.component';
import { MatchCardComponent } from './features/components/match-card/match-card.component';
import { RankingComponent } from './features/pages/ranking/ranking.component';
import { TopScorersComponent } from './features/pages/top-scorers/top-scorers.component';
import { HomeComponent } from './features/pages/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    CarouselComponent,
    NavBarComponent,
    TeamCardComponent,
    MatchCardComponent,
    RankingComponent,
    TopScorersComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
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
