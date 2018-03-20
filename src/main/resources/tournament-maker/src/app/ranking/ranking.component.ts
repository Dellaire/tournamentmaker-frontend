import { Component, OnInit } from '@angular/core';
import { PlayerStatistic } from '../playerStatistic';
import { RankingService } from '../ranking.service';

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {

	playerStatistics: PlayerStatistic[] = [];
	
	columnsToDisplay = ['playerName', 'wins', 'defeats', 'draws', 'goals', 'counterGoals', 'score'];

	constructor(private rankingService: RankingService) { }

	ngOnInit() {
		
	}

	getPlayerStatistics(): void {
		
		this.rankingService.getPlayerStatistics('').subscribe(playerStatistics => this.playerStatistics = playerStatistics);
	}
}
