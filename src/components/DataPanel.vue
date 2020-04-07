<template>
  <div>
    <table>
        <tr>
            <td v-bind:key="element.label" v-for="element in firstRow">
                <SectionPanel :content="element.label"/>
            </td>
        </tr>
        <tr>
            <td v-bind:key="element.label" v-for="element in secondRow">
                <SectionPanel :content="element.label"/>
            </td>
        </tr>
    </table>
  </div>
</template>

<script>
import SectionPanel from './SectionPanel.vue'

export default {
  name: 'DataPanel',
  components: {
    SectionPanel
  },
  props: ["elements"],
  computed: {
    firstRow: function() {
        return this.elements.slice(0, 2)
    },
    secondRow: function() {
        return this.elements.slice(2, 4)
    }
  }
}
</script>

<style scoped>
table {
    width: 100%;
}
</style>
