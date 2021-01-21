<template>
    <div :class="classes" :style="`backgroundColor:${color}`">
    <span @click="handleClose" :title="text" style="min-width: 100px">
    {{text}}</span>
    </div>
</template>
<script>
export default {
    name:'qhtag',
    data(){
        return {
            classes: []
        }
    },
    props:{
        text:String,
        closable:Boolean,
        type:String,
        hit:Boolean,
        color:String,
        size:String,
        effect:{
            type:String,
            default:'light',
            validator(val){
                return ['dark', 'light', 'plain'].indexOf(val) !== -1
            }
        }
    },
    methods:{
        handleClose(event){
            event.stopPropagation();
            this.$emit('close',event);
        },
        handleClick(event){
            this.$emit('click',event);
        }
    },computed:{
        tagSize() {
            return this.size || (this.$VUEQH || {}).size;
        },

    },
    mounted(){
        const {type,tagSize,hit,effect} = this
        this.classes = ['qh-tag',
                type ? `qh-tag--${type}` : '',
                tagSize ? `qh-tag--${tagSize}` : '',
                effect ? `qh-tag--${effect}` : '',
                hit && 'is-hit'
            ];

    }
}
</script>
<style scoped>
.qh-tag {
    display: inline-block;
    border: 1px solid rgb(198, 226, 255);
    background-color: rgb(232, 245, 255);
    border-radius: 3px;
    margin:5px 5px;
    padding: 3px;
    padding-left: 8px;
    padding-top: 0px;
    padding-bottom: 0px;
    font-size: 12px;
    color: #409EFF;
}
.qh-tag:hover {
    border: 1px solid rgb(198, 226, 255);
    background-color: rgb(217, 236, 255);

}
.qh-tag > span{
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    display: inline-block;
    vertical-align: middle;
}
.iconfont {
    font-size: 12px;
}
.iconguanbi{
    cursor: pointer;
    vertical-align: middle;
}
</style>
<style>
.del-btn {
   /*  position: absolute;
    top: 100%;
    left: 50%; */
    position: relative;
    display: inline-block;
    width: 12px;
    height: 12px;
    background-color: #409eff;
    border-radius: 50%;
    box-shadow: 0 0 2px rgba(0,0,0,.15);
    cursor: pointer;
    /*transition: all .35s ease*/
    transform:rotate(45deg);
    -ms-transform:rotate(45deg); /* Internet Explorer */
    -moz-transform:rotate(45deg); /* Firefox */
    -webkit-transform:rotate(45deg); /* Safari 和 Chrome */
    -o-transform:rotate(45deg); /* Opera */
}

.del-btn:hover {
    background-color: rgb(102, 177, 255);
    transform:rotate(45deg);
    -ms-transform:rotate(45deg); /* Internet Explorer */
    -moz-transform:rotate(45deg); /* Firefox */
    -webkit-transform:rotate(45deg); /* Safari 和 Chrome */
    -o-transform:rotate(45deg); /* Opera */
}

.del-btn:after,.del-btn:before {
    content: "";
    position: absolute
}

.del-btn:before {
    top: 50%;
    left: 2px;
    right: 2px;
    height: 0;
    border-top: 1px solid #fff
}

.del-btn:after {
    top: 2px;
    left: 50%;
    bottom: 2px;
    width: 0;
    border-left: 1px solid #fff
}
</style>




