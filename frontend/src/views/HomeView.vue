<template>
  <div class="home" style="heigh: 100%">
    <el-container style="height: 100%;">
      <el-aside width="sideWidth+'px'" style="background-color: rgb(238, 241, 246); height: 100% overflow-x: hidden; box-shadow:2px 0 6px rgb(0 21 41 / 35%)" > 
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x:hidden;" 
        :collapse="isCollapsed"
        background-color="rgb(48,65,86)"
        text-color="#fff"
        active-text-color="#ffd04b"
        :collapse-transition="false"
        class="el-menu-vertival-demo"
        >   
        <div style="height:60px;line-height:60px;text-align:center">
          <img src="../assets/logo.png" style="width:20px; position:relative; top:5px; margin-right:5px">
          <b style="color:white" v-show="logoTextShow">后台管理系统</b>
        </div>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>
            <span slot="title">导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>
            <span slot="title">导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>
      
      <el-container>
        <el-header style="font-size: 12px; border-bottom:1px solid #ccc;line-height:60px;display:flex">
          <div style="flex:1; font-size:18px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>
          <el-dropdown style="width: 100px;cursor:pointer">
            <span>王小虎</span>
            <i class="el-icon-arrow-down" style="margin-right: 20px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>
        
        <el-main>
          <div style="margin-bottom:30px;">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
            
          <div style="margin:10px 0">
            <el-input style="width:200px" suffix-icon="el-icon-search" placeholder="Search by Name" v-model="username"></el-input>
            <el-input style="width:200px" suffix-icon="el-icon-search" placeholder="Search by Nickname" v-model="nickname"></el-input>
            <el-input style="width:200px" suffix-icon="el-icon-search" placeholder="Search by Address" v-model="address"></el-input>
            <el-button style="margin-left:5px" type="primary" @click="load">搜索</el-button>
            <el-button style="margin-left:5px" type="warning" @click="reset">重置</el-button>
          </div>

         <div style="margin:10px 0">
            <el-button type="primary" @click="handleAdd">新增<i class="el-icon-circle-plus-outline"></i></el-button>

             <el-popconfirm
                  style="padding:5px"
                  confirm-button-text='确定'
                  cancel-button-text='再想想'
                  icon="el-icon-info"
                  icon-color="red"
                  title="您确定批量删除吗？"
                  @confirm="delBatch"
                >
            <el-button type="danger" slot = "reference">批量删除<i class="el-icon-remove-outline"></i></el-button>
             </el-popconfirm>
            <el-button type="primary" >导入<i class="el-icon-bottom"></i></el-button>
            <el-button type="primary" >导出<i class="el-icon-top"></i></el-button>
          </div> 

          <el-table :data="tableData" border striped @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="id" label="ID" width="80">
            </el-table-column>
            <el-table-column prop="username" label="用户名" width="140">
            </el-table-column>
            <el-table-column prop="nickname" label="昵称" width="120">
            </el-table-column>
            <el-table-column prop="email" label="邮箱">
            </el-table-column>
            <el-table-column prop="phone" label="电话">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
                <el-popconfirm
                  style="padding: 5px"
                  confirm-button-text='确定'
                  cancel-button-text='再想想'
                  icon="el-icon-info"
                  icon-color="red"
                  title="您确定删除吗？"
                  @confirm="del(scope.row.id)"
                >
                <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
                </el-popconfirm>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[2, 10, 15, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </div>

            <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width=30%>
            <el-form label-width=120px size="small">
              <el-form-item label="用户名">
                <el-input v-model="form.username" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="昵称">
                <el-input v-model="form.nickname" autocomplete="off"></el-input>
              </el-form-item> 
             <el-form-item label="邮箱">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="form.phone" autocomplete="off"></el-input>
              </el-form-item>
               <el-form-item label="地址">
                <el-input v-model="form.address" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="save">确 定</el-button>
            </div>
          </el-dialog>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import request from '../utils/request'

export default {
  name: 'HomeView',
  data(){
      return {
        tableData: [],
        pageNum:1,
        pageSize:2,
        username:"",
        nickname:"",
        address:"",
        form:{},
        multipleSelection:[],
        isCollapsed:false,
        sidewidth:200,
        collapseBtnClass:'el-icon-s-fold',
        logoTextShow:true,
        total:0,
        dialogFormVisible:false,
      }
  },

  created(){
    this.load()
  },
  
  
  methods: {
    collapse(){
      this.isCollapsed = !this.isCollapsed;
      if(this.isCollapsed){ 
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      }
      else{
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },
    save(){
      request.post("/user",this.form).then(res => {
        if(res){
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        }
        else{
          this.$message.error("保存失败")
        }
      })
    },
    load(){
       request.get("/user/page",{
        params: {
          pageNum:this.pageNum,
          pageSize:this.pageSize,
          username:this.username,
          nickname:this.nickname,
          address:this.address
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.records;
        this.total = res.total;
      }).catch(err => { console.log(err) })
      // fetch("http://localhost:8081/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username=" + this.username)
      // .then(res => res.json()).then(res =>{
      //   console.log(res)
      //   this.tableData = res.data
      //   this.total = res.total
      // }) 
    },
    reset(){
      this.username = "",
      this.nickname = "",
      this.address = "",
      this.load()
    },
    handleEdit(row){
      this.dialogFormVisible = true
      this.form = row
    },
    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    del(id){
      request.delete("/user/"+id).then(res =>{
        if (res){
          this.$message.success("删除成功")
          this.load()
        }
        else{
          this.$message.error("删除失败")
        }
      })
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    },
    handleSelectionChange(val){
      console.log(val)
      this.multipleSelection = val
    },
    delBatch(){
      let ids = this.multipleSelection.map(v => v.id)
      request.post("/user/del/batch",ids).then(res =>{
        if (res){
          this.$message.success("删除成功")
          this.load()
        }
        else{
          this.$message.error("删除失败")
        }
      }) 
    },
    handleAdd(){
      this.dialogFormVisible = true
      this.form = {}
    }
  }
}
</script>
