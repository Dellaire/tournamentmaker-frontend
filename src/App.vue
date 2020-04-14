<template>
  <div id="app">
    <NavigationPanel v-bind:elements="navigationElements"/>
    <DataPanel v-bind:players="players" v-bind:matches="matches"/>
    <p style="background-color:var(--a-red)">a</p>
    <p style="background-color:var(--a-violet)">a</p>
    <p style="background-color:var(--a-pink)">a</p>
    <p style="background-color:var(--a-blue)">a</p>
    <p style="background-color:var(--a-green)">a</p>
    <p style="background-color:var(--a-yellow)">a</p>
    <p style="background-color:var(--a-orange)">a</p>
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
        ],
        matches: [
            {
                id: "1",
                team1:
                {
                    player1:
                    {
                        name: "Henry"
                    },
                    player2:
                    {
                        name: "Huy"
                    }
                },
                team2:
                {
                    player1:
                    {
                        name: "Nick"
                    },
                    player2:
                    {
                        name: "Lina"
                    }
                },
                team1Score: 6,
                team2Score: 2
            },
            {
                id: "2",
                team1:
                {
                    player1:
                    {
                        name: "Nick"
                    },
                    player2:
                    {
                        name: "Huy"
                    }
                },
                team2:
                {
                    player1:
                    {
                        name: "Mario"
                    },
                    player2:
                    {
                        name: "Lina"
                    }
                },
                team1Score: 5,
                team2Score: 5
            }
        ]
    }
  }
}
</script>

<style>

* {
    --a-red: red;
    --a-violet: #660066;
    --a-pink: fuchsia;
    --a-blue: aqua;
    --a-green: lime;
    --a-yellow: yellow;
    --a-orange: orange;
    
    --border: red;
    
    --old-border: #2c3e50;
    --old-background: ;
    --old-buttons: #99ff99;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

</style>
