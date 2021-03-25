<template>
  <div class="main">
      <h2>Product Reviews for {{ bookTitle }}</h2>

      <p class="description">{{ description }}</p>

      <div class="review"> 
          <h4>Reviewer</h4>
          <div class="rating">
              <img src="../assets/star.png" />
          </div>  
      </div>
  </div>
</template>

<script>
import ProductReview from './components/ProductReview'
export default {
    name: 'product-review',
    data() {
        return {
            bookTitle : 'Cigar Parties for Dummies',
            description : 'Hosting and planning a cigar party.',
            reviews : [
                {
                    reviewer : 'Malcolm Gladwell',
                    title: 'I have sold countless books at airports.',
                    rating: 3,
                    review: 'This book was mediocre.'
                },
                {
                    reviewer : 'Nicholas Weller',
                    title: 'I am an internet troll who likes to slam books.',
                    rating: 1,
                    review: 'This book was sucktastic.'
                }
            ]
        }
    }
}
</script>

<style scoped>
div.main {
    margin: 1rem 0;
}
</style>