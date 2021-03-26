<template>
  <table id="tblUsers">
    <thead>
      <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
      </tr>
    </thead>

    <tbody>
      <tr>
        <td><input type="text" v-model="filter.firstName" id="firstNameFilter" /></td>
        <td><input type="text" v-model="filter.lastName" id="lastNameFilter" /></td>
        <td><input type="text" v-model="filter.username" id="usernameFilter" /></td>
        <td><input type="text" v-model="filter.emailAddress" id="emailFilter" /></td>
        <td>
          <select id="statusFilter" v-model="filter.status" >
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      
      <tr v-for="user in users" v-bind:key="user" v-bind:class="{ disabled: user.status === 'Disabled' }">
        <td v-bind:key="user.firstName">{{user.firstName}}</td>
        <td v-bind:key="user.lastName">{{user.lastName}}</td>
        <td v-bind:key="user.username">{{user.username}}</td>
        <td v-bind:key="user.emailAddress">{{user.emailAddress}}</td>
        <td v-bind:key="user.status">{{user.status}}</td>
      </tr>  
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'user-list',
  data() {
    return {
      users: [
        { firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Disabled' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Disabled' }
      ],
      filter: {
        firstName: '',
        lastName: '',
        username: '',
        emailAddress: '',
        status: ''
      }
    }
  },
  computed: {
    filteredList() {
      return this.users.filter((user) => {
        return user.firstName.toLowerCase().includes(this.filter.firstName.toLowerCase()) 
        && user.lastName.toLowerCase().includes(this.filter.lastName.toLowerCase())
        && user.username.toLowerCase().includes(this.filter.username.toLowerCase())
        && user.emailAddress.toLowerCase().includes(this.filter.emailAddress.toLowerCase())
        && user.status.includes(this.filter.status);
      });
    }
  }
}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input, select {
  font-size: 16px;
}
</style>
