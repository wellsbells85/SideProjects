<template>
  <div class="book-container">
    <router-link :to="{ name: 'information', params: {book: book} }" >
      <book-card v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.isbn" /> 
    </router-link>
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';

export default {
  name: 'reading-list',
  components: {
      BookCard
  },
  computed: {
    book() {
      return this.$store.state.books.find((book) => {
        book.isbn == this.$store.state.activeBook;
      });
    }
  },
  created() {
    const activeBookId = this.$route.params.id;
    this.$store.commit("SET_ACTIVE_BOOK", activeBookId);
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