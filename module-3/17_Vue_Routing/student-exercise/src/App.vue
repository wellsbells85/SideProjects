<template>
  <div id="app">
    <nav>
      <router-link :to="{ name: 'home' }" >Home</router-link> 
      {{'home'.includes($route.name)? ' | ' : '' }}
      <router-link :to="{ name: 'my-books' }" v-if="!'my-books'.includes($route.name)" >My Books</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
