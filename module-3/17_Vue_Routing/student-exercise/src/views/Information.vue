<template>
  <div class="book-details">
    <book-details />
  </div>
</template>

<script>
import BookDetails from '@/components/BookDetails';

export default {
    name: 'information',
    components: {
        BookDetails
    },
    computed: {
    book() {
      return this.$store.state.find((book) => {
        book.id == this.$store.state.activeBook;
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

</style>