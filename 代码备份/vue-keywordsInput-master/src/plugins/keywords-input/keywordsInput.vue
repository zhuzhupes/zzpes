<template>
    <div class="keywordsTag" :class="'keywordsTag_'+_key" @click="focusInput">
        <qh-tag v-for="(site, index) in value" size="small" :text="site" :key="index" :closable="true" type @close="inputBox(site)">
        </qh-tag>
        <input type="text" class="input-new-tag" autocomplete="off" placeholder='请输入内容' 
            v-model.trim="addTagInput"  
            @blur="addTag" 
            v-on:keyup.enter="addTag"
            :maxlength="maxLen"/>
    </div>
</template>
<script>
export default {
    name:'keywordsinput',
    data(){
        return{
            addTagInput: "",
        }
    },
    props:["value","maxLen","_key"], //'_key用于一个页面中同时使用多个该组件; maxLen最大输入字符数，keyWords代表数据必传'
    watch:{
        list:{
            handler(val){
                this.$emit('change',val);
            }
        }
    },
    computed:{
        list(){
            return this.value
        }
    },
    methods:{
        focusInput() {
            document.getElementsByClassName('keywordsTag_'+this._key)[0].getElementsByTagName("input")[0].focus();
        },
        addTag(e) {
            if (!this.addTagInput) return;
            this.list.push(this.addTagInput);
            this.addTagInput = "";
        },
        inputBox(en) {
            this.list.forEach((e, i) => {
                if (e == en) {
                    this.list.splice(i, 1);
                }
            });
        }
    },
}
</script>

<style scoped>
.keywordsTag {
    border: 1px solid #dcdfe6;
    border-radius: 5px;
    padding: 3px;
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
    border-radius: 4px;
    border-width: 1px;
    border-style: solid;
    border-color: rgb(220, 223, 230);
    border-image: initial;
    outline: none;
    padding: 0px 8px;
    transition: border-color 0.2s cubic-bezier(0.645, 0.045, 0.355, 1) 0s;
}
</style>

