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

export default {
  name: 'MatchesPanel',
  components: {
    SectionPanel
  },
  props: {
    matches: Array
  }
}
</script>

<style scoped>

table {
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
