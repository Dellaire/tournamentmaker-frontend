import { Component, OnInit } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

	player: Player[] = [];
	
	columnsToDisplay = ['name', 'elo', 'score', 'active'];

	constructor(private playerService: PlayerService) { }

	ngOnInit() {
		
		this.getPlayer();
	}

	getPlayer(): void {
		
		this.playerService.getPlayer().subscribe(player => this.player = player);
	}
	
	postPlayer(playerName: string): void {
		
		var player: Player = {id: null, name: playerName, elo: 0, score: 0, active: true};
		this.playerService.postPlayer(player).subscribe(postedPlayer => this.getPlayer());
	}
	
	putPlayer(player: Player, active: boolean): void {
		
		player.active = active;
		this.playerService.putPlayer(player).toPromise();
	}
}