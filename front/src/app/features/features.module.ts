import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeaturesRoutingModule } from './features-routing.module';
import { MaterialModule } from '../material/material/material.module';
import { 
	IgxCarouselModule,
	IgxSliderModule
 } from "igniteui-angular";

import { CarouselComponent } from './components/carousel/carousel.component'
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { TeamCardComponent } from './components/team-card/team-card.component';
import { MatchCardComponent } from './components/match-card/match-card.component';
import { RankingComponent } from './pages/ranking/ranking.component';
import { TopScorersComponent } from './pages/top-scorers/top-scorers.component';
import { HomeComponent } from './pages/home/home.component';
import { FeaturesComponent } from './features.component';


@NgModule({
  declarations: [
    CarouselComponent,
    NavBarComponent,
    TeamCardComponent,
    MatchCardComponent,
    RankingComponent,
    TopScorersComponent,
    HomeComponent,
    FeaturesComponent
  ],
  imports: [
    CommonModule,
    FeaturesRoutingModule,
    MaterialModule,
    IgxCarouselModule,
    IgxSliderModule
  ]
})
export class FeaturesModule { }
