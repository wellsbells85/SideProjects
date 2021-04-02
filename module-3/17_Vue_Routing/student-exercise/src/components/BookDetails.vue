<template>
  <div>
    <h1>{{ book.title }}</h1>
    <h2>{{ book.author }}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3>{{book.read ? "I have read this book!" : "I have not read this book yet."}}</h3>
  </div>
</template>

<script>
export default {
  props: ['book']
};  
</script>