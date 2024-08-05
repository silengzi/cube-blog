<template>
  <div>
    <el-button
      type="info"
      size="mini"
      @click="goBack"
    >返回</el-button>
    <el-card class="articleDetail">
      <v-md-editor
        :value="text"
        mode="preview"
      ></v-md-editor>
    </el-card>
  </div>
</template>

<script>
import { reqArticleById } from '@/api/index'
export default {
  name: '',
  data() {
    return {
      text: ''
    };
  },
  methods: {
    goBack() {
      this.$emit("changeScenes", 0)
    },
    async getArticleById(userName, id) {
        let data = {
            id: id,
            userName: userName,
        }
        console.log(data)
      let result = await reqArticleById(data)
      let res = result.data
    //   console.log(res)
      if (res.status == 1) {
        // this.$message.success(res.message)
        let title = res.data.title
        let content = res.data.content
        this.text = `# ${title}\n${content}`
      }
    }
  },
  mounted() {
//     this.text = `## 我不好 - 张艺兴 (LAY)
// #### 词：李荣浩
// #### 曲：LAY(张艺兴)
// #### 编曲：郑伟/LAY(张艺兴)
// 第五排 第六号
// 我的飞机票
// 要飞去哪里我不知道
// 闻着衣服上你的味道
// 昨天是你生日
// 有我的生日
// 说好了晚餐后去看一场电影
// 像别人那样手牵手
// 我陪你哭 也逗你笑 我好不好
// 我总是这样问你
// 这样骗你 开你玩笑
// 你走着走着原地不动了
// 戴着口罩哭着对我说
// 你说你好累 也许我们并不适合
// 我不好 我不好
// 我不好 是我不好
// 不配你的美
// Oh baby
// 原来我 早已经 失去你 可是我
// 都还不知道
// 求求你怪我好不好
// 这样我就可以入睡
// 至少让我知道你已经有了人陪
// 我陪你哭 也逗你笑 我好不好
// 我总是这样问你
// 这样骗你 开你玩笑
// 你走着走着原地不动了
// 戴着口罩哭着对我说
// 你说你好累 也许我们并不适合
// 我不好 我不好
// 我不好 是我不好
// 不配你的美
// Oh baby
// 原来我 早已经 失去你 可是我
// 都还不知道
// 求求你怪我好不好
// 这样我就可以入睡
// 至少让我知道你已经有了人陪
// 我不好 我不好 我不好
// 不配你的美
// 原来我 早已经 失去你 可是我
// 都还不知道
// 求求你怪我好不好
// 这样我就可以入睡
// 至少让我知道你已经有了人陪
// 至少让我知道你已经有人陪
// **Executive Producer：ZHANG YIXING STUDIO**
// **Producer：LAY(张艺兴)**
// **Vocal Directed by：Andrew Choi**
// **Background Vocals by：LAY(张艺兴)**
// *Recorded by：Eugene Kwon/Sung-Su Min @ doobdoob Studio*
// *Digital Editing by：Woo-Young Jang @ doobdoob Studio*
// *Mixed by：Han-Goo Kim @ SoundPOOL Studios*
// *Mastered by：Kwon Nam Woo @ ８２１ Sound Mastering*
// `
  },
};
</script>

<style scoped lang="less">
.el-button {
  margin-bottom: 30px;
}
.articleDetail {
  width: 1000px;
  margin: 0 auto;
  // border: 1px solid #eee;
  // text-align: center;
  overflow: hidden;
}
</style>
