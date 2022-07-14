import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeaturesRoutingModule } from './features-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material/material.module';
import { IgxCarouselModule, IgxSliderModule } from 'igniteui-angular';
import { HttpClientModule } from '@angular/common/http';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

import { CarouselComponent } from './components/carousel/carousel.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { TeamCardComponent } from './components/team-card/team-card.component';
import { MatchCardComponent } from './components/match-card/match-card.component';
import { RankingComponent } from './pages/ranking/ranking.component';
import { TopScorersComponent } from './pages/top-scorers/top-scorers.component';
import { HomeComponent } from './pages/home/home.component';
import { FeaturesComponent } from './features.component';
import { MatchBettingComponent } from './pages/match-betting/match-betting.component';
import { BetListComponent } from './components/bet-list/bet-list.component';
import { BetListPageComponent } from './pages/bet-list-page/bet-list-page.component';
import { JackpotFormComponent } from './components/jackpot-form/jackpot-form.component';
import { MyAccountComponent } from './pages/my-account/my-account.component';
import { JackpotComponent } from './pages/jackpot/jackpot.component';
import { JackpotBetComponent } from './components/jackpot-bet/jackpot-bet.component';

@NgModule({
  declarations: [
    CarouselComponent,
    NavBarComponent,
    TeamCardComponent,
    MatchCardComponent,
    RankingComponent,
    TopScorersComponent,
    HomeComponent,
    FeaturesComponent,
    MatchBettingComponent,
    BetListComponent,
    BetListPageComponent,
    JackpotFormComponent,
    MyAccountComponent,
    JackpotComponent,
    JackpotBetComponent,
  ],
  imports: [
    CommonModule,
    FeaturesRoutingModule,
    MaterialModule,
    IgxCarouselModule,
    IgxSliderModule,
    ReactiveFormsModule,
    HttpClientModule,
    SweetAlert2Module
  ],
})
export class FeaturesModule {}
