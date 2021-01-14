<template> 
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">单位列表</span>
      <el-button
        class="btn-add"
        @click="umAddUnitInfo()"
        size="mini">
        添加
      </el-button>
    </el-card>
    <div class="table-container">
      <el-table ref="unitInfoListTable"
                style="width: 100%"
                :data="list"
                v-loading="listLoading"
                border>
        <el-table-column label="药物顺序号" width="200" align="center">
          <template slot-scope="scope">{{scope.row.unitSeq}}</template>
        </el-table-column>
        <el-table-column label="单位中文名称" width="250"  align="center">
          <template slot-scope="scope">{{scope.row.unitName}}</template>
        </el-table-column>
        <el-table-column label="单位缩写" width="250" align="center">
          <template slot-scope="scope">{{scope.row.unitShortName}}</template>
        </el-table-column>
        <el-table-column label="创建日期" width="250" align="center">
          <template slot-scope="scope">{{scope.row.createDate | formatDate}}</template>
        </el-table-column>
        <el-table-column label="操作用户" width="250" align="center">
          <template slot-scope="scope">{{scope.row.createUserId}}</template>
        </el-table-column>
        <el-table-column label="操作" width="250" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleUpdate(scope.$index, scope.row)">编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :page-size="listQuery.pageSize"
        :page-sizes="[5,10,15]"
        :current-page.sync="listQuery.pageNum"
        :total="total">
      </el-pagination>
    </div>
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="30%">
      <el-form ref="unitManageAddForm":model="unitManage" :rules="rules">
        <el-form-item label="单位中文名" prop="unitName" >
          <el-input v-model="unitManage.unitName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="单位缩写（克->g）" prop="unitShortName">
          <el-input v-model="unitManage.unitShortName" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleConfirm('unitManageAddForm')">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
  import {createUnit, fetchList, updateUnitInfo, deleteUnitInfo} from '@/api/param/unitManage.js'
  import {formatDate} from '@/utils/date';

  export default {
    name: 'unitManage',
    data() {
      return {
        list: null,
        total: null,
        listLoading: true,
        listQuery: {
          pageNum: 1,
          pageSize: 5
        },
        dialogVisible: false,
        dialogTitle:'',
        unitManage:{
          unitName:'',
          unitShortName:''
        },
        productAttrCate:{
          name:'',
          id:null
        },
        rules: {
          name: [
            { required: true, message: '请输入类型名称', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      this.getList();
    },
    filters:{
      formatDate(date) {
        if (date == null || date === '') {
          return 'N/A';
        }
        let time = new Date(date);
        return formatDate(time, 'yyyy-MM-dd')
      }
    },
    methods: {
      getList() {
        this.listLoading = true;
        fetchList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },
      umAddUnitInfo() {
        this.dialogVisible = true;
        this.dialogTitle = "添加计数单位";
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
      handleDelete(index, row) {
        this.$confirm('是否要删除该计量单位', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteUnitInfo(row.unitSeq).then(response=>{
            this.$message({
              message: '删除成功',
              type: 'success',
              duration:1000
            });
            this.getList();
          });
        });
      },
      handleUpdate(index, row) {
        this.dialogVisible = true;
        this.dialogTitle = "编辑单位";
        this.unitManage.changeSeq = row.unitSeq;
        this.unitManage.unitName = row.unitName;
        this.unitManage.unitShortName = row.unitShortName;
      },
      getAttrList(index, row) {
        this.$router.push({path: '/pms/productAttrList',query:{cid:row.id,cname:row.name,type:0}})
      },
      getParamList(index, row) {
        this.$router.push({path: '/pms/productAttrList',query:{cid:row.id,cname:row.name,type:1}})
      },
      handleConfirm(formName){
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let addData = {
              unitName:this.unitManage.unitName,
              unitShortName:this.unitManage.unitShortName
            };
            if(this.dialogTitle==="添加计数单位"){
              createUnit(addData).then(response=>{
                this.$message({
                  message: '添加成功',
                  type: 'success',
                  duration:1000
                });
                this.dialogVisible = false;
                this.getList();
              });
            }else{
              updateUnitInfo(this.unitManage.changeSeq,addData).then(response=>{
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration:1000
                });
                this.dialogVisible = false;
                this.getList();
              });
            }
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
</style>


