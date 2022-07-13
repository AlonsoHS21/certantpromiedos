import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginGuard } from '../guards/login.guard';
import { JackpotFormComponent } from './components/jackpot-form/jackpot-form.component';
import { FeaturesComponent } from './features.component';
import { BetListPageComponent } from './pages/bet-list-page/bet-list-page.component';
import { HomeComponent } from './pages/home/home.component';
import { MatchBettingComponent } from './pages/match-betting/match-betting.component';
import { RankingComponent } from './pages/ranking/ranking.component';
import { TopScorersComponent } from './pages/top-scorers/top-scorers.component';

const routes: Routes = [
  {
    path: '',
    component: FeaturesComponent,
    canActivate: [LoginGuard],
    children: [
      { path: '', component: HomeComponent },
      { path: 'ranking', component: RankingComponent },
      { path: 'goleadores', component: TopScorersComponent },
      { path: 'apuestas', component: BetListPageComponent },
      { path: 'apostarpartido/:id', component: MatchBettingComponent },
      { path: 'jackpot', component: JackpotFormComponent },
      { path: '**', component: HomeComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FeaturesRoutingModule {}