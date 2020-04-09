<template>
  <div>
    <SectionPanel label="PLAYERS">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Points</th>
            </tr>
            <tr v-bind:key="player.id" v-for="player in players">
                <td>
                    {{player.id}}
                </td>
                <td>
                    {{player.name}}
                </td>
                <td>
                    {{player.points}}
                </td>
            </tr>
        </table>
    </SectionPanel>
  </div>
</template>

<script>
import SectionPanel from './SectionPanel.vue'

export default {
  name: 'PlayersPanel',
  components: {
    SectionPanel
  },
  props: {
    players: Array
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
