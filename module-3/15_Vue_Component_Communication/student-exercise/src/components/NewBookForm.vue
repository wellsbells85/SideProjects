<template>
  <form class="new-book-form" v-on:submit.prevent="addNewBook">
    <label for="title" >Title</label>
    <input class="title-input" type="text" id="title" v-model="newBook.title" placeholder="Please Enter the Book Title" required size="40"/><br>
    <label for="author" >Author</label>
    <input class="author-input" type="text" id="author" v-model="newBook.author" placeholder="Please Enter the Author" required size="40"/><br>
    <label for="isbn" >ISBN</label>
    <input class="isbn-input" type="text" id="isbn" v-model="newBook.isbn" placeholder="Please Enter 13-Digit ISBN" required minlength="13" maxlength="13" size="40"/><br>
    <input id="submit" type="submit" value="Save" />
    <input id="cancel" type="button" value="Cancel" v-on:click.prevent="resetForm" />
  </form>
</template>

<script>
export default {
  name: 'new-book-form',
  data() {
    return {
      newBook: {
        read: true
      }
    };
  },
  methods: {
    addNewBook() {
      this.$store.commit("ADD_BOOK", this.newBook);
      this.resetForm();
    },
    resetForm() {
      this.newBook = {};
    }
  }  
};
</script>

<style>

label {
  display: inline-block;
  font-weight: bolder;
  width: 50px;
  padding-right: 5px;
  text-align: right;
}
#submit, #cancel {
  display: inline-block;
  height: 35px;
  width: 80px;
  font-weight: bolder;
  font-size: larger;
}

</style>