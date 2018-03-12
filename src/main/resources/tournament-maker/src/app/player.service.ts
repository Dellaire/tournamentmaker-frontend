import { Injectable } from '@angular/core';
import { Player } from './player';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { from } from 'rxjs/observable/from';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class PlayerService {

	constructor(private http: HttpClient) { }
  
	getPlayer(): Observable<Player[]> {
	
		//var player1: Player = {id: '1', name: 'Henry', elo: 0, score: 0, active: true};
		//var player2: Player = {id: '2', name: 'Hung', elo: 0, score: 0, active: false};		
		
		//return of([player1, player2]);
		
		return this.http.get<Player[]>('http://localhost:8085/player');
	}
	
	postPlayer(player: Player): Observable<Player> {
		
		return this.http.post<Player>('http://localhost:8085/player', player);
	}
	
	putPlayer(player: Player): Observable<Player> {
		
		return this.http.put<Player>('http://localhost:8085/player', player);
	}
}