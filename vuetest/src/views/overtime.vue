<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%;height: auto">
            <el-table-column
                    fixed
                    prop="olid"
                    label="id"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="emid"
                    label="员工id"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="day"
                    label="day"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="hour"
                    label="小时"
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
                    <el-button @click="editClick(scope.row)" type="text" size="small">编辑</el-button>
                    <el-button @click="deleteClick(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="block">
            <span class="demonstration"></span>
            <el-pagination
                    @size-change="size"
                    @current-change="page"
                    :page-sizes="pagination.pageSizes"
                    :page-size="pagination.pageSize"
                    :current-page="pagination.currentpage"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="pagination.total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
    export default {
        name: "attendance",
        data() {
            return {
                tableData: [{}],
                pagination: {
                    total: 0,
                    pageSize: 4,
                    pageSizes: [2, 4, 6],
                    currentpage:1
                }
            }
        },
        methods: {
            editClick(row) {
                console.log(row.olid);
                this.$router.push({
                    path: "/overtimeUpdate",
                    query: {
                        olid: row.olid

                    }
                })
            },
            deleteClick(row) {
                const _this = this;
                axios.delete("http://localhost:8181/Overtime/delect/" + row.olid).then(function (resp) {
                    console.log(resp)
                    if (resp.status == 200) {
                        _this.$message({
                            message: row.olid + '删除成功',
                            type: 'success'
                        });

                    }
                    parent.location.reload();
                })
            },
            size(sizepage) {
                this.pagination.pagesize=sizepage
            },
            page(currentPage) {
                var pagesize =this.pagination.pagesize
                var userData = this
                axios.get("http://localhost:8181/Overtime/queryOvertime/" + (currentPage) + "/" + (pagesize)).then(function (resp) {
                    userData.tableData = resp.data.list
                    userData.pagination.total = resp.data.totalCount
                    userData.pagination.pagesize = resp.data.pageSize
                    console.log(resp)

                })

            },


        },
        created: function () {
            var userData = this
            axios.get("http://localhost:8181/Overtime/queryOvertime/1/4").then(function (resp) {
                userData.tableData = resp.data.list
                userData.pagination.total = resp.data.totalCount
                userData.pagination.pagesize = resp.data.pageSize
                console.log(resp)

            })

        }
    }
</script>
<style scoped>

</style>