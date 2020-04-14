<template>
  <div>
    <table id="carrier">
        <tr>
            <td id="matches-panel">
                <MatchesPanel v-bind:matches="matches"/>
            </td>
            <td id="players-panel">
                <PlayersPanel v-bind:players="players"/>
            </td>
        </tr>
    </table>
  </div>
</template>

<script>
import PlayersPanel from './PlayersPanel.vue'
import MatchesPanel from './MatchesPanel.vue'

export default {

  name: 'DataPanel',
  
  components: {
    PlayersPanel,
    MatchesPanel
  },
  
  props: {
    players: Array,
    matches: Array
  }
}
</script>

<style scoped>

div {
    background-color: #001a00;
}

table {
    width: 100%;
}

td {
    vertical-align: top;
}

#matches-panel {
    width: 80%;
}

#players-panel {
    width: 20%;
}

</style>
