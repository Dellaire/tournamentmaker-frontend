import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from '../player-list/player-list.component';
import { TablesComponent } from '../tables/tables.component';
import { RankingComponent } from '../ranking/ranking.component';

const routes: Routes = [
	{ path: 'player', component: PlayerListComponent },
	{ path: 'tables', component: TablesComponent },
	{ path: 'ranking', component: RankingComponent }
];

@NgModule({
	imports: [ RouterModule.forRoot(routes) ],
	exports: [ RouterModule ]
})
export class AppRoutingModule { }
