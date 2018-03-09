import { Injectable } from '@angular/core';
import { Player } from './player';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { from } from 'rxjs/observable/from';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class PlayerService {

	//player: Player[] = [];

	constructor(private http: HttpClient) { }
  
	updatePlayer(): void {
		
		this.http.get<Player[]>('http://localhost:8085/player').subscribe(player => this.player = player);
	}
  
	getPlayer(): Observable<Player[]> {
	
		//var player1: Player = {id: '1', name: 'Henry', elo: 0, score: 0, active: true};
		//var player2: Player = {id: '2', name: 'Hung', elo: 0, score: 0, active: false};		
		
		//return of([player1, player2]);
		
		//this.player.splice(0, this.player.length);
		//this.http.get<Player[]>('http://localhost:8085/player').subscribe(player => player.forEach(onePlayer => this.player.push(onePlayer)));
		
		return this.http.get<Player[]>('http://localhost:8085/player');
	}
	
	postPlayer(player: Player): void {
		
		console.log(player);
		this.http.post('http://localhost:8085/player', player).toPromise();
	}
	
	putPlayer(player: Player): void {
		
		this.http.put('http://localhost:8085/player', player).toPromise();
	}
}