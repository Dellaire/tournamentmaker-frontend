<template>
  <div>
    <strong>{{ label }}</strong>
  </div>
</template>

<script>
export default {
  name: 'NavigationButton',
  props: {
    label: String
  }
}
</script>

<style scoped>
div {
    background-color: #99ff99;
    align: center;
    border-radius: 25px;
    padding: 20px;
}
</style>
