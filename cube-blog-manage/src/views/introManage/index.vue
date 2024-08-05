<template>
  <div>
    <blogManageTopNav></blogManageTopNav>
    <div style="margin-bottom: 20px">
      <el-button type="primary">添 加</el-button>
      <el-button type="danger">批量删除</el-button>
    </div>
    <el-table border :data="$store.state.allUser">
      <el-table-column
        type="selection"
        align="center"
      ></el-table-column>
      <el-table-column
        type="index"
        label="序号"
        width="90"
        align="center"
      ></el-table-column>
      <el-table-column
        label="用户名称"
        prop="name"
        align="center"
      ></el-table-column>
      <el-table-column
        label="用户年龄"
        prop="age"
        align="center"
      ></el-table-column>
      <el-table-column
        label="权限列表"
        align="center"
        prop="permission"
      ></el-table-column>
      <el-table-column
        label="操作"
        align="center"
      >
        <template slot-scope="{row}">
          <el-button
            type="info"
            icon="el-icon-user-solid"
            size="mini"
            title="分配角色"
            @click="showAssignRole(row)"
          ></el-button>
          <el-button
            type="warning"
            icon="el-icon-edit"
            size="mini"
            title="编辑用户"
            @click="showUpdateUser(row)"
          ></el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            title="删除"
          ></el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      style="padding: 20px 0"
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[3, 10, 20]"
      layout="prev, pager, next, jumper, ->, sizes, total"
    ></el-pagination>
    <el-dialog title="设置角色" :visible.sync="dialogRoleVisible">
      <el-form label-width="80px">
        <el-form-item label="用户名">
          <el-input disabled></el-input>
        </el-form-item>
        <el-form-item label="角色列表">
          <el-checkbox>全选</el-checkbox>
          <el-checkbox-group v-model="checkList">
            <el-checkbox label="复选框 A"></el-checkbox>
            <el-checkbox label="复选框 B"></el-checkbox>
            <el-checkbox label="复选框 C"></el-checkbox>
            <el-checkbox label="禁用" disabled></el-checkbox>
            <el-checkbox label="选中且禁用" disabled></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="primary">保 存</el-button>
        <el-button @click="resetRoleList">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog title="编辑用户" :visible.sync="dialogUserVisible">
      <el-form label-width="120px">
        <el-form-item label="用户名">
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="用户密码">
          <el-input></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import blogManageTopNav from '@/components/blogManageTopNav/index.vue'
export default {
  name: '',
  components: {
    blogManageTopNav,
  },
  data() {
    return {
      // introList: [],
      page: 1,
      total: 0,
      limit: 3,
      dialogUserVisible: false,
      dialogRoleVisible: false,
      checkList: ['复选框 A']
    };
  },
  mounted() {
    // this.introList = [
    //   {
    //     name: '四棱子',
    //     permission: '没有权限'
    //   },
    //   {
    //     name: 'layL',
    //     permission: '全部开放'
    //   },
    // ],
    this.getUserData()
  },
  methods: {
    showAssignRole(row) {
      this.dialogRoleVisible = true
    },
    showUpdateUser(row) {
      this.dialogUserVisible = true
    },
    resetRoleList() {
      this.dialogRoleVisible = false
    },
    cancel() {
      this.dialogUserVisible = false
    },
    getUserData() {
      this.$store.dispatch("getAllUser")
    }
  }
};
</script>

<style scoped lang="">
</style>
