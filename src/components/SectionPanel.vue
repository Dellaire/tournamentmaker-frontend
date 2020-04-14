<template>
  <div id="root">
    <div id="header"><font><b>{{label}}</b></font></div>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'SectionPanel',
  props: {
    label: String
  }
}
</script>

<style scoped>
font {
    color: var(--a-violet);
}

#root {
    height: 100%;
    align: center;
    border: 5px solid;
    padding-bottom: 20px;
    margin: 10px;
    border-radius: 25px;
    color: var(--a-pink);
    background-color: var(--a-violet);
}

#header {
    padding-top: 5px;
    margin-bottom: 20px;
    padding-bottom: 10px;
    border-radius: 15px 15px 0px 0px;
    background-color: var(--a-pink);
}
</style>
