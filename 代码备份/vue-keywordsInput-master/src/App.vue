<template>
  <div id="appp">
    <img src="./assets/logo.png">
    <h1>{{ msg }}545445</h1>
    <h2>Essential Links</h2>
    <ul>
      <li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>
      <li><a href="https://chat.vuejs.org" target="_blank">Community Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li>
      <li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li>
      <li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li>
    </ul>
  <div v-for="(data,index) in dataList" :key="index">
    <keywordsinput :_key="index" v-model="dataList[index]" @change="setKeywords" :maxLen="18"></keywordsinput>
  </div>

    <keywordsinput  @change="setKeywords" v-model="dataList2"></keywordsinput>
  </div>
</template>

<script>
export default {
  name: 'appp',
  data () {
    return {
      dataList:[['111','222','333'],['111a','222b','333c']],
      dataList2:[],
      dataList3:"aaa,bbb,ccc",
      maxLen:18,
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    setKeywords(v){
      console.log(v)
    },
    initFormat() {
      if (!Array.isArray(this.dataList3)) {
        this.dataList2 = !!this.dataList3? this.dataList3.split(',') : [];
        console.log(this.dataList3,'11')
        console.log(this.dataList3.split(','),'22')
        console.log(this.dataList2,'33')
      }
    }
  },
  mounted(){
    this.initFormat()
  }
}
</script>
<style scoped>
.qh-tag > span[data-v-17a42e00]{
  width: 100px;
}
</style>

<style lang="less">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}

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
