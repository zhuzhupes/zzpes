<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <!--      <i class="el-icon-search"></i>-->
        <span>角色信息</span>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="职业：" style="width: 25%">
            <el-select v-model="listQuery.ocptId" placeholder="选择性别" clearable style="width: 200px">
              <el-option
                v-for="item in ocptOptions"
                :key="item.ocptId"
                :label="item.ocptName"
                :value="item.ocptId">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="width: 50%">
            <el-form-item label="体型：" >
              <el-select v-model="listQuery.ocptId" placeholder="选择性别" clearable style="width: 200px">
                <el-option
                  v-for="item in ocptOptions"
                  :key="item.ocptId"
                  :label="item.ocptName"
                  :value="item.ocptId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form-item>
        </el-form>
      </div>
      <div style="width: 100%; border:3px solid rgba(21,64,24,0.31)">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px" style="margin-top: 15px">
          <el-form-item label="已选症状：">
          </el-form-item>
          <el-form-item  v-for="item in selectEdSymptomList">
            <span class="el-input__inner" @click="removeItemInList(item.value, selectEdSymptomList)">{{item.label}}</span>
          </el-form-item>
        </el-form>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="选用药物：">
            <el-select v-model="listQuery.herb" placeholder="" clearable @change="changeHerb()">
              <el-option
                v-for="item in herbList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="用量：">
              <el-input style="width: 100px" v-model="listQuery.herb_nums" placeholder="用量数量"></el-input>
            <el-select v-model="listQuery.unit_type" placeholder="单位" style="width: 100px"  clearable >
              <el-option
                v-for="item in unitList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="额外操作：">
            <el-select v-model="listQuery.opeation_type" placeholder="操作类型" style="width: 100px"  clearable >
              <el-option
                v-for="item in operationList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
            <el-input style="width: 80px" v-model="listQuery.operation_value" placeholder="操作量"></el-input>
            <el-select v-model="listQuery.operation_unit" placeholder="操作计数单位"  style="width: 100px" clearable >
              <el-option
                v-for="item in operationUnitList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
            <el-button
              style="float: right;margin-left: 15px"
              @click="addHerbToList()"
              size="small">
              添加
            </el-button>
          </el-form-item>
        </el-form>
      </div>

      <div style="width: 100%; border:3px solid rgba(21,64,24,0.31)">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px" style="margin-top: 15px" ref="prescriptionForm">
          <el-form-item label="已选药材：">
          </el-form-item>
          <el-form-item  v-for="item in prescriptionInfoList">
            <span class="el-input__inner" @click="removeItemInList(item.value, prescriptionInfoList)">{{item.label}}</span>
          </el-form-item>
        </el-form>
      </div>

      <div style="width:100%; text-align: center">
        <el-button
          style="float: right"
          @click="handleSearchList()"
          type="primary"
          size="small">
          生成药方
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
      <span>数据列表333</span>
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
        symptomList:[
          {
            label: "头痛",
            value: "publishOn"
          },
          {
            label: "脚痛",
            value: "publishOff"
          }
        ],

        selectEdSymptomList:[

        ],
        operates: [
          {
            label: "商品上架",
            value: "publishOn"
          },
          {
            label: "商品下架",
            value: "publishOff"
          },
          {
            label: "设为推荐",
            value: "recommendOn"
          },
          {
            label: "取消推荐",
            value: "recommendOff"
          },
          {
            label: "设为新品",
            value: "newOn"
          },
          {
            label: "取消新品",
            value: "newOff"
          },
          {
            label: "转移到分类",
            value: "transferCategory"
          },
          {
            label: "移入回收站",
            value: "recycle"
          },

        ],
        prescriptionList : [

        ],
        operateType: null,
        listQuery: Object.assign({}, defaultListQuery),
        list: null,
        total: null,
        listLoading: true,
        selectProductCateValue: null,
        multipleSelection: [],
        productCateOptions: [],
        brandOptions: [],
        publishStatusOptions: [{
          value: 1,
          label: '上架'
        }, {
          value: 0,
          label: '下架'
        }],
        verifyStatusOptions: [{
          value: 1,
          label: '审核通过'
        }, {
          value: 0,
          label: '未审核'
        }],

        sexualityOptions:[{
          value:0,
          label:'男'
        },{
          value:1,
          label: '女'
        }],
        ocptOptions:[],
        bodyShapeOptions:[],


        prescriptionInfoList:[],
        herbList:[],
        unitList:[],
        operationList:[],
        operationUnitList:[]

      }
    },
    created() {
      // this.getList();
      // this.getBrandList();
      // this.getProductCateList();
      // this.getherbsList();
      this.getOcptList();
    },
    watch: {
      selectProductCateValue: function (newValue) {
        if (newValue != null && newValue.length == 2) {
          this.listQuery.productCategoryId = newValue[1];
        } else {
          this.listQuery.productCategoryId = null;
        }

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
      addHerbToList(){
        let isAdded = false;
        if(this.listQuery.herb == undefined || this.listQuery.herb == ""){
          this.showInfo("请选择药物名字", 1);
          return;
        }
        if(this.listQuery.herb_nums == undefined || this.listQuery.herb_nums == ""){
          this.showInfo("请输入药物用量", 1);
          return;
        }
        if(this.listQuery.unit_type == undefined || this.listQuery.unit_type == ""){
          this.showInfo("请选择药物用量单位", 1);
          return;
        }
        if( !((this.listQuery.opeation_type == undefined || this.listQuery.opeation_type == "")
          &&(this.listQuery.operation_value == undefined || this.listQuery.operation_value == "")
          &&(this.listQuery.operation_unit == undefined || this.listQuery.operation_unit == "")||
          (this.listQuery.opeation_type != undefined && this.listQuery.opeation_type !=  "")
          &&(this.listQuery.operation_value !=  undefined && this.listQuery.operation_value !=  "")
          &&(this.listQuery.operation_unit !=  undefined && this.listQuery.operation_unit !=  ""))
        ){
          this.showInfo("请正确选择额外操作信息", 1);
          return;
        }
        for(let i in this.prescriptionList){
          if(this.prescriptionList[i].herb == this.listQuery.herb){
            isAdded = true;
            break;
          }
        }
        if(!isAdded){
          this.prescriptionList.push({
            herb: this.listQuery.herb,//药物名字
            herb_nums: this.listQuery.herb_nums,//药物用量
            unit_type: this.listQuery.unit_type,//药物用量单位
            opeation_type: this.listQuery.opeation_type,//额外操作类型
            operation_value: this.listQuery.operation_value,//额外操作量
            operation_unit: this.listQuery.operation_unit,//额外操作单位
          });
          //药品中文名字
          let herb_name = "";
          for(let i in this.herbList){
            if(this.herbList[i].value ==  this.listQuery.herb){
              herb_name = this.herbList[i].label;
            }
          }
          //药品用量单位名字
          let unit_name = "";
          let unit_short = "";
          for(let i in this.unitList){
            if(this.unitList[i].value ==  this.listQuery.unit_type){
              unit_name = this.unitList[i].label;
              unit_short = this.unitList[i].short;
            }
          }
          //药品操作类型名字
          let operationName = "";
          for(let i in this.operationList){
            if(this.operationList[i].value ==  this.listQuery.opeation_type){
              operationName = this.operationList[i].label;
            }
          }
          //药品操作类型单位
          let operationUnitName = "";
          let operationUnitShort = "";
          for(let i in this.operationUnitList){
            if(this.operationUnitList[i].value ==  this.listQuery.operation_unit){
              operationUnitName = this.operationUnitList[i].label;
              operationUnitShort = this.operationUnitList[i].short;
            }
          }
          let names = "";
          names = herb_name + "X" + this.listQuery.herb_nums + unit_short;
          if(operationName != ""){
            names = names + "(" + operationName + "X" + this.listQuery.operation_value + operationUnitShort +")";
          }
          this.prescriptionInfoList.push({
            value:this.prescriptionList.length,
            label:names
          });
          this.$forceUpdate();
        }else{
          this.showInfo("您已经添加过该药", 1);
        }
      },

      changeHerb(){

      },
      addItemToList(item, AllList, list){
        for(var key in AllList){
          if(AllList[key].value == item){
            var flag = true;
            for(var index in list){
              if(list[index].value == item){
                flag = false;
                break;
              }
            }
            if(flag){
              list[list.length] = AllList[key];
            }
            break;
          }
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
      getProductSkuSp(row, index) {
        let spData = JSON.parse(row.spData);
        if(spData!=null&&index<spData.length){
          return spData[index].value;
        }else{
          return null;
        }
      },
      getList() {
        this.listLoading = true;
        fetchList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },
      getBrandList() {
        fetchBrandList({pageNum: 1, pageSize: 100}).then(response => {
          this.brandOptions = [];
          let brandList = response.data.list;
          for (let i = 0; i < brandList.length; i++) {
            this.brandOptions.push({label: brandList[i].name, value: brandList[i].id});
          }
        });
      },

      showInfo(info, type) {
        if(type == 1){
          alert(info);
        }
      },
      getProductCateList() {
        fetchListWithChildren().then(response => {
          let list = response.data;
          this.productCateOptions = [];
          for (let i = 0; i < list.length; i++) {
            let children = [];
            if (list[i].children != null && list[i].children.length > 0) {
              for (let j = 0; j < list[i].children.length; j++) {
                children.push({label: list[i].children[j].name, value: list[i].children[j].id});
              }
            }
            this.productCateOptions.push({label: list[i].name, value: list[i].id, children: children});
          }
        });

      },

      getOcptList(){
        fetchOcptList().then(response => {
          this.ocptOptions = response.data.list;
        });
      },


      handleShowSkuEditDialog(index,row){
        this.editSkuInfo.dialogVisible=true;
        this.editSkuInfo.productId=row.id;
        this.editSkuInfo.productSn=row.productSn;
        this.editSkuInfo.productAttributeCategoryId = row.productAttributeCategoryId;
        this.editSkuInfo.keyword=null;
        fetchSkuStockList(row.id,{keyword:this.editSkuInfo.keyword}).then(response=>{
          this.editSkuInfo.stockList=response.data;
        });
        if(row.productAttributeCategoryId!=null){
          fetchProductAttrList(row.productAttributeCategoryId,{type:0}).then(response=>{
            this.editSkuInfo.productAttr=response.data.list;
          });
        }
      },
      handleSearchEditSku(){
        fetchSkuStockList(this.editSkuInfo.productId,{keyword:this.editSkuInfo.keyword}).then(response=>{
          this.editSkuInfo.stockList=response.data;
        });
      },
      handleEditSkuConfirm(){
        if(this.editSkuInfo.stockList==null||this.editSkuInfo.stockList.length<=0){
          this.$message({
            message: '暂无sku信息',
            type: 'warning',
            duration: 1000
          });
          return
        }
        this.$confirm('是否要进行修改', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=>{
          updateSkuStockList(this.editSkuInfo.productId,this.editSkuInfo.stockList).then(response=>{
            this.$message({
              message: '修改成功',
              type: 'success',
              duration: 1000
            });
            this.editSkuInfo.dialogVisible=false;
          });
        });
      },
      handleSearchList() {
        this.listQuery.pageNum = 1;
        this.getList();
      },
      handleAddProduct() {
        this.$router.push({path:'/pms/addProduct'});
      },
      handleBatchOperate() {
        if(this.operateType==null){
          this.$message({
            message: '请选择操作类型',
            type: 'warning',
            duration: 1000
          });
          return;
        }
        if(this.multipleSelection==null||this.multipleSelection.length<1){
          this.$message({
            message: '请选择要操作的商品',
            type: 'warning',
            duration: 1000
          });
          return;
        }
        this.$confirm('是否要进行该批量操作?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let ids=[];
          for(let i=0;i<this.multipleSelection.length;i++){
            ids.push(this.multipleSelection[i].id);
          }
          switch (this.operateType) {
            case this.operates[0].value:
              this.updatePublishStatus(1,ids);
              break;
            case this.operates[1].value:
              this.updatePublishStatus(0,ids);
              break;
            case this.operates[2].value:
              this.updateRecommendStatus(1,ids);
              break;
            case this.operates[3].value:
              this.updateRecommendStatus(0,ids);
              break;
            case this.operates[4].value:
              this.updateNewStatus(1,ids);
              break;
            case this.operates[5].value:
              this.updateNewStatus(0,ids);
              break;
            case this.operates[6].value:
              break;
            case this.operates[7].value:
              this.updateDeleteStatus(1,ids);
              break;
            default:
              break;
          }
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
    }
  }
</script>
<style></style>


