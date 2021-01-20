<template>
  <div :class="'div_keywords'" style="border: 1px solid #dcdfe6;border-radius: 5px;padding: 3px;">
    <div>
      <qhtag v-for="(item, index) in value"
             size="small"
             :key="item[_key]"
             :text="item.label"
             @click="close()"
             type @close="inputBox(item)">
      </qhtag>
    </div>
    <div>
      <input type="text" class="input-new-tag"
             autocomplete="off"
             :placeholder="placeholder"
             v-model.trim="addTagInput"
             @focus="focusInput()"
             :style="{width:width}"
             :maxlength="maxLen"/>
    </div>
    <div class="cw-input-select_pop" v-show="false">
      <ul class="cw-input-select_options">
        <li>
          <span>请选择...</span>
        </li>
        <li v-for="option in dataList" v-on:click="selected(option)"
            :style="getStyle(option)">
          <span v-html="option.label"></span>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>

import qhtag from '../qh-tag'
import {checkIsIn} from '@/api/commonUtils'
export default {
  name: 'keywordsinput',
  data() {
    return {
      addTagInput:'',
      dataList: []
    }
  },
  props: ["value",
    "maxLen",
    "placeholder",
    "_key",
    "width",
    "dtlList"
  ], //' maxLen最大输入字符数，keyWords代表数据必传'

  computed: {
    list() {
      console.log("computed发生作用");
    },
  },
  mounted() {
    window.addEventListener("click", function (e){
        //整个div
        var inputDivs = document.getElementsByClassName('div_keywords');
        for(var thisdiv of inputDivs){
          if(thisdiv.contains(e.target)){
            thisdiv.getElementsByClassName('cw-input-select_pop')[0].style.display = 'flex';
          }else{
            thisdiv.getElementsByClassName('cw-input-select_pop')[0].style.display = 'none';
          }
        }
    });
  },
  created() {
    this.dataList = JSON.parse(JSON.stringify(this.dtlList));
  },
  methods: {
    //模糊匹配公方法
    focusInput(){
      var inputDivs = document.getElementsByClassName('div_keywords');
      for(var thisdiv of inputDivs){
        if(this._uid === thisdiv.__vue__._uid){
          thisdiv.getElementsByClassName('cw-input-select_pop')[0].style.display = 'flex';
        }else{
          thisdiv.getElementsByClassName('cw-input-select_pop')[0].style.display = 'none';
        }
      }
    },

    getStyle(option) {
      if (checkIsIn(option, this.value, this._key) !== -1) {
        return {backgroundColor: '#D2EAFC'};
      } else {
        return {};
      }
    },
    checkOption(option) {
      return true;
    },
    selected(option) {
      // console.log("哈哈哈哈", pinyinMatch.match(option.label,"万花"));
      let index = checkIsIn(option, this.value, this._key);
      if (index === -1) {
        this.value.push(option);
      } else {
        this.value.splice(index, 1);
      }
    },
    inputBox(en) {
      this.value.forEach((e, i) => {
        if (e[this._key] === en[this._key]) {
          this.value.splice(i, 1);
        }
      });
    }
  },
  watch: {
    addTagInput: function () {
      this.$emit('inputSearch', this.addTagInput);
      this.focusInput();
    },
    dtlList: function () {
      this.dataList = JSON.parse(JSON.stringify(this.dtlList));
      if (this.addTagInput !== "") {
        for (var item of this.dataList) {
          let titleString = item.label;
          if (this.addTagInput && this.addTagInput.length > 0) {
            // 匹配关键字正则
            let replaceReg = new RegExp(this.addTagInput, 'g');
            // 高亮替换v-html值
            let replaceString = '<span style="color: #b94a48">' + this.addTagInput + '</span>';
            // 开始替换
            titleString = titleString.replace(replaceReg, replaceString);
          }
          item.label = titleString;
          console.log(titleString);
        }
      } else {
        this.dataList = JSON.parse(JSON.stringify(this.dtlList))
      }
      this.$forceUpdate();
    }
  },
  components: {
    qhtag
  }
}
</script>

<style scoped>
.search-text{
  color: #DD4A68;
}
.keywordsTag {
  border: 1px solid #dcdfe6;
  border-radius: 5px;
  padding: 3px;
}
.div_keywords{

}
.keywordsTag .el-input {
  display: inline-block;
  width: 80px;
}

.keywordsTag .el-input__inner {
  border-color: #fff;
}

.input-new-tag {
  -webkit-appearance: none;
  background-color: rgb(255, 255, 255);
  background-image: none;
  box-sizing: border-box;
  color: rgb(96, 98, 102);
  display: inline-block;
  font-size: 12px;
  height: 24px;
  line-height: 24px;
  border: none;
  outline: none;
  padding-left: 5px;
  transition: border-color 0.2s cubic-bezier(0.645, 0.045, 0.355, 1) 0s;
}

/* 选项列表盒子 */
.cw-input-select_pop {
  position: absolute;
  background-color: white;
  border: 1px solid #E4E7ED;
  border-radius: 9px;
  max-height: 220px;
  width: 200px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
  margin-top: 5px;
  padding: 5px;
  padding-top:0;
  padding-right: 0;
  box-sizing: border-box;
  z-index: 9999;
}

/*自定义滚动条样式*/
.cw-input-select_options::-webkit-scrollbar { /*滚动条整体样式*/
  width: 6px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 0;
}

.cw-input-select_options::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 3px;
  background-color: rgba(144, 147, 153, 0.1); /* 重点在这里！！ */
  transition: background-color 0.3s;
  height: 20px;
  /*-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);*/
  /*background-color: #555;*/
}

.cw-input-select_options:hover::-webkit-scrollbar-thumb {
  background-color: rgba(144, 147, 153, 0.5);
}

.cw-input-select_options::-webkit-scrollbar-track { /*滚动条里面轨道*/
  border-radius: 0;
  background: transparent;
}

/* 选项列表内容 */
.cw-input-select_options {
  display: block;
  margin-bottom: 0;
  max-height: 200px;
  width: 190px;
  margin-top:5px;
  overflow-y: scroll; /* 超出滚动 */
}

/* 选项单元 */
.cw-input-select_options li {
  padding: 0 10px;
  margin-bottom: 3px;
  margin-left: 0;
  margin-right: 0;
  background-color: white;
  cursor: pointer;
}

/* 选项单元hover */
.cw-input-select_options li:hover {
  background-color: rgb(210, 234, 252);
}
</style>

