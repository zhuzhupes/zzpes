<template>
  <div :class="'div_keywords'" style="border: 1px solid #dcdfe6;border-radius: 5px;padding: 3px;">
    <div>
      <qhtag v-for="(item, index) in value"
             size="small"
             :key="item[_key]"
             :text="getText(item)"
             @click="close()"
             type @close="inputBox(item)">
      </qhtag>
    </div>
    <div>
      <input type="text" class="input-new-tag"
             autocomplete="off"
             :placeholder="placeholder"
             v-model.trim="addTagInput"
             :style="{width:width}"
             :maxlength="maxLen"/>
    </div>
    <div class="cw-input-select_pop" v-show="false">
      <ul class="cw-input-select_options">
        <li>
          <span>请选择...</span>
        </li>
        <li v-for="option in dtlList" v-on:click="selected(option)"
            :style="getStyle(option)">
          <span>{{ getText(option) }}</span>
        </li>

      </ul>
      <!--        <span class="cw-input-select_arrow"></span>-->
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
      addTagInput: "",
      dataList: []
    }
  },
  props: ["value",
    "maxLen",
    "keyword",
    "showVals",
    "placeholder",
    "_key",

    "width",
    "dtlList"
  ], //' maxLen最大输入字符数，keyWords代表数据必传'
  watch: {
    addTagInput:{

    },
    list: {
      handler(val) {
        this.$emit('change', val);
      }
    },
    dtlList: function () {
      this.dataList = this.dtlList;
      this.$forceUpdate();
      console.log(this.dataList);
    }
  },
  computed: {
    list() {
      return this.value;
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
    this.dataList = this.dtlList;
  },
  methods: {
    /**
     * 获取option的显示text字段
     * @param option
     * @returns {*}
     */
    getText(option) {
      let txt = '';
      if (this.showVals != null) {
        if (this.showVals instanceof Array) {
          //显示字段s是数组
          for (var key of this.showVals) {
            if (option[key] !== null) {
              if (txt === '') {
                txt = option[key];
              } else {
                txt = txt + '/' + option[key];
              }
            }
          }
        } else if (this.showVals instanceof String) {
          //显示字段s是字符串
          txt = option[this.showVals]
        }
      }
      return txt;
    },
    getStyle(option) {
      if (checkIsIn(option, this.value, null) !== -1) {
        return {backgroundColor: '#D2EAFC'};
      } else {
        return {};
      }
    },
    checkOption(option) {
      return true;
    },
    selected(option) {
      console.log("选中.....");
      let index = checkIsIn(option, this.value, this.keyword);
      if (index === -1) {
        this.value.push(option);
      } else {
        this.value.splice(index, 1);
      }
    },
    inputBox(en) {
      this.list.forEach((e, i) => {
        if (e === en) {
          this.list.splice(i, 1);
        }
      });
    }
  },
  components: {
    qhtag
  }
}
</script>

<style scoped>
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

