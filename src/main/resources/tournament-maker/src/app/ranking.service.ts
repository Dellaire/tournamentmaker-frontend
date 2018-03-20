import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { from } from 'rxjs/observable/from';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { PlayerStatistic } from './playerStatistic';

@Injectable()
export class RankingService {

	constructor(private http: HttpClient) { }
  
	getPlayerStatistics(tournamentId: string): Observable<PlayerStatistic[]> {
		
		return this.http.get<PlayerStatistic[]>('http://localhost:8085/ranking/' + tournamentId);
	}
}