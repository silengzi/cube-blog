<template>
  <div>
    <div class="main" v-show="scene==0">
      <blogManageTopNav></blogManageTopNav>
      <div style="margin-bottom: 20px">
        <el-button type="primary">添 加</el-button>
        <el-button type="danger">批量删除</el-button>
      </div>
      <el-table border :data="imageList">
        <el-table-column
          type="selection"
          align="center"
          width="70"
        ></el-table-column>
        <el-table-column
          type="index"
          label="序号"
          width="90"
          align="center"
        ></el-table-column>
        <el-table-column
          label="图片名称"
          prop="name"
          align="center"
        ></el-table-column>
        <el-table-column
          label="默认图片"
          align="center"
          width="110"
        >
          <template slot-scope="{row, $index}">
              <img :src="row.defaultImg" alt="" style="width: 70px; height: 70px; object-fit: cover;">
          </template>
        </el-table-column>
        <el-table-column
          label="操作"
          align="center"
        >
          <template slot-scope="{row}">
              <el-button
                  type="warning"
                  icon="el-icon-edit"
                  size="mini"
                  title="编辑图片"
                  @click="imageEdit(row)"
              ></el-button>
              <el-button
                  type="primary"
                  icon="el-icon-info"
                  size="mini"
                  title="图片详情"
                  @click="getImageInfo(row)"
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
          :current-page="page"
          :total="total"
          :page-size="limit"
          :page-sizes="[3, 10, 20]"
          layout="prev, pager, next, jumper, ->, sizes, total"
          style="padding: 20px 0"
      ></el-pagination>
    </div>
    <imageEdit v-show="scene==1" @changeScene="changeScene"></imageEdit>
    <!-- 抽屉模式 -->
    <el-drawer :visible.sync="show" size="50%">
      <el-row>
        <el-col :span="5">名称</el-col>
        <el-col  :span="16">{{imageDetailRow.name}}</el-col>
      </el-row>
      <el-row >
        <el-col :span="5">描述</el-col>
        <el-col  :span="16">{{imageDetailRow.desc}}</el-col>
      </el-row>
      <el-row >
        <el-col :span="5">图片</el-col>
        <el-col  :span="16">
          <!-- <el-carousel height="210px"> -->
            <img :src="imageDetailRow.url" alt="" style="width: 100%; height: 200px; object-fit: cover;">
          <!-- </el-carousel> -->
        </el-col>
      </el-row>
    </el-drawer>
  </div>
</template>

<script>
import blogManageTopNav from '@/components/blogManageTopNav/index.vue'
import imageEdit from './imageEdit'
export default {
  name: '',
  components: {
    blogManageTopNav,
    imageEdit,
  },
  data() {
    return {
        imageList: [],
        page: 1,
        total: 0,
        limit: 3,
        dialogUserVisible: false,
        scene: 0,
        show: false,
        imageDetailRow: {
          
        }
    };
  },
  mounted() {
    this.imageList = [
        {
            name: '头像',
            desc: '这是头像图片',
            defaultImg: require('@/assets/imgs/head.jpg')
        },
        {
            name: '登录',
            desc: '这是登录页背景图',
            defaultImg: require('@/assets/imgs/login.jpg')
        },
    ]
  },
  methods: {
    imageEdit(row) {
      this.scene = 1
    },
    getImageInfo(row) {
      this.imageDetailRow.name = row.name
      this.imageDetailRow.desc = row.desc
      this.imageDetailRow.url = row.defaultImg
      this.show = true
    },
    changeScene({scene}) {
      this.scene = scene
    }
  }
};
</script>

<style scoped lang="less">
  .el-row .el-col-5 {
    font-size: 18px;
    text-align: right;
  }
  .el-col {
    margin: 10px;
  }
</style>
