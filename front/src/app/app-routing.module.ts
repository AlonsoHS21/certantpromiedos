import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './features/components/login-form/login-form.component';
import { HomeComponent } from './features/pages/home/home.component';
import { RankingComponent } from './features/pages/ranking/ranking.component';
import { TopScorersComponent } from './features/pages/top-scorers/top-scorers.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
