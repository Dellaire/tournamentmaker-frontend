import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule} from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';

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
		HttpClientModule,
		BrowserAnimationsModule,
		MatTableModule,
		MatCheckboxModule,
		MatInputModule,
		MatButtonModule,
		MatFormFieldModule
	],
	providers: [PlayerService],
	bootstrap: [AppComponent]
})
export class AppModule { }
