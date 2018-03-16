import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { from } from 'rxjs/observable/from';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Table } from './table';

@Injectable()
export class TablesService {

  constructor(private http: HttpClient) { }
  
	getTables(): Observable<Table[]> {
	
		return this.http.get<Table[]>('http://localhost:8085/table');
	}
	
	postTable(table: Table): Observable<Table> {
		
		return this.http.post<Table>('http://localhost:8085/table', table);
	}
	
	putTable(table: Table): Observable<Table> {
		
		return this.http.put<Table>('http://localhost:8085/table', table);
	}
}
