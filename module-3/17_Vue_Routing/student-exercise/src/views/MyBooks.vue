<template>
  <div class="reading-list">
    <reading-list />
    <router-link :to="{ name: 'add-book' }" >Add Book</router-link>
  </div>  
</template>

<script>
import ReadingList from "@/components/ReadingList";

export default {
  components: {
    ReadingList
  }
}
</script>

<style>

</style>