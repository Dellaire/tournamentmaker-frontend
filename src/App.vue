<template>
  <div id="app">
    <NavigationPanel v-bind:elements="navigationElements"/>
    <DataPanel v-bind:players="players"/>
  </div>
</template>

<script>
import NavigationPanel from './components/NavigationPanel.vue'
import DataPanel from './components/DataPanel.vue'

export default {
  name: 'App',
  components: {
    NavigationPanel,
    DataPanel
  },
  data() {
    return {
        navigationElements: [
            {
                label: "Players"
            },
            {
                label: "Tables"
            },
            {
                label: "Tournaments"
            }
        ],
        players: [
            {
                id: "1",
                name: "Henry",
                points: 3
            },
            {
                id: "2",
                name: "Huy",
                points: 1
            },
            {
                id: "3",
                name: "Nick",
                points: 2
            },
            {
                id: "4",
                name: "Mario",
                points: 4
            },
            {
                id: "5",
                name: "Lina",
                points: 5
            }
        ]
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
