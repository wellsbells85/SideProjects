<template>
  <div class="book-container">
    <book-card v-for="book in bookList" v-bind:key="book.isbn" v-bind:book="book" />
  </div>
</template>

<script>
import BookCard from "./BookCard";

export default {
  name: 'reading-list',
  components: {
    BookCard
  },
  computed: {
    bookList() {
      const books = this.$store.state.books;
      return books;
    }
  }
};
</script>

<style>
.book-container {
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>