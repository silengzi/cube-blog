<template>
  <div>
    <div class="title">
      <el-input
        type="text"
        placeholder="请输入标题"
        v-model="article.title"
      ></el-input>
    </div>
    <div class="summary">
      <!-- <label for="summary" width="20px">摘要:</label> -->
      <el-input
        type="text"
        placeholder="请输入文章摘要"
        v-model="article.summary"
        width="100px"
      ></el-input>
    </div>
    <!-- <div class="img">
      <el-upload
        action="/dev-api/admin/product/fileUpload"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
      >
        <i class="el-icon-plus"></i>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img
          width="100%"
          :src="article.img"
          alt=""
        >
      </el-dialog>
    </div> -->
    <div class="content">
      <v-md-editor
        v-model="article.content"
        label="请输入文章内容"
      ></v-md-editor>
    </div>
    <div class="button">
        <el-button
        type="primary"
        @click="createArticle"
        >保存</el-button>
        <el-button @click="cancel">取消</el-button>
    </div>
  </div>
</template>

<script>
import { reqCreateArticle } from '@/api/index'

export default {
  name: '',
  data() {
    return {
      article: {
        title: '',
        summary: '',
        content: '',
        img: '',
        userName: this.$route.query.userName
      },
    };
  },
  mounted() {
    // this.article.content = this.text
    // console.log(this.text)
  },
  methods: {
    async createArticle() {
      // let rawData = {
      //     "title": "创建标题",
      //     "summary": "创建大纲",
      //     "content": "## 新增文章详情 ```js test ```",
      //     "img": "https://img2.baidu.com/it/u=2308390603,343143142&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=644"
      // }
      let result = await reqCreateArticle(this.article)
      let res = result.data
      if (res.status == 1) {
        // console.log(res.data)
        this.$message.success(res.message)
        // this.text = `${this.article.content}`
        // console.log(this.text)
        // res.data = this.text
      }
      this.$emit('cancelScene', 0)
    },
    cancel() {
      this.$emit('cancelScene', 0)
    }
  }
};
</script>

<style scoped lang="less">
.title {
  ::v-deep .el-input__inner {
    height: 60px !important;
    font-size: 25px;
  }
}
.summary {
  margin: 10px 0;
}
.button {
    margin-top: 20px;
}
</style>
