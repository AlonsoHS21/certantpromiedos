import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RankingComponent } from './features/pages/ranking/ranking.component';
import { TopScorersComponent } from './features/pages/top-scorers/top-scorers.component';

const routes: Routes = [
    { path: 'ranking', component: RankingComponent },
    { path: 'goleadores', component: TopScorersComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
