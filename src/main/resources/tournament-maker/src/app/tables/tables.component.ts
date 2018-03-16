import { Component, OnInit } from '@angular/core';
import { Table } from '../table';
import { TablesService } from '../tables.service';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {

  tables: Table[] = [];
	
	columnsToDisplay = ['name', 'active'];

	constructor(private tablesService: TablesService) { }

	ngOnInit() {
		
		this.getTables();
	}

	getTables(): void {
		
		this.tablesService.getTables().subscribe(tables => this.tables = tables);
	}
	
	postTable(tableName: string): void {
		
		var table: Table = {id: null, name: tableName, active: true};
		this.tablesService.postTable(table).subscribe(postedTable => this.getTables());
	}
	
	putTable(table: Table, active: boolean): void {
		
		table.active = active;
		this.tablesService.putTable(table).toPromise();
	}
}
