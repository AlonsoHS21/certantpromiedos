import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { RankingComponent } from './pages/ranking/ranking.component';
import { TopScorersComponent } from './pages/top-scorers/top-scorers.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'ranking', component: RankingComponent },
  { path: 'goleadores', component: TopScorersComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturesRoutingModule { }
