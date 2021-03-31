<template>
  <div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <router-link :to="{ name: 'products'} ">Back to Products</a>&nbsp;|
      <router-link :to="{ name: 'add-review', params: {id: product.id} }">Add Review</a>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary';
import StarSummary from '@/components/StarSummary';
import AddReview from '@/components/AddReview.vue';
import ReviewList from '@/components/ReviewList.vue';

export default {
  name: 'product-detail',
  components: {
    AverageSummary,
    StarSummary,
    AddReview,
    ReviewList
  },
  methods: {
    addReviewPage(product) {
      return {
        name: 'add-review',
        params: {
          id: product.id
        }
      }
    }
  },
  computed: {
    product(){
      const theProduct = this.$store.state.products.find((product) => {
        return product.id == this.$store.state.activeProduct;
      });
      return theProduct;
    }
  },
  created() {
    const activeProductID = this.$route.params.id;
    this.$store.commit("SET_ACTIVE_PRODUCT", activeProductID);

  }
}
</script>

<style>

</style>