<template>
<div>
    <el-table
            :data="tableData"
            border
            style="width: 100%">
        <el-table-column
                fixed
                prop="emid"
                label="id"
                width="150">
        </el-table-column>
        <el-table-column
                prop="password"
                label="密码"
                width="120">
        </el-table-column>
        <el-table-column
                prop="name"
                label="姓名"
                width="120">
        </el-table-column>
        <el-table-column
                prop="age"
                label="年龄"
                width="120">
        </el-table-column>
        <el-table-column
                prop="gender"
                label="性别"
                width="120">
        </el-table-column>
        <el-table-column
                prop="identity"
                label="身份证"
                width="120">
        </el-table-column>
        <el-table-column
                prop="bankid"
                label="银行卡号"
                width="120">
        </el-table-column>
        <el-table-column
                prop="tel"
                label="手机"
                width="120">
        </el-table-column>
        <el-table-column
                prop="department"
                label="部门"
                width="120">
        </el-table-column>
        <el-table-column
                prop="position"
                label="单位"
                width="120">
        </el-table-column>
        <el-table-column
                prop="note"
                label="备注"
                width="120">
        </el-table-column>

        <el-table-column
                fixed="right"
                label="操作"
                width="100">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                <el-button type="text" size="small">编辑</el-button>
            </template>
        </el-table-column>
    </el-table>
    <div class="block">
        <span class="demonstration"></span>
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage4"
                :page-sizes="[5, 10, 20, 50]"
                :page-size="100"
                layout="total, sizes, prev, pager, next, jumper"
                :total="100">
        </el-pagination>
    </div>
</div>
</template>
<script>
    export default{
        name: "user",
        data() {
            return {
                tableData: [{

                }],
                userList:[],
                pagination:{
                    total:0,
                    pageSize:2,
                    pageSizes:[2,4,6,8,10],
                },
                queryParam:{
                    pageSize:2,
                    pageNumber:1,
                },
                currentPage1: 5,
                currentPage2: 5,
                currentPage3: 5,
                currentPage4: 4
            }
        },
        methods: {
            /*pageUserList:function () {
                // axios.get("http://localhost:8181/Employee/findAll").then(function (a) {
                //     user.tableData=a.data
                //
                //
                // })
                $.ajax({
                    type:"post",
                    url:"http://localhost:8181/Employee/queryEmployee",
                    dateType:"json",
                    contentType : 'application/json',
                    data:JSON.stringify(this.queryParam),
                    success:function(result){
                        user.userList=result.list;
                        user.pagination.total=result.totalCount;
                        // 重新加载数据，即重新请求数据，并加载
                        console.log(user.userList);
                        // data:JSON.stringify(this.queryParam),
                        // 因为对象是不能在网络中传输的，（Json对象也是对象），所以这里要将json对象转换成json字符串
                        // 然后再传输，后台的springmvc的@RequesyBody会将json字符串再转换成对象

                        //这个地方尤其要注意一定要指定contentType的值为『"application/json"』 ，因为此处@RequestBody接受的是一个通过json转换的对象
                        //如果不设置，默认为text/html,那么是支持该种类型的，会报415错误
                    }
                });
            },
            handleSizeChange:function(pageSize) {
                user.queryParam.pageSize=pageSize;
                this.pageUserList();
            },
            handleCurrentChange:function (currentPage) {
                user.queryParam.pageNumber=currentPage;
                this.pageUserList();
            }*/
        },
        created:function() {
            var userData=this
            axios.get("http://localhost:8181/Employee/findAll").then(function (user) {
                userData.tableData=user.data
                console.log(user)

            })
            //this.pageUserList();
        },

    };
</script>
<style scoped>

</style>