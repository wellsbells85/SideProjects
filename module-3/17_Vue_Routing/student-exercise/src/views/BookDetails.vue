<template>
  <div class="details">
    <h1>{{ book.title }}</h1>
    <h1>{{ book.author }}</h1>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3>{{book.read ? "I have read this book!": "I have not read this book yet."}}</h3>
  </div>
</template>

<script>
export default {
  name: 'book-details',
  computed: {
    book() {
      const book = this.$store.state.books.find(
        b => b.isbn == this.$store.state.activeBook
      );
      return book;
    }
  },
  created() {
    const activeBookISBN = this.$route.params.isbn;
    this.$store.commit("SET_ACTIVE_PRODUCT", activeBookISBN);
  }
};  
</script>