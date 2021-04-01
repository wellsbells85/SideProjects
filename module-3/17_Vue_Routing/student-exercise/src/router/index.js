import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home';
import MyBooks from '@/views/MyBooks';
import NewBook from '@/views/NewBook';
import BookDetails from '@/views/BookDetails';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'add-book',
    component: NewBook
  },
  {
    path: '/book/:isbn',
    name: 'book-details',
    component: BookDetails
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
