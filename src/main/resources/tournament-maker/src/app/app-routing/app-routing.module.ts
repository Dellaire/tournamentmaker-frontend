import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from '../player-list/player-list.component';
import { TablesComponent } from '../tables/tables.component';

const routes: Routes = [
	{ path: 'player', component: PlayerListComponent },
	{ path: 'tables', component: TablesComponent }
];

@NgModule({
	imports: [ RouterModule.forRoot(routes) ],
	exports: [ RouterModule ]
})
export class AppRoutingModule { }
