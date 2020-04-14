<template>
  <div>
    <SectionPanel label="PLAYERS">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Score</th>
            </tr>
            <tr v-bind:key="player.id" v-for="player in tournament.data[0].player">
                <td>
                    {{player.id}}
                </td>
                <td>
                    {{player.name}}
                </td>
                <td>
                    {{player.score}}
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

  name: 'PlayersPanel',
  components: {
    SectionPanel
  },
  
  data() {
    return {
        tournament: null
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
    width: 100%;
    height: 100%;
    border-collapse: collapse;
    color: var(--a-green);
}

th {
    padding-bottom: 15px;
}

td {
    border-top: 2px solid;
    padding: 10px;
}

</style>
