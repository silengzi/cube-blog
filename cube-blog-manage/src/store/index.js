import Vue from 'vue'
import Vuex from 'vuex'
import {reqAllArticle, reqAllUser, reqDeleteArticle} from '@/api/index'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    allArticle: [],
    allUser: [],
  },
  mutations: {
    GETALLARTICLE(state, article) {
      state.allArticle = article
      // console.log(state.allArticle)
    },
    GETALLUSER(state, user) {
      state.allUser = user
      // console.log(state.allUser)
    },
  },
  actions: {
    // 文章管理列表获取全部文章
    async getAllArticle({commit, state}, route) {
      let data = {
        userName: route.query.userName
      }
      let result = await reqAllArticle(data)
      let res = result.data
      // console.log(result)
      if(res.status == 1) {
        commit("GETALLARTICLE", res.data)
      }
    },
    // 文章管理列表删除
    // async deleteArticle({commit, state}) {
    //   let result = await reqDeleteArticle()
    //   let res = result.data
    //   // console.log(result)
    //   if(res.status == 1) {
    //     commit("GETALLARTICLE", res.data)
    //   }
    // },
    // 个人介绍列表获取所有用户
    async getAllUser({commit, state}) {
      let result = await reqAllUser()
      // console.log(result)
      if(result.status == 200) {
        commit("GETALLUSER", result.data)
      }
    },
  },
  getters: {
  },
  modules: {
  }
})
