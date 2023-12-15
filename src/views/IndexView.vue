<template>
  <div>
    <el-container>
        <el-aside width="200px">
            <el-menu :default-openeds="['1']" default-active="2" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff"
            active-text-color="#ffd04b">
            
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>智造双碳</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="1-1">能效预警</el-menu-item>
                    <el-menu-item index="1-2">选项2</el-menu-item>
                </el-menu-item-group>
            </el-submenu>

            <el-submenu index="2">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>制造执行MES</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="2-1">项目维护</el-menu-item>
                    <el-menu-item index="2-2">工厂建模</el-menu-item>
                    <el-menu-item index="2-3">工艺建模</el-menu-item>
                </el-menu-item-group>
            </el-submenu>
        </el-menu>

    </el-aside>
        <el-container>
            <el-header><span class="head-title">双碳管理系统</span></el-header>
            <el-main>
                <h1>欢迎使用</h1>
            </el-main>
        </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
    data(){
        return {

        }
    }
}
</script>

<style>

.el-aside {
    overflow: visible;
}

.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

.head-title {
    font-size: 30px;
    font-weight: bold;
}


</style>