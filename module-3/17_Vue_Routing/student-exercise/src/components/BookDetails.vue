<template>
  <div class="book-details">
    <div v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.isbn">
      <h1>{{ book.title }}</h1>
      <h1>{{ book.author }}</h1>
      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <h3>{{book.read ? "I have read this book!": "I have not read this book yet."}}</h3>
    </div>  
  </div>
</template>

<script>
export default {
  name: 'book-details',
};  
</script>

<style>

</style>