import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }    from '@angular/common/http';

import { AppComponent } from './app.component';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerService } from './player.service';


@NgModule({
	declarations: [
		AppComponent,
		PlayerListComponent
	],
	imports: [
		BrowserModule,
		HttpClientModule
	],
	providers: [PlayerService],
	bootstrap: [AppComponent]
})
export class AppModule { }
