const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  // devServer: {
  //   proxy: {
  //     '/api': {
  //       target: 'http://123.57.246.82:8888',
  //     }
  //   }
  // }
  devServer: {
    proxy: {
      '/api': {
        target: 'http://101.42.46.104:8888',
        changeOrigin: true,   // 开启代理，在本地创建一个虚拟服务 
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  },
})
