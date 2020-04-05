<template>
  <div>
    <table>
        <tr>
            <td v-bind:key="element.label" v-for="element in elements">
                <NavigationButton :label="element.label" />
            </td>
        </tr>
    </table>
  </div>
</template>

<script>
import NavigationButton from './NavigationButton.vue'

export default {
  name: "NavigationPanel",
  components: {
    NavigationButton
  },
  props: ["elements"]
}
</script>

<style scoped>
table {
    background-color: #2c3e50;
    border-radius: 10px;
    border: 3px solid;
    margin-bottom: 10px;
    width: 100%;
}
</style>
