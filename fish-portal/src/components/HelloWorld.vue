<template>
  <div class="hello">

    <button @click="getPersonList">刷新列表</button>
    <table>
      <thead>
      <th>
        编号
      </th>
      <th>
        姓名
      </th>
      <th>
        操作
      </th>
      </thead>
      <tbody v-for="item in personList">
      <td>
        {{item.sysNo}}
      </td>
      <td>
        {{item.name}}
      </td>
      <td>
        <router-link :to="{path:'editPerson',query:{sysNo:item.sysNo}}">编辑</router-link>
        <button @click="deletePerson(item)">删除</button>
      </td>
      </tbody>
    </table>
    <h1>{{ msg }}</h1>
    <button @click="getFactorPayOut">查询</button>
    <h1>{{ responseData }}</h1>
    <h2>Essential Links</h2>
    <router-link to="home">Go to home</router-link>
    <router-link to="about">Go to about</router-link>
    <router-link to="test">Go to test</router-link>
    <router-link to="editPerson">新增人员</router-link>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        responseData: null,
        personList: null
      }
    },
    created:function () {
      this.getPersonList();
    },
    methods: {
      getFactorPayOut: function () {
        this.$axios.get("index3/3")
          .then((response) => {
            this.responseData = response.data;
            console.log(this.responseData);
          });
      },
      getPersonList: function () {
        this.$axios.get("person/list")
          .then((response) => {
            this.personList = response.data;
            console.log(this.personList);
          });
      },
      deletePerson:function (data) {
        this.$axios.post("person/delete/"+data.sysNo)
          .then((response) => {
            console.log(response);
            alert("删除成功");
            this.getPersonList();
          });
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
