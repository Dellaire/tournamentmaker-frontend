<template>
  <div>
    <table id="carrier">
        <tr>
            <td id="matches-panel">
                <SectionPanel label="MATCHES">TEST</SectionPanel>
            </td>
            <td id="players-panel">
                <PlayersPanel v-bind:players="players"/>
            </td>
        </tr>
    </table>
  </div>
</template>

<script>
import SectionPanel from './SectionPanel.vue'
import PlayersPanel from './PlayersPanel.vue'

export default {

  name: 'DataPanel',
  
  components: {
    SectionPanel,
    PlayersPanel
  },
  
  props: {
    players: Array,
    matches: Array
  }
}
</script>

<style scoped>

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
