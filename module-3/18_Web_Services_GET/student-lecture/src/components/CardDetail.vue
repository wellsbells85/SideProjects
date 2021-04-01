<template>
<div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>

    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <comments-list v-bind:comments="card.comments" v-else />

    <div class="board-actions" v-if="!isLoading">
      <router-link
        v-bind:to="{ name: 'Board', params: { id: $route.params.boardID } }"
        >Back to Board</router-link
      >
    </div>
  </div>
</template>

<script>
import boardService from '../services/BoardService.js';
import CommentsList from '../components/CommentsList';

export default {
  name: "card-detail",
  components: {
    CommentsList
  },
  data() {
    return {
      card: {
        title : ''
      },
      isLoading: true
    }
  },
  methods: {
    retrieveCard() {
      const boardID = this.$route.params.boardID;
      const cardID = this.$route.params.cardID;
      boardService.getCard(boardID, cardID).then(response => {
        this.card = response;
        this.isLoading = false;
      });
    }
  },
  created() {
    this.retrieveCard();
  }

};
</script>
