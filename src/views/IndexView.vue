<template>
  <div>
    <el-container>
      <el-header height="70px">
        <a href="/#/index"><h1 id="logo">啊彬科技</h1></a>
        <span class="head-title">双碳管理系统</span>
      
      </el-header>
        <el-container>
          <el-aside width="200px">
            <el-menu :router="true" :default-openeds="['zzst']" default-active="2" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff"
            active-text-color="#ffd04b">
            
            <el-submenu index="zzst">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>智造双碳</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="zzst/nxyj">能效预警</el-menu-item>
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
            
            <el-main>
                <router-view></router-view>
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

#logo {
  margin-left: 0;
  width: 210px;
  height: 60px;
  background: url(../assets/logo.gif);
  font-size: 0;
}

.el-aside {
    overflow: visible;
}

.el-header, .el-footer {
    padding: 2px;
    display: flex;
    align-items: center;
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 70px;
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
    line-height: 20px;
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
    margin-left: 30px;
    font-size: 30px;
    font-weight: bold;
}

.el-container,.el-menu-vertical-demo el-menu {
  height: 100.1vh;
}

.is-active {
  background-color: rgb(51 154 56);
}

.el-submenu {
  border-bottom: 1px solid rgb(255, 208, 75);
}


</style>