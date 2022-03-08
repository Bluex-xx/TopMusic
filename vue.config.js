const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  //代理解决跨域问题
  devServer: {
  proxy: {
    '/api': {
      target: 'http://172.20.10.10:8086', // 请求api的ip地址
      changeOrigin: true,
      pathRewrite: {
        '^/api': ''
      }
    }

  }
},
})
