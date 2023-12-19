<template>
    <div>
        <!-- 修改弹出框 -->
        <el-dialog title="修改能效检测点" :visible.sync="updateShow">
            <el-form ref="updateForm" :inline="true" :model="updateForm" label-width="100px">
                <el-form-item prop="name" label="检测点名称" :rules="[{required: true, message: '请输入监测点名称', trigger: 'blur'}]">
                    <el-input v-model="updateForm.name"></el-input>
                </el-form-item>

                <el-form-item prop="address" label="检测点地址" :rules="[{required: true, message: '请输入监测点地址', trigger: 'blur'}]">
                    <el-input v-model="updateForm.address"></el-input>
                </el-form-item>

                <el-form-item prop="power" label="实时功率" :rules="[{required: true, message: '请输入实时功率', trigger: 'blur'}, {type: 'number', message: '实时功率必须是数字'}]">
                    <el-input v-model.number="updateForm.power" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item prop="voltage" label="实时电压" :rules="[{required: true, message: '请输入实时电压', trigger: 'blur'}, {type: 'number', message: '实时电压必须是数字'}]">
                    <el-input v-model.number="updateForm.voltage" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item prop="status" label="状态" :rules="[{required: true, message: '请输入状态', trigger: 'blur'}]">
                    <el-input v-model="updateForm.status"></el-input>
                </el-form-item>

                <el-form-item prop="notes" label="备注">
                    <el-input v-model="updateForm.notes"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="warning" @click="updateShow = false">取消</el-button>
                <el-button type="primary" @click="update">修改</el-button>
            </div>
        </el-dialog>

        <!-- 查询弹出框 -->
        <div class="searchsession">
            <el-form :inline="true" :model="searchForm">

                <el-form-item label="检测点名称">
                    <el-input v-model="searchForm.name"></el-input>
                </el-form-item>

                <el-form-item label="检测点地址">
                    <el-input v-model="searchForm.address"></el-input>
                </el-form-item>

                <el-form-item label="状态">
                    <el-input v-model="searchForm.status"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="search">查询</el-button>
                </el-form-item>

                <el-form-item>
                    <el-button native-type="reset" type="primary">重置</el-button>
                </el-form-item>

            </el-form>
        </div>

        <!-- 添加按钮 -->
        <div class="addsession">
            <el-button type="success" @click="startAdd">新建</el-button>
        </div>

        <!-- 添加弹出框 -->
        <el-dialog title="添加能效检测点" :visible.sync="addShow">
            <el-form ref="addForm" :inline="true" :model="addForm" label-width="100px">
                <el-form-item prop="name" label="检测点名称" :rules="[{required: true, message: '请输入监测点名称', trigger: 'blur'}]">
                    <el-input v-model="addForm.name"></el-input>
                </el-form-item>

                <el-form-item prop="address" label="检测点地址" :rules="[{required: true, message: '请输入监测点地址', trigger: 'blur'}]">
                    <el-input v-model="addForm.address"></el-input>
                </el-form-item>

                <el-form-item prop="power" label="实时功率" :rules="[{required: true, message: '请输入实时功率', trigger: 'blur'}, {type: 'number', message: '实时功率必须是数字'}]">
                    <el-input v-model.number="addForm.power" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item prop="voltage" label="实时电压" :rules="[{required: true, message: '请输入实时电压', trigger: 'blur'}, {type: 'number', message: '实时电压必须是数字'}]">
                    <el-input v-model.number="addForm.voltage" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item prop="status" label="状态" :rules="[{required: true, message: '请输入状态', trigger: 'blur'}]">
                    <el-input v-model="addForm.status"></el-input>
                </el-form-item>

                <el-form-item prop="notes" label="备注">
                    <el-input v-model="addForm.notes"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="warning" @click="addShow = false">取消</el-button>
                <el-button type="primary" @click="add">添加</el-button>
            </div>
        </el-dialog>

        <div class="datalist">
            <template>
                <el-table v-loading="tableLoading" :data="nxWarn">
                    <el-table-column prop="id" width="80" label="编号"></el-table-column>
                    <el-table-column prop="name" width="150" label="监测点名称"></el-table-column>
                    <el-table-column prop="address" width="150" label="检测点地址"></el-table-column>
                    <el-table-column prop="power" width="120" label="实时功率"></el-table-column>
                    <el-table-column prop="voltage" width="120" label="实时电压"></el-table-column>
                    <el-table-column prop="status" width="80" label="状态"></el-table-column>
                    <el-table-column prop="date" width="150" label="上报时间"></el-table-column>
                    <el-table-column prop="notes" width="150" label="备注"></el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="item">
                            <el-button type="primary" @click="updateshow(item.row.id)" class="updateBth" size="small">修改</el-button>
                            <el-popconfirm @confirm="del(item.row.id)" title="你确认要删除吗？">
                                <el-button type="danger" size="small" slot="reference">删除</el-button>
                            </el-popconfirm>
                        </template>
                    </el-table-column>

                </el-table>
            </template>

        </div>
    </div>
</template>

<script>
export default {
    data(){
        return {
            tableLoading: true,
            addShow: false,
            updateShow: false,
            nxWarn:[],
            updateForm: {
                id: '', name: '', address: '', power: '', voltage: '', status: '', notes: ''
            },
            searchForm: {
                name: '', address: '', status: ''
            },
            addForm: {
                id: '', name: '', address: '', power: '', voltage: '', status: '', notes: ''
            },
        }
    },

    created () {
        //进入页面，发送请求，获取数据列表
        this.$axios.get('http://localhost:9090/nxyj/findall').then(res => {
            this.nxWarn = res.data.data
            this.tableLoading = false
        }).catch(() => {
            this.tableLoading = false
        })
    },
    methods: {
        startAdd(){
            this.addShow = true
            this.$refs.addForm.resetFields()
        },
        add(){
            this.$refs.addForm.validate(valid => {
                if(!valid){
                    //表单校验失败
                    this.$message.error('请正确填写所有必填项')
                    return
                }
            })
        },
        search(){
            alert('查询' + this.searchForm.name + this.searchForm.address + this.searchForm.status)
        },
        del(id){
            alert('删除 ' + id)
        },

        update(){
            //校验表单有没有通过
            this.$refs.updateForm.validate(valid => {
                if(!valid){
                    //表单校验失败
                    this.$message.error('请正确填写所有必填项')
                    return
                }
                //校验通过，提交
                alert('修改: ' + this.updateForm.id)
            })
            
        },
        updateshow(id){
            this.updateShow = true
            this.updateForm.id = id
            //清空 updateForm 表单
            this.updateForm.name = ''
            this.updateForm.address = ''
            this.updateForm.power = ''
            this.updateForm.voltage = ''
            this.updateForm.status = ''
            this.updateForm.notes = ''
        }
    }
}
</script>

<style>

.addsession {
    margin-bottom: 15px;
}


.updateBth {
    margin-right: 8px;
}

</style>