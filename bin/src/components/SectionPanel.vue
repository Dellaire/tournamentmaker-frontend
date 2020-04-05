<template>
  <div>
    {{ content }}
  </div>
</template>

<script>
export default {
  name: 'SectionPanel',
  props: {
    content: String
  }
}
</script>

<style scoped>
div {
    align: center;
    border-radius: 25px;
    border: 5px solid;
    padding: 20px;
}
</style>
