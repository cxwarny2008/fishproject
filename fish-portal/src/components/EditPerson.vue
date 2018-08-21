<template>
  <div>
    <div>
      <span>姓名：</span>
      <input type="text" v-model="person.name"/>
    </div>
    <div>
      <button @click="editPerson">保存</button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "edit_person",
    data() {
      return {
        person: {}
      }
    },
    created: function () {
      var sysNo = this.$route.query.sysNo;
      if (sysNo) {
        this.loadPerson(sysNo);
      }
    },
    methods: {
      editPerson: function (event) {
        var personObj = JSON.parse(JSON.stringify(this.$data.person));
        if (personObj.sysNo) {
          this.$axios.post("person/update", personObj).then(function (response) {
            console.log(response);
            alert("更新成功")
          });
        }
        else {
          this.$axios.post("person/add", personObj).then(function (response) {
            console.log(response);
            alert("新增成功")
          });
        }
      },
      loadPerson: function (sysNo) {
        var vueSelf = this;
        this.$axios.post("person/load/" + sysNo).then(function (response) {
          console.log(response);
          vueSelf.person = response.data;
        });
      }
    }
  }
</script>

<style scoped>

</style>
