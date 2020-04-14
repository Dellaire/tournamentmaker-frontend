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
    background-color: var(--a-violet);
    align: center;
    border-radius: 5px;
    padding: 10px;
    border: 0;
    color: var(--a-pink);
}
button:active {
    background-color: var(--a-blue);
}
</style>
