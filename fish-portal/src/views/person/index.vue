<template>
  <section>
    <el-row>
      <el-col :space="24" style="text-align: left">
        <el-form :inline="true" :model="filters">
          <el-form-item label="姓名:">
            <el-input v-model="filters.name" placeholder="姓名">
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" v-on:click="queryPerson">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addPerson">新增</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-table v-loading="tbLoading" :data="personList" highlight-current-row style="width: 100%">
        <el-table-column prop="sysNo" label="编号" width="60">
        </el-table-column>
        <el-table-column prop="name" label="姓名" sortable>
        </el-table-column>
        <el-table-column prop="genderStr" label="性别">
        </el-table-column>
        <el-table-column prop="age" label="年龄">
        </el-table-column>
        <el-table-column prop="birthdayStr" label="生日">
        </el-table-column>
        <el-table-column prop="address" label="地址">
        </el-table-column>
        <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <el-button size="small" @click="editPerson(scope.$index, scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="delPerson(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-col :span="24" class="toolbar">
        <el-pagination layout="prev, pager, next" @current-change="queryPerson" :page-size="filters.pageSize"
                       :total="totalRecord"
                       style="float:right;">
        </el-pagination>
      </el-col>
    </el-row>
    <!--编辑界面-->
    <el-dialog title="编辑" :visible.sync="formVisible" :close-on-click-modal="false">
      <el-form :model="currentPerson" label-width="80px" :rules="personRules" ref="currentPerson">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="currentPerson.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="currentPerson.gender">
            <el-radio class="radio" :label="1">男</el-radio>
            <el-radio class="radio" :label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input-number v-model="currentPerson.age" :min="0" :max="200"></el-input-number>
        </el-form-item>
        <el-form-item label="生日">
          <el-date-picker type="date" placeholder="选择日期" v-model="currentPerson.birthday"></el-date-picker>
        </el-form-item>
        <el-form-item label="地址">
          <el-input type="textarea" v-model="currentPerson.address"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="formVisible = false">取消</el-button>
        <el-button type="primary" @click.native="savePerson">提交</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
  export default {
    name: "person",
    data: function () {
      return {
        filters: {
          name: null,
          pageNo: 1,
          pageSize: 5
        },
        personList: [],
        tbLoading: false,
        totalRecord: 0,
        currentPerson: {},
        formVisible: false,
        personRules: {
          name: [
            {required: true, message: '请输入姓名', trigger: 'blur'}
          ]
        }
      }
    },
    created: function () {
      this.queryPerson()
    },
    methods:
      {
        queryPerson: function (pageNo) {
          if (pageNo > 0) {
            this.filters.pageNo = pageNo;
          }
          var vueSelf = this;
          this.tbLoading = true;


          this.$axios.post("person/query", JSON.parse(JSON.stringify(this.filters)))
            .then((response) => {
              if (response.data) {
                var result = response.data;
                vueSelf.personList = result.list;
                vueSelf.totalRecord = result.totalRecord;
              }
              this.tbLoading = false;
            });

        },
        addPerson: function () {
          this.formVisible = true;
        },
        editPerson: function (index, row) {
          this.formVisible = true;
          this.currentPerson = Object.assign({}, row);
        },
        savePerson: function () {
          var personObj = JSON.parse(JSON.stringify(this.currentPerson));
          var self = this
          this.$refs.currentPerson.validate((valid) => {
            if (!valid) {
              return;
            }
            if (personObj.sysNo) {
              this.$axios.post("person/update", personObj).then(function (response) {
                self.$message({
                  message: '修改人员信息成功！',
                  type: 'success'
                });
                self.formVisible = false;
                self.queryPerson();
              });
            }
            else {
              this.$axios.post("person/add", personObj).then(function (response) {
                self.$message({
                  message: '新增人员信息成功！',
                  type: 'success'
                });
                self.formVisible = false;
                self.queryPerson();
              });
            }
          });
        },
        delPerson: function (index, data) {
          var self = this;
          this.$axios.post("person/delete/" + data.sysNo)
            .then((response) => {
              self.$message({
                message: '删除人员信息成功！',
                type: 'success'
              });
              self.queryPerson();
            });
        }
      }
  }
</script>

<style scoped>

</style>
