<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <!--      <i class="el-icon-search"></i>-->
        <span>角色信息</span>
      </div>

      <div style="margin-top: 15px">
        <el-form :inline="true" size="small" >
          <el-form-item label="外观：" label-width="150px">
          </el-form-item>
          <el-form-item style="width: 800px">
            <keywordsinput  @change="setKeywords" v-model="dtlList"
                            placeholder="有本事就点"
                            _key="dtlId"
                            @inputSearch="qryDtl"
                            width="800px"
                            :dtlList="dtlOptions"></keywordsinput>
          </el-form-item>
        </el-form>
      </div>

      <div style="margin-top: 15px">
        <el-form :inline="true" size="small" >
          <el-form-item label="职业选择：" label-width="150px">
          </el-form-item>
          <el-form-item style="width: 800px">
            <keywordsinput  @change="setKeywords" v-model="ocptList"
                            placeholder="我不想点"
                            :_key="'ocptId'"
                            width="800px"
                            :dtlList="ocptOptions"></keywordsinput>
          </el-form-item>
        </el-form>
      </div>
      <div style="margin-top: 15px" @click="dayinrizhi()">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="职业：" style="width: 40%">
            <el-select v-model="listQuery.ocptId" placeholder="选择职业" clearable style="width: 200px">
              <el-option
                v-for="item in ocptOptions"
                :key="item.ocptId"
                :label="item.ocptName"
                :value="item.ocptId">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="width: 40%">
            <el-form-item label="体型：" >
              <el-select v-model="listQuery.bodyShapeId" placeholder="选择体型" clearable style="width: 200px">
                <el-option
                  v-for="item in bodyShapeOptions"
                  :key="item.bodyShapeId"
                  :label="item.bodyShapeName"
                  :value="item.bodyShapeId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form-item>
          <el-form-item style="width: 40%">
            <el-form-item label="区服：" >
              <el-select v-model="listQuery.serverId" placeholder="选择区服" clearable style="width: 200px">
                <el-option
                  v-for="item in serverOptions"
                  :key="item.serverId"
                  :label="item.serverName"
                  :value="item.serverId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form-item>
          <el-form-item style="width: 40%">
            <el-form-item label="阵营：" >
              <el-select v-model="listQuery.campTypeId" placeholder="选择阵营" clearable style="width: 200px">
                <el-option
                  v-for="item in campOptions"
                  :key="item.campTypeId"
                  :label="item.campTypeName"
                  :value="item.campTypeId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form-item>
        </el-form>
      </div>
      <div style="width:100%; text-align: center; margin-top:20px">
        <el-button
          style="float: right"
          @click="handleSearchList()"
          type="primary"
          size="small">
          操作一下
        </el-button>
        <el-button
          style="float: right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          重置
        </el-button>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据信息</span>
      <el-button
        class="btn-add"
        @click="handleAddProduct()"
        size="mini">
        添加
      </el-button>
    </el-card>
  </div>


</template>










<script>
  import {
    fetchList,
    updateDeleteStatus,
    updateNewStatus,
    updateRecommendStatus,
    updatePublishStatus
  } from '@/api/product'
  import {fetchList as fetchSkuStockList,update as updateSkuStockList} from '@/api/skuStock'
  import {fetchList as fetchProductAttrList} from '@/api/productAttr'
  import {fetchList as fetchBrandList} from '@/api/brand'
  import {fetchOcptList} from '@/api/common/ocpt'
  import {fetchBdShapeList} from '@/api/common/bodyshape'
  import {fetchCampList} from '@/api/common/camp'
  import {fetchServerList} from '@/api/common/server'
  import keywordsinput from '@/components/keywords-input'
  import {vagueDtlQry} from '@/api/common/dtlvagueqry'
  import {addLabelToItem} from '@/api/commonUtils'


  const defaultListQuery = {
    keyword: null,
    pageNum: 1,
    pageSize: 5,
    publishStatus: null,
    verifyStatus: null,
    productSn: null,
    productCategoryId: null,
    brandId: null
  };
  export default {
    name: "productList",
    components:{
      keywordsinput
    },
    data() {
      return {
        editSkuInfo:{
          dialogVisible:false,
          productId:null,
          productSn:'',
          productAttributeCategoryId:null,
          stockList:[],
          productAttr:[],
          keyword:null
        },


        dtlList: [],
        dataList: [],
        dataList2:[],
        dataList3: [],
        ocptList: [],
        maxLen:18,
        msg: 'Welcome to Your Vue.js App',

        prescriptionList : [

        ],
        operateType: null,
        listQuery: Object.assign({}, defaultListQuery),
        list: null,
        total: null,
        listLoading: true,
        selectProductCateValue: null,


        ocptOptions:[],
        bodyShapeOptions:[],
        serverOptions:[],
        campOptions:[],
        dtlOptions: [],

      }
    },
    created() {
      this.getOcptList();
      this.getBodyShapeList();
      this.getServerList();
      this.getCampList();
      this.qryDtl('发');
    },
    watch: {
      selectProductCateValue: function (newValue) {
        //设置方法
      }
    },
    filters: {
      verifyStatusFilter(value) {
        if (value === 1) {
          return '审核通过';
        } else {
          return '未审核';
        }
      }
    },
    methods: {
      dtlInputText:function (newValue){
        console.log("输入了...");
      },
      setKeywords(v){
        // console.log(v)
      },
      dayinrizhi(){
        // console.log(this.dtlList);
      },
      initFormat() {
        if (!Array.isArray(this.dataList3)) {
          this.dataList2 = !!this.dataList3? this.dataList3.split(',') : [];
        }
      },



      removeItemInList(value, list){
        for(var item in list){
          if(list[item].value == value){
            list.splice(item, 1);
            this.$forceUpdate();
          }
        }
      },

      getOcptList(){
        fetchOcptList().then(response => {
          this.ocptOptions = response.data.list;
          this.ocptOptions = addLabelToItem(this.ocptOptions, ['ocptName'])
        });
      },
      getBodyShapeList(){
        fetchBdShapeList().then(response => {
          this.bodyShapeOptions = response.data.list;
        });
      },

      getServerList(){
        fetchServerList().then(response => {
          this.serverOptions = response.data.list;
        });
      },
      getCampList(){
        fetchCampList().then(response => {
          this.campOptions = response.data.list;
        });
      },
      qryDtl(value){
        vagueDtlQry('role_appearance_info', 'hair', value).then(response => {
          this.dtlOptions = response.data.list;
          this.dtlOptions = addLabelToItem(this.dtlOptions, ['dtlZhcnName', 'dtlZhcnName'])
        });
      },



      handleBatchOperate() {
        this.$confirm('是否要进行该批量操作?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.getList();
        });
      },
      handleSizeChange(val) {
        this.listQuery.pageNum = 1;
        this.listQuery.pageSize = val;
        this.getList();
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val;
        this.getList();
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      handlePublishStatusChange(index, row) {
        let ids = [];
        ids.push(row.id);
        this.updatePublishStatus(row.publishStatus, ids);
      },
      handleNewStatusChange(index, row) {
        let ids = [];
        ids.push(row.id);
        this.updateNewStatus(row.newStatus, ids);
      },
      handleRecommendStatusChange(index, row) {
        let ids = [];
        ids.push(row.id);
        this.updateRecommendStatus(row.recommandStatus, ids);
      },
      handleResetSearch() {
        this.selectProductCateValue = [];
        this.listQuery = Object.assign({}, defaultListQuery);
      },
      handleDelete(index, row){
        this.$confirm('是否要进行删除操作?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let ids = [];
          ids.push(row.id);
          this.updateDeleteStatus(1,ids);
        });
      },
      handleUpdateProduct(index,row){
        this.$router.push({path:'/pms/updateProduct',query:{id:row.id}});
      },
      handleShowProduct(index,row){
        console.log("handleShowProduct",row);
      },
      handleShowVerifyDetail(index,row){
        console.log("handleShowVerifyDetail",row);
      },
      handleShowLog(index,row){
        console.log("handleShowLog",row);
      },
      updatePublishStatus(publishStatus, ids) {
        let params = new URLSearchParams();
        params.append('ids', ids);
        params.append('publishStatus', publishStatus);
        updatePublishStatus(params).then(response => {
          this.$message({
            message: '修改成功',
            type: 'success',
            duration: 1000
          });
        });
      },
      updateNewStatus(newStatus, ids) {
        let params = new URLSearchParams();
        params.append('ids', ids);
        params.append('newStatus', newStatus);
        updateNewStatus(params).then(response => {
          this.$message({
            message: '修改成功',
            type: 'success',
            duration: 1000
          });
        });
      },
      updateRecommendStatus(recommendStatus, ids) {
        let params = new URLSearchParams();
        params.append('ids', ids);
        params.append('recommendStatus', recommendStatus);
        updateRecommendStatus(params).then(response => {
          this.$message({
            message: '修改成功',
            type: 'success',
            duration: 1000
          });
        });
      },
      updateDeleteStatus(deleteStatus, ids) {
        let params = new URLSearchParams();
        params.append('ids', ids);
        params.append('deleteStatus', deleteStatus);
        updateDeleteStatus(params).then(response => {
          this.$message({
            message: '删除成功',
            type: 'success',
            duration: 1000
          });
        });
        this.getList();
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

<style>
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
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>



