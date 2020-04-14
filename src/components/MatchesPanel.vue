<template>
  <div>
    <SectionPanel label="MATCHES">
        <table>
            <tr>
                <th>ID</th>
                <th>Team 1</th>
                <th></th>
                <th>Team 2</th>
            </tr>
            <tr v-bind:key="match.id" v-for="match in matches">
                <td>
                    {{match.id}}
                </td>
                <td>
                    {{match.team1.player1.name}}<br/>
                    {{match.team1.player2.name}}
                </td>
                <td>
                    {{match.team1Score}} : {{match.team2Score}}
                </td>
                <td>
                    {{match.team2.player1.name}}<br/>
                    {{match.team2.player2.name}}
                </td>
            </tr>
        </table>
    </SectionPanel>
  </div>
</template>

<script>
import SectionPanel from './SectionPanel.vue'
import axios from 'axios'

export default {

  name: 'MatchesPanel',
  
  components: {
    SectionPanel
  },
  
  data() {
    return {
        tournament: {
            data: [ {
                rounds: [ {
                    matches: [ {
                    }]
                }]
            }]
        }
    }
  },
  
  computed: {
    matches: function() {
    
        var matches = Array();
        this.tournament.data[0].rounds.forEach(round => {
            matches.push(round.matches);
        })
    
        return matches.flat();
    }
  },
  
  mounted () {
    axios
      .get('http://localhost:8081/tournaments')
      .then(response => (this.tournament = response))
      .catch(function (error) {
            console.log(error);
      } )
  }
}
</script>

<style scoped>

table {
    color: var(--a-green);
    width: 100%;
    height: 100%;
    border-collapse: collapse;
}

th {
    padding-bottom: 15px;
}

td {
    border-top: 2px solid;
    padding: 10px;
}

</style>
