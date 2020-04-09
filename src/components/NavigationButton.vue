<template>
  <div>
    <button type="button"><strong>{{ label }}</strong></button>
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
button {
    background-color: #99ff99;
    align: center;
    border-radius: 5px;
    padding: 10px;
    border: 0;
    color: #2c3e50;
}
button:active {
    background-color: #e6ffe6;
}
</style>
