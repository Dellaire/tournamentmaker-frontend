<template>
  <div id="app">
    <NavigationPanel v-bind:elements="elements"/>
    <SectionPanel content="STUFF"/>
  </div>
</template>

<script>
import NavigationPanel from './components/NavigationPanel.vue'
import SectionPanel from './components/SectionPanel.vue'

export default {
  name: 'App',
  components: {
    NavigationPanel,
    SectionPanel
  },
  data() {
    return {
        elements: [
            {
                label: "Players"
            },
            {
                label: "Tables"
            },
            {
                label: "Tournaments"
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
