<template>
  <div>
    <table style="padding:10px">
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
div {
    background-color: var(--a-pink);
    width: 100%;
}
</style>
